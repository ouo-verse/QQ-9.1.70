package i33;

import android.content.res.Resources;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.AbsTintManger;
import com.tencent.mobileqq.vas.theme.ThemeConfigParser;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c extends AbsTintManger {

    /* renamed from: e, reason: collision with root package name */
    private static volatile AbsTintManger f407146e;

    /* renamed from: a, reason: collision with root package name */
    private final AbsTintManger f407147a = new b();

    /* renamed from: b, reason: collision with root package name */
    private final AbsTintManger f407148b = new f();

    /* renamed from: c, reason: collision with root package name */
    private final AbsTintManger f407149c = new e();

    /* renamed from: d, reason: collision with root package name */
    private AbsTintManger f407150d;

    c() {
    }

    public static AbsTintManger instance() {
        if (f407146e == null) {
            synchronized (c.class) {
                if (f407146e == null) {
                    f407146e = new c();
                }
            }
        }
        return f407146e;
    }

    @Override // com.tencent.theme.ISkinTint
    public void clear() {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.clear();
        }
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    public Map<String, String> getCurrentTintColorMap() {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.getCurrentTintColorMap();
        }
        return new HashMap();
    }

    @Override // com.tencent.mobileqq.vas.theme.AbsTintManger
    public Integer getPlateColor(String str) {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.getPlateColor(str);
            return null;
        }
        return null;
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean isTint(String str) {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            return absTintManger.isTint(str);
        }
        return false;
    }

    @Override // com.tencent.theme.ISkinTint
    public void loadConfig(Resources resources, String str) {
        String parseThemeIdFromPath = ThemeConfigParser.parseThemeIdFromPath(str);
        if (TextUtils.isEmpty(parseThemeIdFromPath)) {
            QLog.d("TintManagerV2", 1, "load config theme id is null");
            return;
        }
        if (QQTheme.isVasTheme(parseThemeIdFromPath)) {
            if (QQTheme.isNowThemeIsDIY(parseThemeIdFromPath)) {
                this.f407150d = this.f407148b;
            } else {
                this.f407150d = this.f407149c;
            }
        } else {
            this.f407150d = this.f407147a;
        }
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.loadConfig(resources, str);
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public boolean needTintRes(String str) {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.needTintRes(str);
            return false;
        }
        return false;
    }

    @Override // com.tencent.theme.ISkinTint
    public void tint(Paint paint, String str) {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.tint(paint, str);
        }
    }

    @Override // com.tencent.theme.ISkinTint
    public void tintColorState(int[] iArr, int[][] iArr2, String str) {
        AbsTintManger absTintManger = this.f407150d;
        if (absTintManger != null) {
            absTintManger.tintColorState(iArr, iArr2, str);
        }
    }
}
