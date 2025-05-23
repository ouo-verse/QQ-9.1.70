package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.constants.AECameraConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NavDeepLink {
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private final String mAction;
    private final ArrayList<String> mArguments;
    private boolean mExactDeepLink;
    private boolean mIsParameterizedQuery;
    private final String mMimeType;
    private Pattern mMimeTypePattern;
    private final Map<String, ParamQuery> mParamArgMap;
    private Pattern mPattern;
    private final String mUri;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class Builder {
        private String mAction;
        private String mMimeType;
        private String mUriPattern;

        @NonNull
        public static Builder fromAction(@NonNull String str) {
            if (!str.isEmpty()) {
                Builder builder = new Builder();
                builder.setAction(str);
                return builder;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        @NonNull
        public static Builder fromMimeType(@NonNull String str) {
            Builder builder = new Builder();
            builder.setMimeType(str);
            return builder;
        }

        @NonNull
        public static Builder fromUriPattern(@NonNull String str) {
            Builder builder = new Builder();
            builder.setUriPattern(str);
            return builder;
        }

        @NonNull
        public NavDeepLink build() {
            return new NavDeepLink(this.mUriPattern, this.mAction, this.mMimeType);
        }

        @NonNull
        public Builder setAction(@NonNull String str) {
            if (!str.isEmpty()) {
                this.mAction = str;
                return this;
            }
            throw new IllegalArgumentException("The NavDeepLink cannot have an empty action.");
        }

        @NonNull
        public Builder setMimeType(@NonNull String str) {
            this.mMimeType = str;
            return this;
        }

        @NonNull
        public Builder setUriPattern(@NonNull String str) {
            this.mUriPattern = str;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class MimeType implements Comparable<MimeType> {
        String mSubType;
        String mType;

        MimeType(@NonNull String str) {
            String[] split = str.split("/", -1);
            this.mType = split[0];
            this.mSubType = split[1];
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull MimeType mimeType) {
            int i3 = this.mType.equals(mimeType.mType) ? 2 : 0;
            return this.mSubType.equals(mimeType.mSubType) ? i3 + 1 : i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ParamQuery {
        private ArrayList<String> mArguments = new ArrayList<>();
        private String mParamRegex;

        ParamQuery() {
        }

        void addArgumentName(String str) {
            this.mArguments.add(str);
        }

        String getArgumentName(int i3) {
            return this.mArguments.get(i3);
        }

        String getParamRegex() {
            return this.mParamRegex;
        }

        void setParamRegex(String str) {
            this.mParamRegex = str;
        }

        public int size() {
            return this.mArguments.size();
        }
    }

    NavDeepLink(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.mArguments = new ArrayList<>();
        this.mParamArgMap = new HashMap();
        this.mPattern = null;
        int i3 = 0;
        this.mExactDeepLink = false;
        this.mIsParameterizedQuery = false;
        this.mMimeTypePattern = null;
        this.mUri = str;
        this.mAction = str2;
        this.mMimeType = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.mIsParameterizedQuery = parse.getQuery() != null;
            StringBuilder sb5 = new StringBuilder(AECameraConstants.WIDGETINFO_SEPARATE);
            if (!SCHEME_PATTERN.matcher(str).find()) {
                sb5.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.mIsParameterizedQuery) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str);
                if (matcher.find()) {
                    buildPathRegex(str.substring(0, matcher.start()), sb5, compile);
                }
                this.mExactDeepLink = false;
                for (String str4 : parse.getQueryParameterNames()) {
                    StringBuilder sb6 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str4);
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i16 = i3;
                    while (matcher2.find()) {
                        paramQuery.addArgumentName(matcher2.group(1));
                        sb6.append(Pattern.quote(queryParameter.substring(i16, matcher2.start())));
                        sb6.append("(.+?)?");
                        i16 = matcher2.end();
                    }
                    if (i16 < queryParameter.length()) {
                        sb6.append(Pattern.quote(queryParameter.substring(i16)));
                    }
                    paramQuery.setParamRegex(sb6.toString().replace(".*", "\\E.*\\Q"));
                    this.mParamArgMap.put(str4, paramQuery);
                    i3 = 0;
                }
            } else {
                this.mExactDeepLink = buildPathRegex(str, sb5, compile);
            }
            this.mPattern = Pattern.compile(sb5.toString().replace(".*", "\\E.*\\Q"));
        }
        if (str3 != null) {
            if (Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(str3).matches()) {
                MimeType mimeType = new MimeType(str3);
                this.mMimeTypePattern = Pattern.compile(("^(" + mimeType.mType + "|[*]+)/(" + mimeType.mSubType + "|[*]+)$").replace("*|[*]", "[\\s\\S]"));
                return;
            }
            throw new IllegalArgumentException("The given mimeType " + str3 + " does not match to required \"type/subtype\" format");
        }
    }

    private boolean buildPathRegex(@NonNull String str, StringBuilder sb5, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z16 = !str.contains(".*");
        int i3 = 0;
        while (matcher.find()) {
            this.mArguments.add(matcher.group(1));
            sb5.append(Pattern.quote(str.substring(i3, matcher.start())));
            sb5.append("(.+?)");
            i3 = matcher.end();
            z16 = false;
        }
        if (i3 < str.length()) {
            sb5.append(Pattern.quote(str.substring(i3)));
        }
        sb5.append("($|(\\?(.)*))");
        return z16;
    }

    private boolean matchAction(String str) {
        boolean z16;
        boolean z17;
        if (str == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        String str2 = this.mAction;
        if (str2 != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 == z17) {
            return false;
        }
        if (str == null || str2.equals(str)) {
            return true;
        }
        return false;
    }

    private boolean matchMimeType(String str) {
        boolean z16;
        boolean z17;
        if (str == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mMimeType != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 == z17) {
            return false;
        }
        if (str == null || this.mMimeTypePattern.matcher(str).matches()) {
            return true;
        }
        return false;
    }

    private boolean matchUri(Uri uri) {
        boolean z16;
        boolean z17;
        if (uri == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        Pattern pattern = this.mPattern;
        if (pattern != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 == z17) {
            return false;
        }
        if (uri == null || pattern.matcher(uri.toString()).matches()) {
            return true;
        }
        return false;
    }

    private boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            try {
                navArgument.getType().parseAndPut(bundle, str, str2);
                return false;
            } catch (IllegalArgumentException unused) {
                return true;
            }
        }
        bundle.putString(str, str2);
        return false;
    }

    @Nullable
    public String getAction() {
        return this.mAction;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public Bundle getMatchingArguments(@NonNull Uri uri, @NonNull Map<String, NavArgument> map) {
        Matcher matcher;
        String str;
        Matcher matcher2 = this.mPattern.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.mArguments.size();
        int i3 = 0;
        while (i3 < size) {
            String str2 = this.mArguments.get(i3);
            i3++;
            if (parseArgument(bundle, str2, Uri.decode(matcher2.group(i3)), map.get(str2))) {
                return null;
            }
        }
        if (this.mIsParameterizedQuery) {
            for (String str3 : this.mParamArgMap.keySet()) {
                ParamQuery paramQuery = this.mParamArgMap.get(str3);
                String queryParameter = uri.getQueryParameter(str3);
                if (queryParameter != null) {
                    matcher = Pattern.compile(paramQuery.getParamRegex()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                for (int i16 = 0; i16 < paramQuery.size(); i16++) {
                    if (matcher != null) {
                        str = Uri.decode(matcher.group(i16 + 1));
                    } else {
                        str = null;
                    }
                    String argumentName = paramQuery.getArgumentName(i16);
                    NavArgument navArgument = map.get(argumentName);
                    if (navArgument != null && (str == null || str.replaceAll("[{}]", "").equals(argumentName))) {
                        if (navArgument.getDefaultValue() != null) {
                            str = navArgument.getDefaultValue().toString();
                        } else if (navArgument.isNullable()) {
                            str = null;
                        }
                    }
                    if (parseArgument(bundle, argumentName, str, navArgument)) {
                        return null;
                    }
                }
            }
        }
        return bundle;
    }

    @Nullable
    public String getMimeType() {
        return this.mMimeType;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMimeTypeMatchRating(@NonNull String str) {
        if (this.mMimeType != null && this.mMimeTypePattern.matcher(str).matches()) {
            return new MimeType(this.mMimeType).compareTo(new MimeType(str));
        }
        return -1;
    }

    @Nullable
    public String getUriPattern() {
        return this.mUri;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExactDeepLink() {
        return this.mExactDeepLink;
    }

    boolean matches(@NonNull Uri uri) {
        return matches(new NavDeepLinkRequest(uri, null, null));
    }

    boolean matches(@NonNull NavDeepLinkRequest navDeepLinkRequest) {
        if (matchUri(navDeepLinkRequest.getUri()) && matchAction(navDeepLinkRequest.getAction())) {
            return matchMimeType(navDeepLinkRequest.getMimeType());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavDeepLink(@NonNull String str) {
        this(str, null, null);
    }
}
