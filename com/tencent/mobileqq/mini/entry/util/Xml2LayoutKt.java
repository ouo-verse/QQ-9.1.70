package com.tencent.mobileqq.mini.entry.util;

import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.vivo.push.PushClientConstants;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.slf4j.Marker;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u0016\u0010\u0016\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u000e\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0001\u001a\u000e\u0010 \u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010!\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010\"\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010#\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010$\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010%\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010&\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u0010\u0010'\u001a\u00020(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010)\u001a\u00020(2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001\u001a\u000e\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u0001\u001a\u0010\u0010,\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0019\u001a\u00020\u0001\u001a\u000e\u0010-\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0001X\u0086T\u00a2\u0006\u0002\n\u0000\"\u0011\u0010\r\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0011\u0010\u0010\u001a\u00020\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006."}, d2 = {"ANDROID_PREFIX", "", "IS_RESOURCE_REFERENCE", "Ljava/util/regex/Pattern;", "getIS_RESOURCE_REFERENCE", "()Ljava/util/regex/Pattern;", "NULL_VALUE", "attrTransformMap", "", "getAttrTransformMap", "()Ljava/util/Map;", PushClientConstants.TAG_CLASS_NAME, "funName", "projectDir", "getProjectDir", "()Ljava/lang/String;", "targetDir", "getTargetDir", "createLayout", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "createLayoutFileTemplate", "content", "extractDigital", "value", "getAttrName", "key", "getAttributeData", "", "attr", "attrValue", "getGravity", "getLayoutEllipsize", "getLayoutGravity", "getLayoutWH", "getOrientation", "getScaleType", "getVisibility", "isNull", "", "isResourceReference", "obtainXmlResourceParser", "path", "parseGravityCompose", "xml2Layout", "qqmini_impl_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class Xml2LayoutKt {
    public static final String ANDROID_PREFIX = "android:";
    private static final Pattern IS_RESOURCE_REFERENCE;
    public static final String NULL_VALUE = "@null";
    private static final Map<String, String> attrTransformMap;
    public static final String className = "PopularityListLayout.kt";
    public static final String funName = "buildPopularityListLayout";
    private static final String projectDir;
    private static final String targetDir;

    static {
        String substringBefore$default;
        Map<String, String> mapOf;
        Pattern compile = Pattern.compile("^\\s*@");
        Intrinsics.checkNotNullExpressionValue(compile, "compile(\"^\\\\s*@\")");
        IS_RESOURCE_REFERENCE = compile;
        String property = System.getProperty("user.dir");
        Intrinsics.checkNotNull(property);
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(property, "AQQLite", (String) null, 2, (Object) null);
        projectDir = substringBefore$default;
        targetDir = substringBefore$default + "QQLite/src/com/tencent/mobileqq/mini/entry/layout/";
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("background", "_background"), TuplesKt.to("text", "_text"), TuplesKt.to("clipChildren", "_clipChildren"), TuplesKt.to("clipPadding", "_clipPadding"));
        attrTransformMap = mapOf;
    }

    public static final void createLayout(XmlPullParser parser) {
        CharSequence trimStart;
        String str;
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(parser, "parser");
        System.out.println((Object) projectDir);
        int eventType = parser.getEventType();
        String str2 = "";
        while (eventType != 1) {
            String name = parser.getName();
            System.out.println((Object) ("Creating view: " + name));
            if (eventType == 2) {
                str = str2 + name + " {\n";
                int attributeCount = parser.getAttributeCount();
                for (int i3 = 0; i3 < attributeCount; i3++) {
                    String key = parser.getAttributeName(i3);
                    String value = parser.getAttributeValue(i3);
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    startsWith$default = StringsKt__StringsJVMKt.startsWith$default(key, ANDROID_PREFIX, false, 2, null);
                    if (startsWith$default) {
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        String attrName = getAttrName(key);
                        Intrinsics.checkNotNullExpressionValue(key, "key");
                        String attrName2 = getAttrName(key);
                        Intrinsics.checkNotNullExpressionValue(value, "value");
                        str = str + "\t" + attrName + " = " + getAttributeData(attrName2, value) + "\n";
                    }
                    System.out.println((Object) ("Creating " + name + " attr key: " + key + ", value: " + value));
                }
            } else if (eventType == 3) {
                str = str2 + "}\n";
                System.out.println((Object) (name + " end"));
            } else {
                eventType = parser.next();
            }
            str2 = str;
            eventType = parser.next();
        }
        trimStart = StringsKt__StringsKt.trimStart((CharSequence) str2);
        String createLayoutFileTemplate = createLayoutFileTemplate(funName, trimStart.toString());
        File file = new File(targetDir + className);
        if (!file.exists()) {
            file.createNewFile();
        }
        FilesKt__FileReadWriteKt.writeText$default(file, createLayoutFileTemplate, null, 2, null);
    }

    public static final String createLayoutFileTemplate(String funName2, String content) {
        CharSequence trimStart;
        Intrinsics.checkNotNullParameter(funName2, "funName");
        Intrinsics.checkNotNullParameter(content, "content");
        trimStart = StringsKt__StringsKt.trimStart((CharSequence) ("\npackage com.tencent.mobileqq.mini.entry.layout\n\nimport android.content.Context\nimport android.text.TextUtils\nimport android.view.Gravity\nimport android.view.View\nimport android.view.ViewGroup\nimport android.widget.ImageView\nimport com.tencent.mobileqq.R\n\ninline fun " + funName2 + "(context: Context): View {\n    return context.run {\n        " + content + "\n    }\n}\n"));
        return trimStart.toString();
    }

    public static final String extractDigital(String value) {
        String substringBefore$default;
        String substringBefore$default2;
        CharSequence trim;
        Intrinsics.checkNotNullParameter(value, "value");
        substringBefore$default = StringsKt__StringsKt.substringBefore$default(value, "dp", (String) null, 2, (Object) null);
        substringBefore$default2 = StringsKt__StringsKt.substringBefore$default(substringBefore$default, "sp", (String) null, 2, (Object) null);
        trim = StringsKt__StringsKt.trim((CharSequence) substringBefore$default2);
        return trim.toString();
    }

    public static final String getAttrName(String key) {
        String str;
        Intrinsics.checkNotNullParameter(key, "key");
        String substring = key.substring(8);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        Map<String, String> map = attrTransformMap;
        return (!map.containsKey(substring) || (str = map.get(substring)) == null) ? substring : str;
    }

    public static final Map<String, String> getAttrTransformMap() {
        return attrTransformMap;
    }

    public static final Object getAttributeData(String attr, String attrValue) {
        boolean endsWith$default;
        boolean endsWith$default2;
        boolean startsWith$default;
        String replace$default;
        String replace$default2;
        String replace$default3;
        String substringBefore$default;
        CharSequence trim;
        Intrinsics.checkNotNullParameter(attr, "attr");
        Intrinsics.checkNotNullParameter(attrValue, "attrValue");
        if (!Intrinsics.areEqual(attr, "textSize")) {
            endsWith$default = StringsKt__StringsJVMKt.endsWith$default(attrValue, "dp", false, 2, null);
            if (!endsWith$default) {
                endsWith$default2 = StringsKt__StringsJVMKt.endsWith$default(attrValue, "sp", false, 2, null);
                if (endsWith$default2) {
                    substringBefore$default = StringsKt__StringsKt.substringBefore$default(attrValue, "sp", (String) null, 2, (Object) null);
                    trim = StringsKt__StringsKt.trim((CharSequence) substringBefore$default);
                    return trim.toString() + "f";
                }
                if (isResourceReference(attrValue)) {
                    replace$default = StringsKt__StringsJVMKt.replace$default(attrValue, "@", "R.", false, 4, (Object) null);
                    replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, Marker.ANY_NON_NULL_MARKER, "", false, 4, (Object) null);
                    replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "/", ".", false, 4, (Object) null);
                    return replace$default3;
                }
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(attrValue, "#", false, 2, null);
                if (!startsWith$default && !Intrinsics.areEqual(attr, "_text")) {
                    if (Intrinsics.areEqual(attr, "layout_width")) {
                        return getLayoutWH(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, "layout_height")) {
                        return getLayoutWH(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, "orientation")) {
                        return getOrientation(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, "scaleType")) {
                        return getScaleType(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, "visibility")) {
                        return getVisibility(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, LayoutAttrDefine.Gravity.Gravity)) {
                        return getGravity(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, LayoutAttrDefine.Gravity.Layout_Gravity)) {
                        return getLayoutGravity(attrValue);
                    }
                    if (Intrinsics.areEqual(attr, "ellipsize")) {
                        return getLayoutEllipsize(attrValue);
                    }
                    if (!Intrinsics.areEqual(attr, "layout_weight") && !Intrinsics.areEqual(attr, BasicAnimation.KeyPath.ROTATION)) {
                        return attrValue;
                    }
                    return attrValue + "f";
                }
                return "\"" + attrValue + "\"";
            }
            return extractDigital(attrValue);
        }
        return extractDigital(attrValue) + "f";
    }

    public static final String getGravity(String value) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(value, "value");
        switch (value.hashCode()) {
            case -1633016142:
                if (value.equals("fill_vertical")) {
                    return "Gravity.FILL_VERTICAL";
                }
                break;
            case -1383228885:
                if (value.equals("bottom")) {
                    return "Gravity.BOTTOM";
                }
                break;
            case -1364013995:
                if (value.equals("center")) {
                    return "Gravity.CENTER";
                }
                break;
            case -831189901:
                if (value.equals("clip_horizontal")) {
                    return "Gravity.CLIP_HORIZONTAL";
                }
                break;
            case -483365792:
                if (value.equals("fill_horizontal")) {
                    return "Gravity.FILL_HORIZONTAL";
                }
                break;
            case -348726240:
                if (value.equals("center_vertical")) {
                    return "Gravity.CENTER_VERTICAL";
                }
                break;
            case -55726203:
                if (value.equals("clip_vertical")) {
                    return "Gravity.CLIP_VERTICAL";
                }
                break;
            case 100571:
                if (value.equals("end")) {
                    return "Gravity.END";
                }
                break;
            case 115029:
                if (value.equals("top")) {
                    return "Gravity.TOP";
                }
                break;
            case 3143043:
                if (value.equals(CanvasView.CUSTOM_ACTION_FILL)) {
                    return "Gravity.FILL";
                }
                break;
            case 3317767:
                if (value.equals("left")) {
                    return "Gravity.LEFT";
                }
                break;
            case 108511772:
                if (value.equals("right")) {
                    return "Gravity.RIGHT";
                }
                break;
            case 109757538:
                if (value.equals("start")) {
                    return "Gravity.START";
                }
                break;
            case 1063616078:
                if (value.equals("center_horizontal")) {
                    return "Gravity.CENTER_HORIZONTAL";
                }
                break;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) value, (CharSequence) "|", false, 2, (Object) null);
        if (!contains$default) {
            return value;
        }
        String parseGravityCompose = parseGravityCompose(value);
        Intrinsics.checkNotNull(parseGravityCompose);
        return parseGravityCompose;
    }

    public static final Pattern getIS_RESOURCE_REFERENCE() {
        return IS_RESOURCE_REFERENCE;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000d. Please report as an issue. */
    public static final String getLayoutEllipsize(String value) {
        String str;
        Intrinsics.checkNotNullParameter(value, "value");
        switch (value.hashCode()) {
            case -1074341483:
                if (!value.equals("middle")) {
                    return "TextUtils.TruncateAt.START";
                }
                return "TextUtils.TruncateAt.MIDDLE";
            case 100571:
                if (!value.equals("end")) {
                    return "TextUtils.TruncateAt.START";
                }
                return "TextUtils.TruncateAt.END";
            case 3387192:
                str = "none";
                value.equals(str);
                return "TextUtils.TruncateAt.START";
            case 109757538:
                str = "start";
                value.equals(str);
                return "TextUtils.TruncateAt.START";
            case 839444514:
                if (!value.equals("marquee")) {
                    return "TextUtils.TruncateAt.START";
                }
                return "TextUtils.TruncateAt.MARQUEE";
            default:
                return "TextUtils.TruncateAt.START";
        }
    }

    public static final String getLayoutGravity(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return getGravity(value);
    }

    public static final String getLayoutWH(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int hashCode = value.hashCode();
        if (hashCode == 343327108) {
            return !value.equals(ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT) ? value : "ViewGroup.LayoutParams.WRAP_CONTENT";
        }
        if (hashCode != 1261922022) {
            if (hashCode != 1386124388 || !value.equals(ParseCommon.LAYOUT_PARAMS_MATCH_PARENT)) {
                return value;
            }
        } else if (!value.equals("fill_parent")) {
            return value;
        }
        return "ViewGroup.LayoutParams.MATCH_PARENT";
    }

    public static final String getOrientation(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, "horizontal")) {
            return "HORIZONTAL";
        }
        return Intrinsics.areEqual(value, "vertical") ? "VERTICAL" : value;
    }

    public static final String getProjectDir() {
        return projectDir;
    }

    public static final String getScaleType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        switch (value.hashCode()) {
            case -1364013995:
                if (!value.equals("center")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.CENTER";
            case -1274298614:
                if (!value.equals("fitEnd")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.FIT_END";
            case -1081239615:
                if (!value.equals("matrix")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.MATRIX";
            case -522179887:
                if (!value.equals("fitStart")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.FIT_START";
            case -340708175:
                if (!value.equals("centerInside")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.CENTER_INSIDE";
            case 97441490:
                if (!value.equals("fitXY")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.FIT_XY";
            case 520762310:
                value.equals("fitCenter");
                return "ImageView.ScaleType.FIT_CENTER";
            case 1161480325:
                if (!value.equals("centerCrop")) {
                    return "ImageView.ScaleType.FIT_CENTER";
                }
                return "ImageView.ScaleType.CENTER_CROP";
            default:
                return "ImageView.ScaleType.FIT_CENTER";
        }
    }

    public static final String getTargetDir() {
        return targetDir;
    }

    public static final String getVisibility(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        int hashCode = value.hashCode();
        if (hashCode == -1901805651) {
            if (!value.equals(QZoneJsConstants.DYNAMIC_ALBUM_INVISIBLE)) {
                return "View.VISIBLE";
            }
            return "View.INVISIBLE";
        }
        if (hashCode == 3178655) {
            if (!value.equals("gone")) {
                return "View.VISIBLE";
            }
            return "View.GONE";
        }
        if (hashCode != 466743410) {
            return "View.VISIBLE";
        }
        value.equals(NodeProps.VISIBLE);
        return "View.VISIBLE";
    }

    public static final boolean isNull(String str) {
        return Intrinsics.areEqual(NULL_VALUE, str);
    }

    public static final boolean isResourceReference(String str) {
        return IS_RESOURCE_REFERENCE.matcher(str).find() && !isNull(str);
    }

    public static final XmlPullParser obtainXmlResourceParser(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
        pullParser.setInput(new FileInputStream(path), "UTF-8");
        Intrinsics.checkNotNullExpressionValue(pullParser, "pullParser");
        return pullParser;
    }

    public static final String parseGravityCompose(String value) {
        List split$default;
        Intrinsics.checkNotNullParameter(value, "value");
        split$default = StringsKt__StringsKt.split$default((CharSequence) value, new String[]{"|"}, false, 0, 6, (Object) null);
        String str = "";
        int i3 = 0;
        for (Object obj : split$default) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            String str2 = (String) obj;
            if (i3 != 0) {
                str = ((Object) str) + " or ";
            }
            str = ((Object) str) + getGravity(str2);
            i3 = i16;
        }
        return str;
    }

    public static final void xml2Layout(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        createLayout(obtainXmlResourceParser(path));
    }
}
