package i33;

import android.content.res.Resources;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.AbsTintManger;
import com.tencent.mobileqq.vas.theme.SimpleTintManager;
import com.tencent.mobileqq.vas.theme.ThemeConfigItem;
import com.tencent.mobileqq.vas.theme.ThemeConfigParser;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\f\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\u000bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J5\u0010\u001a\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u0019\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00182\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cH\u0016J\u001b\u0010\u001f\u001a\u0004\u0018\u00010\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010)\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010\"\u00a8\u0006,"}, d2 = {"Li33/b;", "Lcom/tencent/mobileqq/vas/theme/AbsTintManger;", "", WadlProxyConsts.PARAM_FILENAME, "", "businessNeedTint", "", NodeProps.COLORS, "", "index", "color", "", "setColors", "([IILjava/lang/Integer;)V", QCircleLpReportDc05507.KEY_CLEAR, "isTint", "needTintRes", "Landroid/content/res/Resources;", "r", ReportConstant.COSTREPORT_PREFIX, "loadConfig", "Landroid/graphics/Paint;", "paint", "tint", "", "ints1", "tintColorState", "([I[[ILjava/lang/String;)V", "", "getCurrentTintColorMap", "plateName", "getPlateColor", "(Ljava/lang/String;)Ljava/lang/Integer;", "a", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/vas/theme/ThemeConfigItem;", "b", "Lcom/tencent/mobileqq/vas/theme/ThemeConfigItem;", "mThemeConfigItem", "c", "mThemeId", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b extends AbsTintManger {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = "DefaultNightThemeTint";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ThemeConfigItem mThemeConfigItem;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mThemeId;

    private final boolean businessNeedTint(String fileName) {
        Map<String, String> map;
        ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
        if (themeConfigItem == null) {
            return false;
        }
        Map<String, String> map2 = null;
        if (themeConfigItem != null) {
            map = themeConfigItem.getTintColorMap();
        } else {
            map = null;
        }
        if (map != null && map.containsKey(fileName)) {
            return true;
        }
        ThemeConfigItem themeConfigItem2 = this.mThemeConfigItem;
        if (themeConfigItem2 != null) {
            map2 = themeConfigItem2.getTintDrawableMap();
        }
        if (map2 == null || !map2.containsKey(fileName)) {
            return false;
        }
        return true;
    }

    private final void setColors(int[] colors, int index, Integer color) {
        if (color != null && colors != null && colors.length > index) {
            colors[index] = color.intValue();
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
        QLog.d(this.TAG, 1, "start clean");
        this.mThemeConfigItem = null;
        this.mThemeId = null;
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    @NotNull
    public Map<String, String> getCurrentTintColorMap() {
        ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
        if (themeConfigItem != null) {
            Intrinsics.checkNotNull(themeConfigItem);
            Map<String, String> tintColorMap = themeConfigItem.getTintColorMap();
            Intrinsics.checkNotNullExpressionValue(tintColorMap, "mThemeConfigItem!!.tintColorMap");
            return tintColorMap;
        }
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    @Nullable
    public Integer getPlateColor(@Nullable String plateName) {
        return null;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(@Nullable String fileName) {
        Intrinsics.checkNotNull(fileName);
        return businessNeedTint(fileName);
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(@Nullable Resources r16, @Nullable String s16) {
        String parseThemeIdFromPath = ThemeConfigParser.parseThemeIdFromPath(s16);
        if (!TextUtils.isEmpty(parseThemeIdFromPath) && Intrinsics.areEqual("1103", parseThemeIdFromPath)) {
            if (Intrinsics.areEqual(parseThemeIdFromPath, this.mThemeId)) {
                QLog.d(this.TAG, 1, "config same theme!");
                return;
            }
            this.mThemeId = parseThemeIdFromPath;
            QLog.d(this.TAG, 1, "loadConfig, path is : ", s16);
            QQTheme.getCurrentThemeId();
            ThemeConfigItem parseBusinessConfig = ThemeConfigParser.parseBusinessConfig(BaseApplication.getContext(), this.mThemeId);
            this.mThemeConfigItem = parseBusinessConfig;
            QLog.d(this.TAG, 1, "current theme id is : ", this.mThemeId, " item : ", parseBusinessConfig);
            SimpleTintManager.instance().clear();
            return;
        }
        QLog.d(this.TAG, 1, "load config theme id is null or not night");
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(@Nullable String fileName) {
        Intrinsics.checkNotNull(fileName);
        return businessNeedTint(fileName);
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(@Nullable Paint paint, @Nullable String fileName) {
        int parseColor;
        ThemeConfigItem themeConfigItem = this.mThemeConfigItem;
        if (themeConfigItem != null) {
            Intrinsics.checkNotNull(themeConfigItem);
            Map<String, String> tintDrawableMap = themeConfigItem.getTintDrawableMap();
            if (tintDrawableMap != null && tintDrawableMap.containsKey(fileName)) {
                String str = tintDrawableMap.get(fileName);
                QLog.d(this.TAG, 1, "tint filename is : " + fileName, " color : ", str);
                Intrinsics.checkNotNull(paint);
                if (TextUtils.isEmpty(str)) {
                    ThemeConfigItem themeConfigItem2 = this.mThemeConfigItem;
                    Intrinsics.checkNotNull(themeConfigItem2);
                    parseColor = themeConfigItem2.getDefaultColor();
                } else {
                    parseColor = ThemeConfigParser.parseColor(str, -1);
                }
                paint.setColorFilter(new LightingColorFilter(0, parseColor));
            }
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(@Nullable int[] colors, @Nullable int[][] ints1, @Nullable String fileName) {
        boolean z16;
        ThemeConfigItem themeConfigItem;
        boolean contains$default;
        List emptyList;
        int parseColor;
        boolean z17;
        if (colors != null) {
            if (colors.length == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16 && !TextUtils.isEmpty(fileName) && (themeConfigItem = this.mThemeConfigItem) != null) {
                Intrinsics.checkNotNull(themeConfigItem);
                Map<String, String> tintColorMap = themeConfigItem.getTintColorMap();
                if (tintColorMap != null && tintColorMap.containsKey(fileName)) {
                    String str = tintColorMap.get(fileName);
                    QLog.d(this.TAG, 1, "tint color filename is : " + fileName, " color : ", str);
                    ThemeConfigItem themeConfigItem2 = this.mThemeConfigItem;
                    Intrinsics.checkNotNull(themeConfigItem2);
                    int defaultColor = themeConfigItem2.getDefaultColor();
                    Intrinsics.checkNotNull(str);
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) ",", false, 2, (Object) null);
                    if (contains$default) {
                        List<String> split = new Regex(",").split(str, 0);
                        if (!split.isEmpty()) {
                            ListIterator<String> listIterator = split.listIterator(split.size());
                            while (listIterator.hasPrevious()) {
                                if (listIterator.previous().length() == 0) {
                                    z17 = true;
                                } else {
                                    z17 = false;
                                }
                                if (!z17) {
                                    emptyList = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                    break;
                                }
                            }
                        }
                        emptyList = CollectionsKt__CollectionsKt.emptyList();
                        Object[] array = emptyList.toArray(new String[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        String[] strArr = (String[]) array;
                        int length = strArr.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            if (TextUtils.isEmpty(strArr[i3])) {
                                parseColor = defaultColor;
                            } else {
                                parseColor = ThemeConfigParser.parseColor(strArr[i3], defaultColor, -1);
                            }
                            setColors(colors, i3, Integer.valueOf(parseColor));
                        }
                        return;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        defaultColor = ThemeConfigParser.parseColor(str, -1);
                    }
                    setColors(colors, 0, Integer.valueOf(defaultColor));
                }
            }
        }
    }
}
