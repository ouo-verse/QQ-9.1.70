package com.tencent.mobileqq.wink.share;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.wink.api.IDateTransFrom;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.light.LightVersionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\u0003B'\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/wink/share/p;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "", "a", "scene", "c", "b", "Lcom/tencent/mobileqq/wink/api/IDateTransFrom;", WadlProxyConsts.KEY_MATERIAL, "d", "", "action", "", "e", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "onItemClick", "Lcom/tencent/mobileqq/wink/api/IDateTransFrom;", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "f", "Ljava/lang/String;", "Landroid/view/View;", tl.h.F, "Landroid/view/View;", "clickView", "i", "reportView", "<init>", "(Lcom/tencent/mobileqq/wink/api/IDateTransFrom;Landroid/app/Activity;Ljava/lang/String;Landroid/view/View;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class p implements ShareActionSheet.OnItemClickListener {

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IDateTransFrom material;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String scene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View clickView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View reportView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/share/p$a;", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/api/IDateTransFrom;", "a", "", "DEFAULT_URL", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.share.p$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/share/p$a$a", "Lcom/tencent/mobileqq/wink/api/IDateTransFrom;", "", "getId", "getName", "getDesc", "getThumbUrl", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.wink.share.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public static final class C9086a implements IDateTransFrom {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ MetaMaterial f326377a;

            C9086a(MetaMaterial metaMaterial) {
                this.f326377a = metaMaterial;
            }

            @Override // com.tencent.mobileqq.wink.api.IDateTransFrom
            @NotNull
            public String getDesc() {
                boolean z16;
                String O = com.tencent.mobileqq.wink.editor.c.O(this.f326377a);
                if (O.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return "\u4e00\u952e\u5236\u4f5c\u6a21\u677f";
                }
                return O;
            }

            @Override // com.tencent.mobileqq.wink.api.IDateTransFrom
            @NotNull
            public String getId() {
                String str = this.f326377a.f30533id;
                Intrinsics.checkNotNullExpressionValue(str, "material.id");
                return str;
            }

            @Override // com.tencent.mobileqq.wink.api.IDateTransFrom
            @NotNull
            public String getName() {
                return com.tencent.mobileqq.wink.editor.c.a0(this.f326377a);
            }

            @Override // com.tencent.mobileqq.wink.api.IDateTransFrom
            @NotNull
            public String getThumbUrl() {
                boolean z16;
                String r06 = com.tencent.mobileqq.wink.editor.c.r0(this.f326377a);
                MetaMaterial metaMaterial = this.f326377a;
                if (r06.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    String str = metaMaterial.thumbUrl;
                    Intrinsics.checkNotNullExpressionValue(str, "material.thumbUrl");
                    return str;
                }
                return r06;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final IDateTransFrom a(@NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            return new C9086a(material);
        }

        Companion() {
        }
    }

    public p(@NotNull IDateTransFrom material, @NotNull Activity activity, @NotNull String scene, @NotNull View clickView) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(clickView, "clickView");
        this.material = material;
        this.activity = activity;
        this.scene = scene;
        this.clickView = clickView;
        View view = new View(activity);
        this.reportView = view;
        ViewParent parent = clickView.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.addView(view, new ViewGroup.LayoutParams(0, 0));
        }
        view.setVisibility(8);
        VideoReport.setElementId(view, "em_xsj_sharepanel");
    }

    private final String a() {
        StringBuilder sb5 = new StringBuilder("https://h5.tu.qq.com/web/material-middle-page/online/index");
        sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        sb5.append("groupId=2");
        sb5.append("&serviceId=" + c(this.scene));
        sb5.append("&sdkVersion=" + b());
        sb5.append("&materialId=" + this.material.getId());
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder(DEFAULT_UR\u2026)\n            .toString()");
        w53.b.f("WinkShareMaterialH5Behavior", sb6);
        return sb6;
    }

    private final String b() {
        List split$default;
        if (TextUtils.isEmpty(LightVersionInfo.VERSION_NAME)) {
            return LightVersionInfo.VERSION_NAME;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) LightVersionInfo.VERSION_NAME, new String[]{"."}, false, 0, 6, (Object) null);
        Object[] array = split$default.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        String[] strArr = (String[]) array;
        if (strArr.length <= 3) {
            return LightVersionInfo.VERSION_NAME;
        }
        return strArr[0] + "." + strArr[1] + "." + strArr[2];
    }

    private final String c(String scene) {
        int hashCode = scene.hashCode();
        if (hashCode != -1892357474) {
            if (hashCode != -1596742217) {
                if (hashCode == -1412626175 && scene.equals(QQWinkConstants.CAMERA_MATERIAL)) {
                    return AECameraConstants.CAMERA_FLASH_SHOW_SERVICEID;
                }
            } else if (scene.equals(QQWinkConstants.AUTO_MATERIAL)) {
                return "MqKuaishanEdit";
            }
        } else if (scene.equals(QQWinkConstants.LINGGANKU_MATERIAL)) {
            return "MqKuaishanTemplate";
        }
        return "";
    }

    private final String d(IDateTransFrom material) {
        return material.getThumbUrl();
    }

    private final void e(int action) {
        String str;
        Map<String, Object> params = WinkDTParamBuilder.buildElementParams();
        if (action != 1) {
            if (action != 2) {
                if (action != 3) {
                    if (action != 9) {
                        if (action != 10) {
                            if (action != 72) {
                                if (action != 171) {
                                    str = "";
                                } else {
                                    str = WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_QQ_CHANNEL;
                                }
                            }
                        } else {
                            str = "wechat_moments";
                        }
                    } else {
                        str = "wechat_connects";
                    }
                } else {
                    str = WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_QZONE_QQ;
                }
            }
            str = "qq_aio-qq";
        } else {
            str = WinkDaTongReportConstant.ElementParamValue.XSJ_SHARE_COPY_LINK;
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_share_target", str);
        VideoReport.setElementId(this.reportView, "em_xsj_sharepanel");
        VideoReport.setElementClickPolicy(this.reportView, ClickPolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(this.reportView, EndExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("ev_xsj_sharepanel_action", this.reportView, params);
    }

    @JvmStatic
    @NotNull
    public static final IDateTransFrom f(@NotNull MetaMaterial metaMaterial) {
        return INSTANCE.a(metaMaterial);
    }

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem item, @NotNull ShareActionSheet shareActionSheet) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        WinkShareUtils winkShareUtils = new WinkShareUtils();
        String name = this.material.getName();
        String desc = this.material.getDesc();
        String d16 = d(this.material);
        String id5 = this.material.getId();
        String c16 = c(this.scene);
        int h16 = WinkShareUtils.INSTANCE.h(c16);
        e(item.action);
        int i3 = item.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 72) {
                                if (i3 == 171) {
                                    w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to CHANNEL");
                                    winkShareUtils.u(this.activity, a(), name, desc, d16, 0, h16);
                                }
                            } else {
                                w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to friend with uid = " + item.uin + " guildId = " + item.guildId);
                                if (item.uinType == 10014 && !TextUtils.isEmpty(item.guildId)) {
                                    winkShareUtils.u(this.activity, a(), name, desc, d16, 0, h16);
                                } else {
                                    WinkShareUtils.s(winkShareUtils, this.activity, item.uinType, item.uin, a(), name, desc, d16, "2", c16, b(), id5, 52132, null, 4096, null);
                                }
                            }
                        } else {
                            w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to WECHAT_CIRCLE");
                            winkShareUtils.v(this.activity, a(), name, desc, d16, true);
                        }
                    } else {
                        w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to WECHAT");
                        WinkShareUtils.w(winkShareUtils, this.activity, a(), name, desc, d16, false, 32, null);
                    }
                } else {
                    w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to QZONE");
                    WinkShareUtils.D(winkShareUtils, this.activity, a(), name, desc, d16, 0, 32, null);
                }
            } else {
                w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to friend");
                WinkShareUtils.s(winkShareUtils, this.activity, -1, null, a(), name, desc, d16, "2", c16, b(), id5, 52132, null, 4096, null);
            }
        } else {
            w53.b.f("WinkShareMaterialH5Behavior", "onItemClick to COPYLINK");
            winkShareUtils.c(this.activity, a());
        }
        shareActionSheet.dismiss();
    }
}
