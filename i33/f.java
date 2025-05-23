package i33;

import android.content.res.Resources;
import android.graphics.Color;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.qphone.base.util.QLog;
import xy2.d;

/* compiled from: P */
/* loaded from: classes20.dex */
public class f extends e {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i33.e
    public void g(String str, Resources resources) {
        super.g(str, resources);
        try {
            if (!QQTheme.isBaseDIYTheme(str)) {
                this.f407138a.putOpt("skin_background.png", "B1");
                this.f407138a.putOpt("skin_background_theme_version2.png", "B1");
            }
            this.f407138a.putOpt("qui_common_fill_light_primary.xml", "B3*0.1");
            this.f407138a.putOpt("qui_common_fill_light_primary_stick.xml", "B3*0.4");
            this.f407138a.putOpt("qq_setting_item_bg_nor.xml", "B3*0");
        } catch (Exception e16) {
            QLog.e("VasDIYThemeTint", 1, "addExtraMapping error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i33.e
    public String m(String str, String str2, String str3, String str4, String str5) {
        String i3 = i();
        if (QQTheme.isBaseDIYTheme(str)) {
            return i3;
        }
        return super.m(str, str2, str3, str4, str5);
    }

    @Override // i33.e
    protected String n(String str, String str2) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case 1448635040:
                if (str.equals("100001")) {
                    c16 = 0;
                    break;
                }
                break;
            case 1448635042:
                if (str.equals("100003")) {
                    c16 = 1;
                    break;
                }
                break;
            case 1448635047:
                if (str.equals("100008")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1448635104:
                if (str.equals("100023")) {
                    c16 = 3;
                    break;
                }
                break;
            case 1448635108:
                if (str.equals("100027")) {
                    c16 = 4;
                    break;
                }
                break;
            case 1448635133:
                if (str.equals("100031")) {
                    c16 = 5;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                return "#BDB76B";
            case 1:
                return "#EEA9B8";
            case 2:
                return "#CD9B9B";
            case 3:
                return "#B0E2FF";
            case 4:
                return "#4169E1";
            case 5:
                return "#FFFFF0";
            default:
                return str2;
        }
    }

    @Override // i33.e
    protected String o(String str, String str2) {
        return d.d(str2, "skin_header_bar_bg.9.png");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // i33.e
    public void p(String str, String str2) {
        try {
            if (QQTheme.isBaseDIYTheme(str)) {
                str2 = d.i(d.b(Color.parseColor(str2), 0.6f, true));
            }
            super.p(str, str2);
        } catch (Exception e16) {
            QLog.e("VasDIYThemeTint", 1, e16, new Object[0]);
        }
    }

    @Override // i33.e
    protected void s(String str, String str2, String str3, String str4, d.C11578d c11578d) {
        String i3;
        String i16;
        if (c11578d != null) {
            if (!d.g(c11578d.b())) {
                i3 = d.i(d.b(c11578d.b(), 0.5f, false));
                i16 = d.i(d.b(c11578d.f(), 0.5f, false));
            } else {
                i3 = d.i(c11578d.b());
                i16 = d.i(c11578d.f());
            }
            VasMMKV.getCommon().encodeString(str3, e.q(this.f407139b, str2, "T1", R.color.skin_black_theme_version2, i3));
            VasMMKV.getCommon().encodeString(str4, e.q(this.f407139b, str2, "T2", R.color.skin_gray2_theme_version2, i16));
            r(i3, i16);
        }
    }
}
