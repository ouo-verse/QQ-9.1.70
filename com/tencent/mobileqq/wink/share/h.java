package com.tencent.mobileqq.wink.share;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightVersionInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 52\u00020\u0001:\u0001\u0003Bn\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0002\u0012\b\b\u0002\u0010 \u001a\u00020\u001b\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0!\u0012'\b\u0002\u0010.\u001a!\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010'\u0012\b\b\u0002\u00100\u001a\u00020\u0002\u00a2\u0006\u0004\b3\u00104J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00020\b0!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R3\u0010.\u001a!\u0012\u0013\u0012\u00110(\u00a2\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(+\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\u0017R\u0014\u00102\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\u001d\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/wink/share/h;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "", "a", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "shareActionSheet", "", "onItemClick", "Landroid/app/Activity;", "d", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/share/a;", "e", "Lcom/tencent/mobileqq/wink/share/a;", "getInfo", "()Lcom/tencent/mobileqq/wink/share/a;", "info", "f", "Ljava/lang/String;", "getServiceId", "()Ljava/lang/String;", "serviceId", "", tl.h.F, "I", "getRequestCode", "()I", "requestCode", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "getCallBack", "()Lkotlin/jvm/functions/Function0;", "callBack", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/jvm/functions/Function1;", "wxShareCallback", BdhLogUtil.LogTag.Tag_Conn, DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "D", "materialServiceId", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/share/a;Ljava/lang/String;ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Ljava/lang/String;)V", "E", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class h implements ShareActionSheet.OnItemClickListener {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String materialId;

    /* renamed from: D, reason: from kotlin metadata */
    private final int materialServiceId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a info;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String serviceId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int requestCode;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> callBack;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Boolean, Unit> wxShareCallback;

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull Activity activity, @NotNull a info, @NotNull String serviceId, int i3, @NotNull Function0<Unit> callBack, @Nullable Function1<? super Boolean, Unit> function1, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(serviceId, "serviceId");
        Intrinsics.checkNotNullParameter(callBack, "callBack");
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        this.activity = activity;
        this.info = info;
        this.serviceId = serviceId;
        this.requestCode = i3;
        this.callBack = callBack;
        this.wxShareCallback = function1;
        this.materialId = materialId;
        this.materialServiceId = WinkShareUtils.INSTANCE.h(serviceId);
    }

    private final String a() {
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

    @Override // com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener
    public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem item, @Nullable ShareActionSheet shareActionSheet) {
        boolean z16;
        WinkShareUtils winkShareUtils = new WinkShareUtils();
        if (item == null) {
            return;
        }
        String shareExternalUrl = this.info.getShareExternalUrl();
        if (shareExternalUrl != null && shareExternalUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            shareExternalUrl = this.info.getShareUrl();
        }
        int i3 = item.action;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 9) {
                        if (i3 != 10) {
                            if (i3 != 72) {
                                if (i3 == 171) {
                                    winkShareUtils.u(this.activity, this.info.getShareQZoneUrl(), this.info.getTitle(), this.info.getDesc(), this.info.getPreview(), this.requestCode, this.materialServiceId);
                                }
                            } else {
                                winkShareUtils.q(this.activity, item.uinType, item.uin, this.info.getShareUrl(), this.info.getTitle(), this.info.getDesc(), this.info.getPreview(), "2", this.serviceId, a(), this.materialId, this.requestCode, this.info.getShareQZoneUrl());
                            }
                        } else {
                            winkShareUtils.v(this.activity, shareExternalUrl, this.info.getTitle(), this.info.getDesc(), this.info.getPreview(), true);
                            Function1<Boolean, Unit> function1 = this.wxShareCallback;
                            if (function1 != null) {
                                function1.invoke(Boolean.TRUE);
                            }
                        }
                    } else {
                        WinkShareUtils.w(winkShareUtils, this.activity, shareExternalUrl, this.info.getTitle(), this.info.getDesc(), this.info.getPreview(), false, 32, null);
                        Function1<Boolean, Unit> function12 = this.wxShareCallback;
                        if (function12 != null) {
                            function12.invoke(Boolean.TRUE);
                        }
                    }
                } else {
                    winkShareUtils.C(this.activity, this.info.getShareQZoneUrl(), this.info.getTitle(), this.info.getDesc(), this.info.getPreview(), this.requestCode);
                }
            } else {
                WinkShareUtils.s(winkShareUtils, this.activity, -1, null, this.info.getShareUrl(), this.info.getTitle(), this.info.getDesc(), this.info.getPreview(), "2", this.serviceId, a(), this.materialId, this.requestCode, null, 4096, null);
            }
        } else {
            winkShareUtils.c(this.activity, shareExternalUrl);
        }
        this.callBack.invoke();
        if (shareActionSheet != null) {
            shareActionSheet.dismiss();
        }
    }
}
