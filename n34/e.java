package n34;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Marker;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ln34/e;", "", "", "keyword", "a", "text", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", "c", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "b", "", "[Ljava/lang/String;", "SYNTAX_SPECIAL_WORD", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f418127a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final String[] SYNTAX_SPECIAL_WORD = {"\\", "$", "(", ")", "*", Marker.ANY_NON_NULL_MARKER, ".", "[", "]", QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER, AECameraConstants.WIDGETINFO_SEPARATE, "{", "}", "|"};

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"n34/e$a", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bar", "Landroid/graphics/drawable/Drawable;", "getInputBackground", "getBackground", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a extends QUISearchBarResource {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        @Nullable
        public Drawable getBackground(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            if (!QQTheme.isVasTheme()) {
                return super.getBackground(bar);
            }
            return ResourcesCompat.getDrawable(bar.getResources(), R.drawable.skin_searchbar_bg_theme_version2, null);
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        @Nullable
        public Drawable getInputBackground(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            if (!QQTheme.isVasTheme()) {
                return super.getInputBackground(bar);
            }
            return ResourcesCompat.getDrawable(bar.getResources(), R.drawable.skin_searchbar_input_theme_version2, null);
        }
    }

    e() {
    }

    private final String a(String keyword) {
        boolean contains$default;
        if (!TextUtils.isEmpty(keyword)) {
            String str = keyword;
            for (String str2 : SYNTAX_SPECIAL_WORD) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) str2, false, 2, (Object) null);
                if (contains$default) {
                    str = StringsKt__StringsJVMKt.replace$default(str, str2, "\\" + str2, false, 4, (Object) null);
                }
            }
            return str;
        }
        return keyword;
    }

    @NotNull
    public final QUISearchBarResource b() {
        return new a();
    }

    @NotNull
    public final SpannableString c(@Nullable String text, @NotNull String keyword, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(context, "context");
        SpannableString spannableString = new SpannableString(text);
        Pattern compile = Pattern.compile(a(keyword));
        Intrinsics.checkNotNullExpressionValue(compile, "compile(keyword)");
        Matcher matcher = compile.matcher(spannableString);
        Intrinsics.checkNotNullExpressionValue(matcher, "p.matcher(content)");
        while (matcher.find()) {
            spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.qui_common_brand_standard, null)), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }
}
