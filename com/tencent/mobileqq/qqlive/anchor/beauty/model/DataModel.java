package com.tencent.mobileqq.qqlive.anchor.beauty.model;

import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.beauty.g;
import com.tencent.mobileqq.qqlive.anchor.beauty.model.CategoryItem;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.sail.c;
import com.tencent.tbs.reader.IReaderConstants;
import com.tencent.tbs.reader.ITbsReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.light.LightConstants;

/* compiled from: P */
/* loaded from: classes17.dex */
public class DataModel {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static DataModel f270418b;

    /* renamed from: a, reason: collision with root package name */
    private List<CategoryItem> f270419a;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class BeautyItem implements a {
        private static final /* synthetic */ BeautyItem[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BeautyItem BASIC_FACE;
        public static final BeautyItem CHEEK_BONE;
        public static final BeautyItem CLEAR_ALPHA;
        public static final BeautyItem ENLARGE_EYE;
        public static final BeautyItem EYE_BAG;
        public static final BeautyItem FOREHEAD;
        public static final BeautyItem FOUNDATION_ALPHA;
        public static final BeautyItem LAW_LINE;
        public static final BeautyItem MOUTH_SIZE;
        public static final BeautyItem NONE;
        public static final BeautyItem RESET;
        public static final BeautyItem SMALL_FACE;
        public static final BeautyItem SMOOTH;
        public static final BeautyItem THIN_FACE;
        public static final BeautyItem THIN_NOSE;
        public static final BeautyItem TOOTH_WHITE;
        int curValue;
        int defValue;
        int index;
        String lightInterface;
        int max;
        int min;
        String name;
        int offlineRes;
        String onlineUrl;
        boolean select;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54888);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 17)) {
                redirector.redirect((short) 17);
                return;
            }
            BeautyItem beautyItem = new BeautyItem("NONE", 0, 1000, "\u65e0", 0, 0, 0, R.drawable.f161957nn3, null, null);
            NONE = beautyItem;
            BeautyItem beautyItem2 = new BeautyItem("RESET", 1, 1001, "\u6062\u590d\u9ed8\u8ba4", 0, 0, 0, R.drawable.nn6, null, null);
            RESET = beautyItem2;
            BeautyItem beautyItem3 = new BeautyItem("SMOOTH", 2, 1002, "\u78e8\u76ae", 0, 100, 60, R.drawable.nn9, "https://down.qq.com/shadow_qqcamera/Android/res/\u78e8\u76ae.png", "smooth.smooth");
            SMOOTH = beautyItem3;
            BeautyItem beautyItem4 = new BeautyItem("BASIC_FACE", 3, 1003, "\u7626\u8138", 0, 100, 40, R.drawable.nmt, "https://down.qq.com/shadow_qqcamera/Android/res/\u7626\u8138.png", LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_UNIFORM);
            BASIC_FACE = beautyItem4;
            BeautyItem beautyItem5 = new BeautyItem("ENLARGE_EYE", 4, 1004, "\u5927\u773c", 0, 100, 30, R.drawable.nms, "https://down.qq.com/shadow_qqcamera/Android/res/\u5927\u773c.png", LightConstants.ReshapeConfigKey.RESHAPE_ENLARGE_EYE_UNIFORM);
            ENLARGE_EYE = beautyItem5;
            BeautyItem beautyItem6 = new BeautyItem("CLEAR_ALPHA", 5, 1005, "\u6e05\u6670", 0, 100, 20, R.drawable.nmr, "https://down.qq.com/shadow_qqcamera/Android/res/\u6e05\u6670.png", "beauty.lutClearAlpha");
            CLEAR_ALPHA = beautyItem6;
            BeautyItem beautyItem7 = new BeautyItem("FOUNDATION_ALPHA", 6, 1006, "\u7f8e\u767d", 0, 100, 30, R.drawable.nmq, "https://down.qq.com/shadow_qqcamera/Android/res/\u7f8e\u767d.png", "beauty.lutFoundationAlpha");
            FOUNDATION_ALPHA = beautyItem7;
            BeautyItem beautyItem8 = new BeautyItem("SMALL_FACE", 7, 1007, "\u5c0f\u8138", 0, 100, 0, R.drawable.nmp, "https://down.qq.com/shadow_qqcamera/Android/res/\u5c0f\u8138.png", LightConstants.ReshapeConfigKey.RESHAPE_SMALL_FACE_UNIFORM);
            SMALL_FACE = beautyItem8;
            BeautyItem beautyItem9 = new BeautyItem("THIN_FACE", 8, 1008, "\u7a84\u8138", 0, 100, 0, R.drawable.nmv, "https://down.qq.com/shadow_qqcamera/Android/res/\u7a84\u8138.png", LightConstants.ReshapeConfigKey.RESHAPE_THIN_FACE_UNIFORM);
            THIN_FACE = beautyItem9;
            BeautyItem beautyItem10 = new BeautyItem("CHEEK_BONE", 9, 1009, "\u7626\u98a7\u9aa8", 0, 100, 20, R.drawable.nmv, "https://down.qq.com/shadow_qqcamera/Android/res/\u7626\u98a7\u9aa8.png", LightConstants.ReshapeConfigKey.RESHAPE_CHEEK_BONE_UNIFORM);
            CHEEK_BONE = beautyItem10;
            BeautyItem beautyItem11 = new BeautyItem("THIN_NOSE", 10, 1010, "\u7626\u9f3b", 0, 100, 30, R.drawable.f161958nn4, "https://down.qq.com/shadow_qqcamera/Android/res/\u7626\u9f3b.png", LightConstants.ReshapeConfigKey.RESHAPE_THIN_NOSE_UNIFORM);
            THIN_NOSE = beautyItem11;
            BeautyItem beautyItem12 = new BeautyItem("MOUTH_SIZE", 11, 1011, "\u5634\u5f62", -100, 100, 0, R.drawable.f161955nn1, "https://down.qq.com/shadow_qqcamera/Android/res/\u5634\u5f62.png", LightConstants.ReshapeConfigKey.RESHAPE_MOUTH_SIZE_UNIFORM);
            MOUTH_SIZE = beautyItem12;
            BeautyItem beautyItem13 = new BeautyItem("FOREHEAD", 12, 1012, "\u989d\u5934", -100, 100, 0, R.drawable.nmx, "https://down.qq.com/shadow_qqcamera/Android/res/\u989d\u5934.png", LightConstants.ReshapeConfigKey.RESHAPE_FOREHEAD_UNIFORM);
            FOREHEAD = beautyItem13;
            BeautyItem beautyItem14 = new BeautyItem("TOOTH_WHITE", 13, 1016, "\u767d\u7259", 0, 100, 20, R.drawable.nn_, "https://down.qq.com/shadow_qqcamera/Android/res/\u7f8e\u7259.png", "beauty.toothWhiten");
            TOOTH_WHITE = beautyItem14;
            BeautyItem beautyItem15 = new BeautyItem("EYE_BAG", 14, 1017, "\u9ed1\u773c\u5708", 0, 100, 50, R.drawable.nn5, "https://down.qq.com/shadow_qqcamera/Android/res/\u9ed1\u773c\u5708.png", "beauty.removeEyeBags");
            EYE_BAG = beautyItem15;
            BeautyItem beautyItem16 = new BeautyItem("LAW_LINE", 15, 1018, "\u6cd5\u4ee4\u7eb9", 0, 100, 30, R.drawable.f161956nn2, "https://down.qq.com/shadow_qqcamera/Android/res/\u6cd5\u4ee4\u7eb9.png", "beauty.removeLawLine");
            LAW_LINE = beautyItem16;
            $VALUES = new BeautyItem[]{beautyItem, beautyItem2, beautyItem3, beautyItem4, beautyItem5, beautyItem6, beautyItem7, beautyItem8, beautyItem9, beautyItem10, beautyItem11, beautyItem12, beautyItem13, beautyItem14, beautyItem15, beautyItem16};
        }

        BeautyItem(String str, int i3, int i16, String str2, int i17, int i18, int i19, int i26, String str3, String str4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str3, str4);
                return;
            }
            this.select = false;
            this.curValue = 0;
            this.index = i16;
            this.name = str2;
            this.min = i17;
            this.max = i18;
            this.defValue = i19;
            this.offlineRes = i26;
            this.onlineUrl = str3;
            this.lightInterface = str4;
        }

        public static BeautyItem valueOf(String str) {
            return (BeautyItem) Enum.valueOf(BeautyItem.class, str);
        }

        public static BeautyItem[] values() {
            return (BeautyItem[]) $VALUES.clone();
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getCurValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.curValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getDefValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.defValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIconRes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.offlineRes;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIndex() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return this.index;
        }

        public String getLightInterface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.lightInterface;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMax() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.max;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.min;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.name;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getOnlineUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.onlineUrl;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public boolean getSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.select;
        }

        public boolean isSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.select;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void loadFromLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            g gVar = g.f270406a;
            this.curValue = gVar.h(gVar.a(this.index), this.defValue);
            this.select = gVar.c(gVar.b(this.index), this.select);
        }

        public void saveToLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this);
                return;
            }
            if (this.curValue != this.defValue) {
                g gVar = g.f270406a;
                gVar.u(gVar.i(), true);
            }
            g gVar2 = g.f270406a;
            gVar2.v(gVar2.a(this.index), this.curValue);
            gVar2.u(gVar2.b(this.index), this.select);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setCurValue(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.curValue = i3;
                saveToLocal();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setSelect(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.select = z16;
                saveToLocal();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class BeautySecondaryItem implements a {
        private static final /* synthetic */ BeautySecondaryItem[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BeautySecondaryItem SUB_THIN_FACE_BOY;
        public static final BeautySecondaryItem SUB_THIN_FACE_GIRL;
        public static final BeautySecondaryItem SUB_THIN_FACE_NATURE;
        int curValue;
        int defValue;
        int index;
        int max;
        int min;
        String name;
        int offlineRes;
        String onlineUrl;
        BeautyItem parent;
        boolean select;
        String subLightInterface;
        String subLightValue;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54893);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 19)) {
                redirector.redirect((short) 19);
                return;
            }
            BeautyItem beautyItem = BeautyItem.BASIC_FACE;
            BeautySecondaryItem beautySecondaryItem = new BeautySecondaryItem("SUB_THIN_FACE_NATURE", 0, 1100, beautyItem, "\u81ea\u7136", 0, 100, 40, R.drawable.nmt, "https://down.qq.com/shadow_qqcamera/Android/res/\u81ea\u7136.png", LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "nature");
            SUB_THIN_FACE_NATURE = beautySecondaryItem;
            BeautySecondaryItem beautySecondaryItem2 = new BeautySecondaryItem("SUB_THIN_FACE_GIRL", 1, 1101, beautyItem, "\u6c14\u8d28", 0, 100, 40, R.drawable.nmw, "https://down.qq.com/shadow_qqcamera/Android/res/\u5973\u795e.png", LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "femaleGod");
            SUB_THIN_FACE_GIRL = beautySecondaryItem2;
            BeautySecondaryItem beautySecondaryItem3 = new BeautySecondaryItem("SUB_THIN_FACE_BOY", 2, 1102, beautyItem, "\u82f1\u4fca", 0, 100, 40, R.drawable.nmu, "https://down.qq.com/shadow_qqcamera/Android/res/\u7537\u795e.png", LightConstants.ReshapeConfigKey.RESHAPE_BASIC_FACE_SUB_TYPE_UNIFORM, "maleGod");
            SUB_THIN_FACE_BOY = beautySecondaryItem3;
            $VALUES = new BeautySecondaryItem[]{beautySecondaryItem, beautySecondaryItem2, beautySecondaryItem3};
        }

        BeautySecondaryItem(String str, int i3, int i16, BeautyItem beautyItem, String str2, int i17, int i18, int i19, int i26, String str3, String str4, String str5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), beautyItem, str2, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), str3, str4, str5);
                return;
            }
            this.select = false;
            this.curValue = 0;
            this.index = i16;
            this.parent = beautyItem;
            this.name = str2;
            this.min = i17;
            this.max = i18;
            this.defValue = i19;
            this.offlineRes = i26;
            this.onlineUrl = str3;
            this.subLightInterface = str4;
            this.subLightValue = str5;
        }

        public static BeautySecondaryItem valueOf(String str) {
            return (BeautySecondaryItem) Enum.valueOf(BeautySecondaryItem.class, str);
        }

        public static BeautySecondaryItem[] values() {
            return (BeautySecondaryItem[]) $VALUES.clone();
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getCurValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.curValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getDefValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
            }
            return this.defValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIconRes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
            }
            return this.offlineRes;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIndex() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            return this.index;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMax() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
            }
            return this.max;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.min;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (String) iPatchRedirector.redirect((short) 9, (Object) this);
            }
            return this.name;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getOnlineUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            return this.onlineUrl;
        }

        public BeautyItem getParent() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (BeautyItem) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.parent;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public boolean getSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
            }
            return this.select;
        }

        public String getSubLightInterface() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.subLightInterface;
        }

        public String getSubLightValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.subLightValue;
        }

        public boolean isSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            return this.select;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void loadFromLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            g gVar = g.f270406a;
            this.subLightValue = gVar.q(gVar.r(getIndex()), getSubLightValue());
            this.curValue = gVar.h(gVar.t(this.index), this.defValue);
            this.select = gVar.c(gVar.s(this.index), this.select);
        }

        public void saveToLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this);
                return;
            }
            if (this.curValue != this.defValue) {
                g gVar = g.f270406a;
                gVar.u(gVar.i(), true);
            }
            g gVar2 = g.f270406a;
            gVar2.w(gVar2.r(this.index), this.subLightValue);
            gVar2.v(gVar2.t(this.index), this.curValue);
            gVar2.u(gVar2.s(this.index), this.select);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setCurValue(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, i3);
            } else {
                this.curValue = i3;
                saveToLocal();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setSelect(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.select = z16;
                saveToLocal();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class FilterItem implements a {
        private static final /* synthetic */ FilterItem[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final FilterItem BAIXI;
        public static final FilterItem BUDING;
        public static final FilterItem DIANYING;
        public static final FilterItem DUSHI;
        public static final FilterItem GUSHI;
        public static final FilterItem HUIDIAO;
        public static final FilterItem JIAOYE;
        public static final FilterItem LENGCUI;
        public static final FilterItem MUSI;
        public static final FilterItem NAIYOU;
        public static final FilterItem ORIGIN;
        public static final FilterItem QINGCHEN;
        public static final FilterItem QINGCHUN;
        public static final FilterItem QINGJIAOPIAN;
        public static final FilterItem QINGTOU;
        public static final FilterItem SUIYUE;
        public static final FilterItem TANGGUO;
        public static final FilterItem WANFENG;
        public static final FilterItem WENROU;
        public static final FilterItem XIANGCHUN;
        public static final FilterItem XINGGUANG;
        public static final FilterItem XUANLAN;
        public static final FilterItem YISHIGAN;
        public static final FilterItem YOUGE;
        public static final FilterItem ZHANFANG;
        public static final FilterItem ZIRAN;
        int curValue;
        int defValue;

        /* renamed from: id, reason: collision with root package name */
        String f270420id;
        int index;
        int max;
        int min;
        String name;
        int offlineRes;
        String onlineUrl;
        String onlineZipMd5;
        String onlineZipUrl;
        boolean select;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54898);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 19)) {
                redirector.redirect((short) 19);
                return;
            }
            FilterItem filterItem = new FilterItem("ORIGIN", 0, 3000, "\u539f\u56fe", null, 0, 0, 0, null, R.drawable.f161957nn3, null, null);
            ORIGIN = filterItem;
            FilterItem filterItem2 = new FilterItem("ZIRAN", 1, 3001, "\u81ea\u7136", "v7_ziran", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/ziran.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_ziran.zip", "41f4ca23b8d27de0f7cbe60e1b4571d7");
            ZIRAN = filterItem2;
            FilterItem filterItem3 = new FilterItem("QINGTOU", 2, 3002, "\u8f7b\u900f", "v7_qingtou", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/qingtou.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_qingtou.zip", "b5e3b07df8183466624782be2ae132bf");
            QINGTOU = filterItem3;
            FilterItem filterItem4 = new FilterItem("WENROU", 3, 3003, "\u6e29\u67d4", "v7_wenrou", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/wenrou.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_wenrou.zip", "f11052ffefa31bcd9193b3f052e19358");
            WENROU = filterItem4;
            FilterItem filterItem5 = new FilterItem("BAIXI", 4, 3004, "\u767d\u7699", "v7_baixi", 0, 100, 100, "https://down.qq.com/shadow_qqcamera/lut_v7_local/baixi.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_baixi.zip", "64a787bbd547b882d1daa3e4fe38d42c");
            BAIXI = filterItem5;
            FilterItem filterItem6 = new FilterItem("WANFENG", 5, 3005, "\u665a\u98ce", "v7_fennen", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/fennen.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_fennen.zip", "7ef099345de1908edcd655bacb08cdb3");
            WANFENG = filterItem6;
            FilterItem filterItem7 = new FilterItem("TANGGUO", 6, 3006, "\u7cd6\u679c", "v7_candyb", 0, 100, 65, "https://down.qq.com/shadow_qqcamera/lut_v7_local/candyb.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_candyb.zip", "4d072b7ae2602095823638f1874cb231");
            TANGGUO = filterItem7;
            FilterItem filterItem8 = new FilterItem("NAIYOU", 7, 3007, "\u5976\u6cb9", "v7_dannai", 0, 100, 100, "https://down.qq.com/shadow_qqcamera/lut_v7_local/dannai.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_dannai.zip", "7fb15e533d249edd89b878b69ef39e60");
            NAIYOU = filterItem8;
            FilterItem filterItem9 = new FilterItem("MUSI", 8, 3008, "\u6155\u65af", "v7_musi", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/musi.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_musi.zip", "d911e6f75caa417f966222aeb8f5a004");
            MUSI = filterItem9;
            FilterItem filterItem10 = new FilterItem("XINGGUANG", 9, 3009, "\u661f\u5149", "v7_zhuguang", 0, 100, 100, "https://down.qq.com/shadow_qqcamera/lut_v7_local/zhuguang.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_zhuguang.zip", "2f420af566bcd52f45eb50e7a41ca6a5");
            XINGGUANG = filterItem10;
            FilterItem filterItem11 = new FilterItem("ZHANFANG", 10, 3010, "\u7efd\u653e", "v7_huoli", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/zhanfang.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_huoli.zip", "6a340382ff469686fa145c98288e9c6a");
            ZHANFANG = filterItem11;
            FilterItem filterItem12 = new FilterItem("QINGCHUN", 11, 3011, "\u9752\u6625", "v7_qingchun", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/qingchun.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_qingchun.zip", "20817ebdf1a540413bc53adc67c8d327");
            QINGCHUN = filterItem12;
            FilterItem filterItem13 = new FilterItem("XUANLAN", 12, 3012, "\u7eda\u70c2", "v7_xuanlan", 0, 100, 100, "https://down.qq.com/shadow_qqcamera/lut_v7_local/xuanlan.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_xuanlan.zip", "51d56b1e0f096d02305541d036289f9b");
            XUANLAN = filterItem13;
            FilterItem filterItem14 = new FilterItem("QINGCHEN", 13, 3013, "\u6e05\u6668", "v7_chengjing", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/chengjing.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_chengjing.zip", "1914727458aaea64a93b4a74ecd8a984");
            QINGCHEN = filterItem14;
            FilterItem filterItem15 = new FilterItem("DUSHI", 14, 3014, "\u90fd\u5e02", "v7_dushi", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/dushi.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_dushi.zip", "0776b651840c8317202927f5672504d1");
            DUSHI = filterItem15;
            FilterItem filterItem16 = new FilterItem("JIAOYE", 15, 3015, "\u90ca\u91ce", "v7_jiaoye", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/jiaoye.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_jiaoye.zip", "36a632da3fd1aa4ee9e79ec76c5703dc");
            JIAOYE = filterItem16;
            FilterItem filterItem17 = new FilterItem("BUDING", 16, 3016, "\u5e03\u4e01", "v7_meiwei", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/meiwei.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_meiwei.zip", "bcfb19c34653749d36ed1ff049718e28");
            BUDING = filterItem17;
            FilterItem filterItem18 = new FilterItem("XIANGCHUN", 17, 3017, "\u9999\u9187", "v7_xinxian", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/xinxian.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_xinxian.zip", "20ab0401fa9a498cfb1c7e18ba27c2e3");
            XIANGCHUN = filterItem18;
            FilterItem filterItem19 = new FilterItem("YOUGE", 18, ITbsReader.READER_EVENT_NIGHT_MODE_CHANGED, "\u4f18\u683c", "v7_youge", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/youge.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_youge.zip", "9b217273f08d8a5e6a582e99b41984c3");
            YOUGE = filterItem19;
            FilterItem filterItem20 = new FilterItem("LENGCUI", 19, IReaderConstants.READER_CB_FEATURE_FLAG, "\u51b7\u8403", "v7_lengcui", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/lengcui.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_lengcui.zip", "513cbfb88570714a0afc8b8aab0f9ee0");
            LENGCUI = filterItem20;
            FilterItem filterItem21 = new FilterItem("YISHIGAN", 20, 3020, "\u4eea\u5f0f\u611f", "v7_yishigan", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/yishigan.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_yishigan.zip", "292a1bd7a2b86ae81bb63c9ef4fcbd0f");
            YISHIGAN = filterItem21;
            FilterItem filterItem22 = new FilterItem("QINGJIAOPIAN", 21, 3021, "\u8f7b\u80f6\u7247", "v7_qingjiaopian", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/qingjiaopian.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_qingjiaopian.zip", "446110ba9dda248d6ae1d548cd1b63d5");
            QINGJIAOPIAN = filterItem22;
            FilterItem filterItem23 = new FilterItem("SUIYUE", 22, 3022, "\u5c81\u6708", "v7_fugu", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/fugu.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_fugu.zip", "1ca43500898dc6d5145a972f0bbf4953");
            SUIYUE = filterItem23;
            FilterItem filterItem24 = new FilterItem("GUSHI", 23, 3023, "\u6545\u4e8b", "v7_luoma", 0, 100, 100, "https://down.qq.com/shadow_qqcamera/lut_v7_local/luoma.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_luoma.zip", "fb3df329943280df9c8be1a0851716b9");
            GUSHI = filterItem24;
            FilterItem filterItem25 = new FilterItem("DIANYING", 24, 3024, "\u7535\u5f71", "v7_dianying", 0, 100, 80, "https://down.qq.com/shadow_qqcamera/lut_v7_local/dianying.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_dianying.zip", "9e44eff7a3024841cda485fe69dd02d4");
            DIANYING = filterItem25;
            FilterItem filterItem26 = new FilterItem("HUIDIAO", 25, IReaderConstants.READER_CB_ENTER_FIND_DONE, "\u7070\u8c03", "v7_huidiao", 0, 100, 100, "https://down.qq.com/shadow_qqcamera/lut_v7_local/huidiao.png", 0, "https://down.qq.com/shadow_qqcamera/lut_v7_local/v7_huidiao.zip", "21e77df6d98337d1ea16f9b3281d2b81");
            HUIDIAO = filterItem26;
            $VALUES = new FilterItem[]{filterItem, filterItem2, filterItem3, filterItem4, filterItem5, filterItem6, filterItem7, filterItem8, filterItem9, filterItem10, filterItem11, filterItem12, filterItem13, filterItem14, filterItem15, filterItem16, filterItem17, filterItem18, filterItem19, filterItem20, filterItem21, filterItem22, filterItem23, filterItem24, filterItem25, filterItem26};
        }

        FilterItem(String str, int i3, int i16, String str2, String str3, int i17, int i18, int i19, String str4, int i26, String str5, String str6) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), str4, Integer.valueOf(i26), str5, str6);
                return;
            }
            this.select = false;
            this.curValue = 0;
            this.index = i16;
            this.name = str2;
            this.f270420id = str3;
            this.min = i17;
            this.max = i18;
            this.defValue = i19;
            this.onlineUrl = str4;
            this.offlineRes = i26;
            this.onlineZipUrl = str5;
            this.onlineZipMd5 = str6;
        }

        public static FilterItem valueOf(String str) {
            return (FilterItem) Enum.valueOf(FilterItem.class, str);
        }

        public static FilterItem[] values() {
            return (FilterItem[]) $VALUES.clone();
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getCurValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.curValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getDefValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.defValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIconRes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.offlineRes;
        }

        public String getId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.f270420id;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIndex() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.index;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMax() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.max;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.min;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.name;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getOnlineUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.onlineUrl;
        }

        public String getOnlineZipMd5() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.onlineZipMd5;
        }

        public String getOnlineZipUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.onlineZipUrl;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public boolean getSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
            }
            return this.select;
        }

        public boolean isSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.select;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void loadFromLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
                return;
            }
            g gVar = g.f270406a;
            this.curValue = gVar.h(gVar.g(this.index), this.defValue);
            this.select = gVar.c(gVar.e(this.index), this.select);
        }

        public void saveToLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            if (this.select && !TextUtils.isEmpty(this.f270420id)) {
                g gVar = g.f270406a;
                gVar.u(gVar.i(), true);
            }
            g gVar2 = g.f270406a;
            gVar2.v(gVar2.g(this.index), this.curValue);
            gVar2.u(gVar2.e(this.index), this.select);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setCurValue(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.curValue = i3;
                saveToLocal();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setSelect(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.select = z16;
                saveToLocal();
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public static final class MakeUpItem implements a {
        private static final /* synthetic */ MakeUpItem[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final MakeUpItem BAITAO;
        public static final MakeUpItem CHAONAN;
        public static final MakeUpItem CHENGSHU;
        public static final MakeUpItem DONGGANJICHE;
        public static final MakeUpItem FEILUOMENG;
        public static final MakeUpItem GANGWEI;
        public static final MakeUpItem NAIBAI;
        public static final MakeUpItem NAIXIONG;
        public static final MakeUpItem NANFA;
        public static final MakeUpItem ORIGIN;
        public static final MakeUpItem QINGSHUANG;
        public static final MakeUpItem REHONGJIU;
        public static final MakeUpItem WEISHAN;
        public static final MakeUpItem WOCAN;
        public static final MakeUpItem XIANTAO;
        public static final MakeUpItem XINJISUYAN;
        public static final MakeUpItem XUEMEI;
        public static final MakeUpItem YANGGUANG;
        public static final MakeUpItem ZHIGAN;
        int curValue;
        int defValue;

        /* renamed from: id, reason: collision with root package name */
        String f270421id;
        int index;
        int max;
        int min;
        String name;
        int offlineRes;
        String onlineUrl;
        String onlineZipMd5;
        String onlineZipUrl;
        boolean select;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54901);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 19)) {
                redirector.redirect((short) 19);
                return;
            }
            MakeUpItem makeUpItem = new MakeUpItem("ORIGIN", 0, 2000, "\u539f\u56fe", null, 0, 0, 0, null, R.drawable.f161957nn3, null, null);
            ORIGIN = makeUpItem;
            MakeUpItem makeUpItem2 = new MakeUpItem("QINGSHUANG", 1, 2001, "\u6e05\u723d", "video_makeup_qingshuang", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/6dc2d412-ce46-11eb-923a-466b4b5f9600-video_makeup_qingshuang.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/27079088-1b82-11ec-9f0e-de4095e9037b-video_makeup_qingshuang.zip", "694a654d0d92f5f97b7093d90681116c");
            QINGSHUANG = makeUpItem2;
            MakeUpItem makeUpItem3 = new MakeUpItem("YANGGUANG", 2, 2002, "\u9633\u5149", "video_makeup_yangguang", 0, 100, 60, "https://xmaterial.tu.qq.com/xmaterial/materials/a2ed8060-ce46-11eb-966c-466b4b5f9600-video_makeup_yangguang.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/3422ae42-1b82-11ec-930c-de4095e9037b-video_makeup_yangguang.zip", "638e52a90d525a75a5e3e23a1be732f5");
            YANGGUANG = makeUpItem3;
            MakeUpItem makeUpItem4 = new MakeUpItem("CHENGSHU", 3, 2003, "\u6210\u719f", "video_makeup_chengshu", 0, 100, 70, "https://xmaterial.tu.qq.com/xmaterial/materials/30558f5c-ce46-11eb-9620-22ffff0d45b2-video_makeup_chengshu.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/40447304-1b82-11ec-bb26-de4095e9037b-video_makeup_chengshu.zip", "f970257567a977dd0ba96835d2549fc1");
            CHENGSHU = makeUpItem4;
            MakeUpItem makeUpItem5 = new MakeUpItem("CHAONAN", 4, 2004, "\u6f6e\u7537", "video_makeup_chaonan", 0, 100, 60, "https://xmaterial.tu.qq.com/xmaterial/materials/272a18a8-ce46-11eb-b737-22ffff0d45b2-video_makeup_chaonan.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/4f93c3c8-1b82-11ec-9d0b-de4095e9037b-video_makeup_chaonan.zip", "9439250e340215cf0d053e170a9652e1");
            CHAONAN = makeUpItem5;
            MakeUpItem makeUpItem6 = new MakeUpItem("ZHIGAN", 5, 2005, "\u8d28\u611f", "video_makeup_zhigan", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/a960ae5e-ce46-11eb-b657-22ffff0d45b2-video_makeup_zhigan.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/d6bf5518-1b89-11ec-b11b-de4095e9037b-video_makeup_zhigan.zip", "c206567aae6ad333e1bc6da4ac24e86e");
            ZHIGAN = makeUpItem6;
            MakeUpItem makeUpItem7 = new MakeUpItem("XIANTAO", 6, 2006, "\u4ed9\u6843", "video_makeup_xiantao", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/94e05218-ce46-11eb-8a8e-ca8d69bfd21f-video_makeup_xiantao.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/094eead4-1b8a-11ec-b14a-de4095e9037b-video_makeup_xiantao.zip", "3cc0b9a73271584886e6f7f2a71e01ee");
            XIANTAO = makeUpItem7;
            MakeUpItem makeUpItem8 = new MakeUpItem("REHONGJIU", 7, 2007, "\u70ed\u7ea2\u9152", "video_makeup_rehongjiu", 0, 100, 70, "https://xmaterial.tu.qq.com/xmaterial/materials/7f539b08-ce46-11eb-a9a6-22ffff0d45b2-video_makeup_rehongjiu.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/41d3cdb6-1b8a-11ec-bb25-de4095e9037b-video_makeup_rehongjiu.zip", "569b5eaa22f4794cffac8d1bc7c67efe");
            REHONGJIU = makeUpItem8;
            MakeUpItem makeUpItem9 = new MakeUpItem("XINJISUYAN", 8, 2008, "\u5fc3\u673a\u7d20\u989c", "video_makeup_xinjisuyan", 0, 100, 90, "https://xmaterial.tu.qq.com/xmaterial/materials/9c83b8f2-ce46-11eb-82ba-ca8d69bfd21f-video_makeup_xinjisuyan.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/7fe7bc5c-1b8a-11ec-a6a0-de4095e9037b-video_makeup_xinjisuyan.zip", "1fad15bc96e0c76915e514630f3bc0f7");
            XINJISUYAN = makeUpItem9;
            MakeUpItem makeUpItem10 = new MakeUpItem("XUEMEI", 9, 2009, "\u6821\u82b1\u5b66\u59b9", "video_makeup_xuemei", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/441070ce-03df-11ec-8511-725129f1f05a-video_makeup_xuemei.jpg", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/aa071d16-1b8a-11ec-bbb7-de4095e9037b-video_makeup_xuemei.zip", "b136a51a5df5cb6c30bf980fb68fde35");
            XUEMEI = makeUpItem10;
            MakeUpItem makeUpItem11 = new MakeUpItem("FEILUOMENG", 10, 2010, "\u8d39\u6d1b\u8499", "video_makeup_feiluomeng", 0, 100, 90, "https://xmaterial.tu.qq.com/xmaterial/materials/47a07d02-ce46-11eb-bc80-0af30d6597c8-video_makeup_feiluomeng.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/f1fecfb8-1b82-11ec-9f66-de4095e9037b-video_makeup_feiluomeng.zip", "4d9861bfbed950c0707de604b759cdf4");
            FEILUOMENG = makeUpItem11;
            MakeUpItem makeUpItem12 = new MakeUpItem("WEISHAN", 11, 2011, "\u5fae\u95ea", "video_makeup_weishan", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/8c173124-ce46-11eb-91bf-ca8d69bfd21f-video_makeup_weishan.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/ff577cfa-1b82-11ec-868c-de4095e9037b-video_makeup_weishan.zip", "2bfecd9bc6cc96075feaf27a100842c0");
            WEISHAN = makeUpItem12;
            MakeUpItem makeUpItem13 = new MakeUpItem("GANGWEI", 12, 2012, "\u6e2f\u5473", "video_makeup_gangwei", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/4e5a2274-ce46-11eb-8ff8-22ffff0d45b2-video_makeup_gangwei.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/ef66979c-1b6c-11ec-ab94-de4095e9037b-video_makeup_gangwei.zip", "33e61de93e75b8275ab7cae989b1d575");
            GANGWEI = makeUpItem13;
            MakeUpItem makeUpItem14 = new MakeUpItem("NAIBAI", 13, 2013, "\u5976\u767d", "video_makeup_naibai", 0, 100, 85, "https://xmaterial.tu.qq.com/xmaterial/materials/2241107a-03df-11ec-b891-b65e6d7ca696-video_makeup_naibai.jpg", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/0f666f5c-1b83-11ec-a495-de4095e9037b-video_makeup_naibai.zip", "9c0b4fae724874bfe3d3e3aadf9da01d");
            NAIBAI = makeUpItem14;
            MakeUpItem makeUpItem15 = new MakeUpItem("NAIXIONG", 14, 2014, "\u5976\u51f6", "video_makeup_naixiong", 0, 100, 70, "https://xmaterial.tu.qq.com/xmaterial/materials/57be5a38-ce46-11eb-a634-22ffff0d45b2-video_makeup_naixiong.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/21139112-1b83-11ec-a54c-de4095e9037b-video_makeup_naixiong.zip", "70b0403bda53f6bcb1c8166cec675052");
            NAIXIONG = makeUpItem15;
            MakeUpItem makeUpItem16 = new MakeUpItem("BAITAO", 15, 2015, "\u767d\u6843", "video_makeup_baitao", 0, 100, 100, "https://xmaterial.tu.qq.com/xmaterial/materials/328ff11c-03df-11ec-8e86-725129f1f05a-video_makeup_baitao.jpg", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/2b81655c-1b83-11ec-b273-de4095e9037b-video_makeup_baitao.zip", "d2f0169094042d57e549445fdd2deec4");
            BAITAO = makeUpItem16;
            MakeUpItem makeUpItem17 = new MakeUpItem("WOCAN", 16, 2016, "\u5367\u8695", "video_makeup_wocan", 0, 100, 85, "https://xmaterial.tu.qq.com/xmaterial/materials/76044692-ce46-11eb-aee2-ca8d69bfd21f-video_makeup_wocan.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/3844f22c-1b83-11ec-9601-de4095e9037b-video_makeup_wocan.zip", "46923137a7c018a95f91a967692f6293");
            WOCAN = makeUpItem17;
            MakeUpItem makeUpItem18 = new MakeUpItem("NANFA", 17, 2017, "\u5357\u6cd5", "video_makeup_nanfa", 0, 100, 80, "https://xmaterial.tu.qq.com/xmaterial/materials/63046a36-ce46-11eb-bbab-466b4b5f9600-video_makeup_nanfa.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/47ece9be-1b83-11ec-89ae-de4095e9037b-video_makeup_nanfa.zip", "be7aaa85dcd3749dbe99270626323fab");
            NANFA = makeUpItem18;
            MakeUpItem makeUpItem19 = new MakeUpItem("DONGGANJICHE", 18, 2018, "\u52a8\u611f\u673a\u8f66", "video_makeup_dongganjiche", 0, 100, 70, "https://xmaterial.tu.qq.com/xmaterial/materials/381a9b10-ce46-11eb-ba22-22ffff0d45b2-video_makeup_dongganjiche.png", 0, "https://xmaterial.tu.qq.com/xmaterial/materials/5e9b7856-1b83-11ec-b2ab-de4095e9037b-video_makeup_dongganjiche.zip", "0e49978febd9e5d5a202e108c7bc8973");
            DONGGANJICHE = makeUpItem19;
            $VALUES = new MakeUpItem[]{makeUpItem, makeUpItem2, makeUpItem3, makeUpItem4, makeUpItem5, makeUpItem6, makeUpItem7, makeUpItem8, makeUpItem9, makeUpItem10, makeUpItem11, makeUpItem12, makeUpItem13, makeUpItem14, makeUpItem15, makeUpItem16, makeUpItem17, makeUpItem18, makeUpItem19};
        }

        MakeUpItem(String str, int i3, int i16, String str2, String str3, int i17, int i18, int i19, String str4, int i26, String str5, String str6) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2, str3, Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), str4, Integer.valueOf(i26), str5, str6);
                return;
            }
            this.select = false;
            this.curValue = 0;
            this.index = i16;
            this.name = str2;
            this.f270421id = str3;
            this.min = i17;
            this.max = i18;
            this.defValue = i19;
            this.onlineUrl = str4;
            this.offlineRes = i26;
            this.onlineZipUrl = str5;
            this.onlineZipMd5 = str6;
        }

        public static MakeUpItem valueOf(String str) {
            return (MakeUpItem) Enum.valueOf(MakeUpItem.class, str);
        }

        public static MakeUpItem[] values() {
            return (MakeUpItem[]) $VALUES.clone();
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getCurValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
            }
            return this.curValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getDefValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
            }
            return this.defValue;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIconRes() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
            }
            return this.offlineRes;
        }

        public String getId() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (String) iPatchRedirector.redirect((short) 16, (Object) this);
            }
            return this.f270421id;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getIndex() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.index;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMax() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return this.max;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public int getMin() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
            }
            return this.min;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getName() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return this.name;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public String getOnlineUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (String) iPatchRedirector.redirect((short) 8, (Object) this);
            }
            return this.onlineUrl;
        }

        public String getOnlineZipMd5() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            return this.onlineZipMd5;
        }

        public String getOnlineZipUrl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (String) iPatchRedirector.redirect((short) 17, (Object) this);
            }
            return this.onlineZipUrl;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public boolean getSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
            }
            return this.select;
        }

        public boolean isSelect() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.select;
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void loadFromLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
                return;
            }
            g gVar = g.f270406a;
            this.curValue = gVar.h(gVar.n(this.index), this.defValue);
            this.select = gVar.c(gVar.l(this.index), this.select);
        }

        public void saveToLocal() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            if (this.select && !TextUtils.isEmpty(this.f270421id)) {
                g gVar = g.f270406a;
                gVar.u(gVar.i(), true);
            }
            g gVar2 = g.f270406a;
            gVar2.v(gVar2.n(this.index), this.curValue);
            gVar2.u(gVar2.l(this.index), this.select);
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setCurValue(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3);
            } else {
                this.curValue = i3;
                saveToLocal();
            }
        }

        @Override // com.tencent.mobileqq.qqlive.anchor.beauty.model.DataModel.a
        public void setSelect(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            } else {
                this.select = z16;
                saveToLocal();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    public interface a {
        int getCurValue();

        int getDefValue();

        int getIconRes();

        int getIndex();

        int getMax();

        int getMin();

        String getName();

        String getOnlineUrl();

        boolean getSelect();

        void loadFromLocal();

        void setCurValue(int i3);

        void setSelect(boolean z16);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54904);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f270418b = null;
        }
    }

    DataModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f270419a = arrayList;
        arrayList.add(e());
        this.f270419a.add(g());
        this.f270419a.add(j());
        this.f270419a.addAll(f());
    }

    private CategoryItem g() {
        CategoryItem categoryItem = new CategoryItem(30, 3, 0, "\u6ee4\u955c");
        if (h() == 1) {
            categoryItem.a(new CategoryItem.a(3, FilterItem.ORIGIN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.ZHANFANG));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGCHUN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.ZIRAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGTOU));
            categoryItem.a(new CategoryItem.a(3, FilterItem.WENROU));
            categoryItem.a(new CategoryItem.a(3, FilterItem.BAIXI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.WANFENG));
            categoryItem.a(new CategoryItem.a(3, FilterItem.TANGGUO));
            categoryItem.a(new CategoryItem.a(3, FilterItem.NAIYOU));
            categoryItem.a(new CategoryItem.a(3, FilterItem.MUSI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.XINGGUANG));
            categoryItem.a(new CategoryItem.a(3, FilterItem.XUANLAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGCHEN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.DUSHI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.JIAOYE));
            categoryItem.a(new CategoryItem.a(3, FilterItem.BUDING));
            categoryItem.a(new CategoryItem.a(3, FilterItem.XIANGCHUN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.YOUGE));
            categoryItem.a(new CategoryItem.a(3, FilterItem.LENGCUI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.YISHIGAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGJIAOPIAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.SUIYUE));
            categoryItem.a(new CategoryItem.a(3, FilterItem.GUSHI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.DIANYING));
            categoryItem.a(new CategoryItem.a(3, FilterItem.HUIDIAO));
        } else {
            categoryItem.a(new CategoryItem.a(3, FilterItem.ORIGIN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.ZIRAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGTOU));
            categoryItem.a(new CategoryItem.a(3, FilterItem.WENROU));
            categoryItem.a(new CategoryItem.a(3, FilterItem.BAIXI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.WANFENG));
            categoryItem.a(new CategoryItem.a(3, FilterItem.TANGGUO));
            categoryItem.a(new CategoryItem.a(3, FilterItem.NAIYOU));
            categoryItem.a(new CategoryItem.a(3, FilterItem.MUSI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.XINGGUANG));
            categoryItem.a(new CategoryItem.a(3, FilterItem.ZHANFANG));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGCHUN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.XUANLAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGCHEN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.DUSHI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.JIAOYE));
            categoryItem.a(new CategoryItem.a(3, FilterItem.BUDING));
            categoryItem.a(new CategoryItem.a(3, FilterItem.XIANGCHUN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.YOUGE));
            categoryItem.a(new CategoryItem.a(3, FilterItem.LENGCUI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.YISHIGAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.QINGJIAOPIAN));
            categoryItem.a(new CategoryItem.a(3, FilterItem.SUIYUE));
            categoryItem.a(new CategoryItem.a(3, FilterItem.GUSHI));
            categoryItem.a(new CategoryItem.a(3, FilterItem.DIANYING));
            categoryItem.a(new CategoryItem.a(3, FilterItem.HUIDIAO));
        }
        return categoryItem;
    }

    private int h() {
        LiveLoginInfo u16 = c.f272176a.u();
        if (u16 != null) {
            return u16.o();
        }
        return 0;
    }

    public static DataModel i() {
        if (f270418b == null) {
            f270418b = new DataModel();
        }
        return f270418b;
    }

    public static int k(BeautyItem beautyItem) {
        if (beautyItem == BeautyItem.BASIC_FACE) {
            return 11;
        }
        return 1;
    }

    public void a() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        List<CategoryItem> list = this.f270419a;
        if (list == null) {
            return;
        }
        for (CategoryItem categoryItem : list) {
            if (categoryItem.f270408b == 1) {
                for (int i3 = 0; i3 < categoryItem.f270411e.size(); i3++) {
                    categoryItem.f270411e.get(i3).l(0);
                    if (categoryItem.f270411e.get(i3).f270414b == BeautyItem.NONE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    categoryItem.f270411e.get(i3).m(z16);
                }
            }
        }
    }

    public void b(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        List<CategoryItem> list = this.f270419a;
        if (list == null) {
            return;
        }
        for (CategoryItem categoryItem : list) {
            if (categoryItem.f270408b == i3) {
                for (int i16 = 0; i16 < categoryItem.f270411e.size(); i16++) {
                    categoryItem.f270411e.get(i16).l(0);
                    if (categoryItem.f270411e.get(i16).f270417e == BeautySecondaryItem.SUB_THIN_FACE_NATURE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    categoryItem.f270411e.get(i16).m(z16);
                }
            }
        }
    }

    public Map<String, Integer> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Map) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.f270419a == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<CategoryItem> it = this.f270419a.iterator();
        while (it.hasNext()) {
            for (CategoryItem.a aVar : it.next().f270411e) {
                if (aVar.f270413a == 1 && !l(aVar)) {
                    String str = aVar.f270414b.lightInterface;
                    g gVar = g.f270406a;
                    hashMap.put(str, Integer.valueOf(gVar.h(gVar.a(aVar.f()), aVar.c())));
                }
            }
        }
        return hashMap;
    }

    public Map<String, String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Map) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f270419a == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<CategoryItem> it = this.f270419a.iterator();
        while (it.hasNext()) {
            for (CategoryItem.a aVar : it.next().f270411e) {
                if (aVar.f270413a == 1 && !l(aVar)) {
                    hashMap.put(aVar.f270414b.lightInterface, String.valueOf(r3.defValue / 100.0f));
                }
            }
        }
        return hashMap;
    }

    public CategoryItem e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (CategoryItem) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        CategoryItem categoryItem = new CategoryItem(0, 1, 0, "\u7f8e\u989c");
        categoryItem.a(new CategoryItem.a(1, BeautyItem.NONE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.RESET));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.SMOOTH));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.BASIC_FACE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.ENLARGE_EYE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.CLEAR_ALPHA));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.FOUNDATION_ALPHA));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.SMALL_FACE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.THIN_FACE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.CHEEK_BONE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.THIN_NOSE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.MOUTH_SIZE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.FOREHEAD));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.TOOTH_WHITE));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.EYE_BAG));
        categoryItem.a(new CategoryItem.a(1, BeautyItem.LAW_LINE));
        return categoryItem;
    }

    public List<CategoryItem> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        BeautyItem beautyItem = BeautyItem.BASIC_FACE;
        CategoryItem categoryItem = new CategoryItem(11, 11, 0, beautyItem.name, beautyItem);
        categoryItem.a(new CategoryItem.a(11, BeautySecondaryItem.SUB_THIN_FACE_NATURE));
        categoryItem.a(new CategoryItem.a(11, BeautySecondaryItem.SUB_THIN_FACE_GIRL));
        categoryItem.a(new CategoryItem.a(11, BeautySecondaryItem.SUB_THIN_FACE_BOY));
        arrayList.add(categoryItem);
        return arrayList;
    }

    public CategoryItem j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (CategoryItem) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        CategoryItem categoryItem = new CategoryItem(20, 2, 0, "\u7f8e\u5986");
        if (h() == 1) {
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.ORIGIN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.QINGSHUANG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.YANGGUANG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.CHENGSHU));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.CHAONAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.ZHIGAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.XIANTAO));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.REHONGJIU));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.XINJISUYAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.XUEMEI));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.FEILUOMENG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.WEISHAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.GANGWEI));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.NAIBAI));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.NAIXIONG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.BAITAO));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.WOCAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.NANFA));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.DONGGANJICHE));
        } else {
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.ORIGIN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.ZHIGAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.XIANTAO));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.REHONGJIU));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.XINJISUYAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.XUEMEI));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.FEILUOMENG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.WEISHAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.GANGWEI));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.NAIBAI));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.NAIXIONG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.BAITAO));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.WOCAN));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.NANFA));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.DONGGANJICHE));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.QINGSHUANG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.YANGGUANG));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.CHENGSHU));
            categoryItem.a(new CategoryItem.a(2, MakeUpItem.CHAONAN));
        }
        return categoryItem;
    }

    public boolean l(CategoryItem.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar == null || aVar.f270414b != BeautyItem.BASIC_FACE) {
            return false;
        }
        return true;
    }

    public boolean m(CategoryItem.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) aVar)).booleanValue();
        }
        if (aVar == null || aVar.f270413a < 11) {
            return false;
        }
        return true;
    }

    public List<CategoryItem> n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.f270419a == null) {
            return null;
        }
        o();
        return this.f270419a;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        List<CategoryItem> list = this.f270419a;
        if (list == null) {
            return;
        }
        Iterator<CategoryItem> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public void p() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        List<CategoryItem> list = this.f270419a;
        if (list == null) {
            return;
        }
        for (CategoryItem categoryItem : list) {
            if (categoryItem.f270408b == 1) {
                for (int i3 = 0; i3 < categoryItem.f270411e.size(); i3++) {
                    categoryItem.f270411e.get(i3).l(categoryItem.f270411e.get(i3).c());
                    if (categoryItem.f270411e.get(i3).f270414b == BeautyItem.RESET) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    categoryItem.f270411e.get(i3).m(z16);
                }
            }
        }
    }

    public void q(int i3) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        List<CategoryItem> list = this.f270419a;
        if (list == null) {
            return;
        }
        for (CategoryItem categoryItem : list) {
            if (categoryItem.f270408b == i3) {
                for (int i16 = 0; i16 < categoryItem.f270411e.size(); i16++) {
                    categoryItem.f270411e.get(i16).l(categoryItem.f270411e.get(i16).c());
                    if (categoryItem.f270411e.get(i16).f270417e == BeautySecondaryItem.SUB_THIN_FACE_NATURE) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    categoryItem.f270411e.get(i16).m(z16);
                }
            }
        }
    }
}
