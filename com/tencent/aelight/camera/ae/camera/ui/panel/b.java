package com.tencent.aelight.camera.ae.camera.ui.panel;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsbProxy;
import com.tencent.ttpic.openapi.config.BeautyRealConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u00a2\u0006\u0004\b?\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010'\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010*\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\"\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\"\u0010,\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\"\u001a\u0004\b\b\u0010$\"\u0004\b+\u0010&R\"\u0010.\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\"\u001a\u0004\b\u001a\u0010$\"\u0004\b-\u0010&R\u0017\u00100\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b/\u0010\u001b\u001a\u0004\b\u0012\u0010\u001dR\"\u00105\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u000f\u001a\u0004\b\u000e\u00102\"\u0004\b3\u00104R(\u0010<\u001a\b\u0012\u0004\u0012\u000207068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u00108\u001a\u0004\b/\u00109\"\u0004\b:\u0010;R\"\u0010>\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\"\u001a\u0004\b1\u0010$\"\u0004\b=\u0010&\u00a8\u0006A"}, d2 = {"Lcom/tencent/aelight/camera/ae/camera/ui/panel/b;", "", "", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "a", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", "e", "()Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "Z", "needBeautyImprovement", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "c", "Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "k", "()Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;", "setType", "(Lcom/tencent/ttpic/openapi/config/BeautyRealConfig$TYPE;)V", "type", "", "d", "Ljava/lang/String;", "f", "()Ljava/lang/String;", VasCommonJsbProxy.JSON_KEY_SET_KEY, "(Ljava/lang/String;)V", "key", "", "I", tl.h.F, "()I", "setMin", "(I)V", Element.ELEMENT_NAME_MIN, "g", "setMax", "max", "setDefaultValue", RemoteHandleConst.PARAM_DEFAULT_VALUE, "setImageResId", "imageResId", "i", "iconUrl", "j", "()Z", "p", "(Z)V", "enable", "", "Lcom/tencent/aelight/camera/ae/camera/ui/panel/f;", "Ljava/util/List;", "()Ljava/util/List;", "setSecondaryConfigs", "(Ljava/util/List;)V", "secondaryConfigs", "setSecondarySelectDefault", "secondarySelectDefault", "<init>", "(Lcom/tencent/aelight/camera/ae/camera/ui/panel/BeautyItem;Z)V", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final BeautyItem item;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean needBeautyImprovement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private BeautyRealConfig.TYPE type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String key;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int min;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int max;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int defaultValue;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int imageResId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final String iconUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean enable;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<f> secondaryConfigs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int secondarySelectDefault;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b(BeautyItem item) {
        this(item, false, 2, null);
        Intrinsics.checkNotNullParameter(item, "item");
    }

    private final void l() {
        if (this.needBeautyImprovement) {
            List<f> list = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem = BeautySecondaryItem.SUB_THIN_FACE_NATURE;
            beautySecondaryItem.setDefaultValue(50);
            list.add(new f(beautySecondaryItem));
            List<f> list2 = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem2 = BeautySecondaryItem.SUB_THIN_FACE_GIRL;
            beautySecondaryItem2.setDefaultValue(50);
            list2.add(new f(beautySecondaryItem2));
            List<f> list3 = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem3 = BeautySecondaryItem.SUB_THIN_FACE_BOY;
            beautySecondaryItem3.setDefaultValue(50);
            list3.add(new f(beautySecondaryItem3));
        } else {
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_THIN_FACE_NATURE));
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_THIN_FACE_GIRL));
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_THIN_FACE_BOY));
        }
        this.secondarySelectDefault = 0;
    }

    private final void m() {
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_RED_CHEEK_NONE));
        List<f> list = this.secondaryConfigs;
        BeautySecondaryItem beautySecondaryItem = BeautySecondaryItem.SUB_RED_CHEEK_JIAN_YUE;
        if (this.needBeautyImprovement) {
            beautySecondaryItem.setMaskPath("images/beauty/saihong_jianyue_1.png");
        }
        list.add(new f(beautySecondaryItem));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_RED_CHECK_CHENG_SHU));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_RED_CHECK_HAI_XIU));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_RED_CHECK_SHENG_XIA));
        this.secondarySelectDefault = 1;
    }

    private final void n() {
        if (this.needBeautyImprovement) {
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LI_TI_NONE));
            List<f> list = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem = BeautySecondaryItem.SUB_LI_TI_GUANG_MANG;
            beautySecondaryItem.setDefaultValue(50);
            beautySecondaryItem.setMaskPath("images/beauty/liti_guangmang_1.png");
            list.add(new f(beautySecondaryItem));
            List<f> list2 = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem2 = BeautySecondaryItem.SUB_LI_TI_ZI_RAN;
            beautySecondaryItem2.setDefaultValue(50);
            list2.add(new f(beautySecondaryItem2));
            List<f> list3 = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem3 = BeautySecondaryItem.SUB_LI_TI_QING_XIN;
            beautySecondaryItem3.setDefaultValue(50);
            list3.add(new f(beautySecondaryItem3));
            List<f> list4 = this.secondaryConfigs;
            BeautySecondaryItem beautySecondaryItem4 = BeautySecondaryItem.SUB_LI_TI_JUN_LANG;
            beautySecondaryItem4.setDefaultValue(50);
            list4.add(new f(beautySecondaryItem4));
        } else {
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LI_TI_NONE));
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LI_TI_GUANG_MANG));
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LI_TI_ZI_RAN));
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LI_TI_QING_XIN));
            this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LI_TI_JUN_LANG));
        }
        this.secondarySelectDefault = 1;
    }

    private final void o() {
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LIPSTICK_NONE));
        List<f> list = this.secondaryConfigs;
        BeautySecondaryItem beautySecondaryItem = BeautySecondaryItem.SUB_LIPSTICK_MI_TAO;
        if (this.needBeautyImprovement) {
            beautySecondaryItem.setMaskPath("images/beauty/lips_mitaose_1.png");
        }
        list.add(new f(beautySecondaryItem));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LIPSTICK_SHAN_HU));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LIPSTICK_WEN_ROU));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LIPSTICK_FU_GU));
        this.secondaryConfigs.add(new f(BeautySecondaryItem.SUB_LIPSTICK_HUO_LI));
        this.secondarySelectDefault = 1;
    }

    /* renamed from: a, reason: from getter */
    public final int getDefaultValue() {
        return this.defaultValue;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnable() {
        return this.enable;
    }

    /* renamed from: c, reason: from getter */
    public final String getIconUrl() {
        return this.iconUrl;
    }

    /* renamed from: d, reason: from getter */
    public final int getImageResId() {
        return this.imageResId;
    }

    /* renamed from: e, reason: from getter */
    public final BeautyItem getItem() {
        return this.item;
    }

    /* renamed from: f, reason: from getter */
    public final String getKey() {
        return this.key;
    }

    /* renamed from: g, reason: from getter */
    public final int getMax() {
        return this.max;
    }

    /* renamed from: h, reason: from getter */
    public final int getMin() {
        return this.min;
    }

    public final List<f> i() {
        return this.secondaryConfigs;
    }

    /* renamed from: j, reason: from getter */
    public final int getSecondarySelectDefault() {
        return this.secondarySelectDefault;
    }

    /* renamed from: k, reason: from getter */
    public final BeautyRealConfig.TYPE getType() {
        return this.type;
    }

    public final void p(boolean z16) {
        this.enable = z16;
    }

    public b(BeautyItem item, boolean z16) {
        Intrinsics.checkNotNullParameter(item, "item");
        this.item = item;
        this.needBeautyImprovement = z16;
        this.type = BeautyRealConfig.TYPE.NONE;
        this.key = "\u65e0";
        String iconUrl = item.getIconUrl();
        this.iconUrl = iconUrl == null ? "" : iconUrl;
        this.enable = true;
        this.secondaryConfigs = new ArrayList();
        this.type = item.getType();
        this.key = item.getKey();
        this.min = item.getMin();
        this.max = item.getMax();
        this.defaultValue = item.getDefaultValue();
        this.imageResId = item.getImageResId();
        BeautyRealConfig.TYPE type = this.type;
        if (type == BeautyItem.BASICFACE.getType()) {
            l();
            return;
        }
        if (type == BeautyItem.FACE_FEATURE_LIPS_LUT_ALPHA.getType()) {
            o();
        } else if (type == BeautyItem.FACE_FEATURE_REDCHEEK.getType()) {
            m();
        } else if (type == BeautyItem.FACE_FEATURE_SOFT.getType()) {
            n();
        }
    }

    public /* synthetic */ b(BeautyItem beautyItem, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(beautyItem, (i3 & 2) != 0 ? false : z16);
    }
}
