package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.NavigationRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.navigation.NavArgument;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavOptions;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: P */
/* loaded from: classes.dex */
public final class NavInflater {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    private Context mContext;
    private NavigatorProvider mNavigatorProvider;

    public NavInflater(@NonNull Context context, @NonNull NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    private static NavType checkNavType(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType != null && navType != navType2) {
            throw new XmlPullParserException("Type is " + str + " but found " + str2 + MsgSummary.STR_COLON + typedValue.data);
        }
        if (navType == null) {
            return navType2;
        }
        return navType;
    }

    private void inflateAction(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i3) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavAction);
        int resourceId = obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_destination, 0));
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_launchSingleTop, false));
        builder.setPopUpTo(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popUpTo, -1), obtainAttributes.getBoolean(androidx.navigation.common.R.styleable.NavAction_popUpToInclusive, false));
        builder.setEnterAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainAttributes.getResourceId(androidx.navigation.common.R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && TAG_ARGUMENT.equals(xmlResourceParser.getName())) {
                inflateArgumentForBundle(resources, bundle, attributeSet, i3);
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainAttributes.recycle();
    }

    @NonNull
    private NavArgument inflateArgument(@NonNull TypedArray typedArray, @NonNull Resources resources, int i3) throws XmlPullParserException {
        NavType<?> navType;
        NavArgument.Builder builder = new NavArgument.Builder();
        boolean z16 = false;
        builder.setIsNullable(typedArray.getBoolean(androidx.navigation.common.R.styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = sTmpValue;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R.styleable.NavArgument_argType);
        Object obj = null;
        if (string != null) {
            navType = NavType.fromArgType(string, resources.getResourcePackageName(i3));
        } else {
            navType = null;
        }
        int i16 = androidx.navigation.common.R.styleable.NavArgument_android_defaultValue;
        if (typedArray.getValue(i16, typedValue)) {
            NavType<Integer> navType2 = NavType.ReferenceType;
            if (navType == navType2) {
                int i17 = typedValue.resourceId;
                if (i17 != 0) {
                    obj = Integer.valueOf(i17);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    obj = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType.getName() + ". Must be a reference to a resource.");
                }
            } else {
                int i18 = typedValue.resourceId;
                if (i18 != 0) {
                    if (navType == null) {
                        navType = navType2;
                        obj = Integer.valueOf(i18);
                    } else {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + navType.getName() + ". You must use a \"" + navType2.getName() + "\" type to reference other resources.");
                    }
                } else if (navType == NavType.StringType) {
                    obj = typedArray.getString(i16);
                } else {
                    int i19 = typedValue.type;
                    if (i19 != 3) {
                        if (i19 != 4) {
                            if (i19 != 5) {
                                if (i19 != 18) {
                                    if (i19 >= 16 && i19 <= 31) {
                                        navType = checkNavType(typedValue, navType, NavType.IntType, string, "integer");
                                        obj = Integer.valueOf(typedValue.data);
                                    } else {
                                        throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                                    }
                                } else {
                                    navType = checkNavType(typedValue, navType, NavType.BoolType, string, HippyControllerProps.BOOLEAN);
                                    if (typedValue.data != 0) {
                                        z16 = true;
                                    }
                                    obj = Boolean.valueOf(z16);
                                }
                            } else {
                                navType = checkNavType(typedValue, navType, NavType.IntType, string, "dimension");
                                obj = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                            }
                        } else {
                            navType = checkNavType(typedValue, navType, NavType.FloatType, string, "float");
                            obj = Float.valueOf(typedValue.getFloat());
                        }
                    } else {
                        String charSequence = typedValue.string.toString();
                        if (navType == null) {
                            navType = NavType.inferFromValue(charSequence);
                        }
                        obj = navType.parseValue(charSequence);
                    }
                }
            }
        }
        if (obj != null) {
            builder.setDefaultValue(obj);
        }
        if (navType != null) {
            builder.setType(navType);
        }
        return builder.build();
    }

    private void inflateArgumentForBundle(@NonNull Resources resources, @NonNull Bundle bundle, @NonNull AttributeSet attributeSet, int i3) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string != null) {
            NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i3);
            if (inflateArgument.isDefaultValuePresent()) {
                inflateArgument.putDefaultValue(string, bundle);
            }
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void inflateArgumentForDestination(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet, int i3) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavArgument);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavArgument_android_name);
        if (string != null) {
            navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i3));
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void inflateDeepLink(@NonNull Resources resources, @NonNull NavDestination navDestination, @NonNull AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R.styleable.NavDeepLink);
        String string = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_uri);
        String string2 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_action);
        String string3 = obtainAttributes.getString(androidx.navigation.common.R.styleable.NavDeepLink_mimeType);
        if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2) && TextUtils.isEmpty(string3)) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.Builder builder = new NavDeepLink.Builder();
        if (string != null) {
            builder.setUriPattern(string.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        }
        if (!TextUtils.isEmpty(string2)) {
            builder.setAction(string2.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        }
        if (string3 != null) {
            builder.setMimeType(string3.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
        }
        navDestination.addDeepLink(builder.build());
        obtainAttributes.recycle();
    }

    @NonNull
    @SuppressLint({"ResourceType"})
    public NavGraph inflate(@NavigationRes int i3) {
        int next;
        Resources resources = this.mContext.getResources();
        XmlResourceParser xml = resources.getXml(i3);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e16) {
                    throw new RuntimeException("Exception inflating " + resources.getResourceName(i3) + " line " + xml.getLineNumber(), e16);
                }
            } finally {
                xml.close();
            }
        } while (next != 1);
        if (next == 2) {
            String name = xml.getName();
            NavDestination inflate = inflate(resources, xml, asAttributeSet, i3);
            if (inflate instanceof NavGraph) {
                return (NavGraph) inflate;
            }
            throw new IllegalArgumentException("Root element <" + name + "> did not inflate into a NavGraph");
        }
        throw new XmlPullParserException("No start tag found");
    }

    @NonNull
    private NavDestination inflate(@NonNull Resources resources, @NonNull XmlResourceParser xmlResourceParser, @NonNull AttributeSet attributeSet, int i3) throws XmlPullParserException, IOException {
        int depth;
        NavDestination createDestination = this.mNavigatorProvider.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.mContext, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (TAG_ARGUMENT.equals(name)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i3);
                } else if (TAG_DEEP_LINK.equals(name)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else if ("action".equals(name)) {
                    inflateAction(resources, createDestination, attributeSet, xmlResourceParser, i3);
                } else if (TAG_INCLUDE.equals(name) && (createDestination instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i3));
                }
            }
        }
        return createDestination;
    }
}
