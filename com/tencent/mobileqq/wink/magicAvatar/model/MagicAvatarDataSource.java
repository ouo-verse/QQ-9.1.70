package com.tencent.mobileqq.wink.magicAvatar.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.api.IPicUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.IWinkAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioDataSource;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import org.light.aigc.bean.AIGCContentOutput;
import org.light.aigc.bean.AIGCRequest;
import org.light.aigc.bean.ContentInfo;
import org.light.aigc.bean.MediaScene;
import qshadow.AIGCAvatarCount$Request;
import qshadow.AIGCAvatarCount$Response;
import qshadow.ShadowAIGCAvatar$GetStylePicturesReply;
import qshadow.ShadowAIGCAvatar$GetStylePicturesRequest;
import qshadow.ShadowAIGCAvatar$StylePictureInfo;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bT\u0010UJ\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0002J;\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ=\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ(\u0010!\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u001cH\u0002J\u0014\u0010#\u001a\u0004\u0018\u00010\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0007H\u0002J\u001c\u0010'\u001a\u0004\u0018\u00010\u00072\u0006\u0010$\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u001cH\u0002J/\u00101\u001a\u00020\u00052'\u00100\u001a#\u0012\u0015\u0012\u0013\u0018\u00010+\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00050*j\u0002`/J\u001b\u00103\u001a\u00020%2\u0006\u00102\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b3\u00104J%\u00105\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J-\u00107\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010;J\u001b\u0010<\u001a\u00020\u00192\u0006\u00109\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010;J\u0013\u0010=\u001a\u00020\u0019H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b=\u0010>J?\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070A2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bB\u0010CJ\u0012\u0010G\u001a\u00020\u00052\n\u0010F\u001a\u00060Dj\u0002`EJ-\u0010H\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00070A2\b\u0010&\u001a\u0004\u0018\u00010%H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\bH\u0010IJ\u0016\u0010F\u001a\u00020\u00052\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020\u0007R;\u0010O\u001a'\u0012\u0015\u0012\u0013\u0018\u00010+\u00a2\u0006\f\b,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u0005\u0018\u00010*j\u0004\u0018\u0001`/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010NR \u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010R\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarDataSource;", "", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "url", "genderStr", "", "glass", "styleId", "Lcom/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarPicAndStyles;", "u", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "cmd", "Lqshadow/AIGCAvatarCount$Request$SelectQuotaReq;", "selectQuotaReq", "Lqshadow/AIGCAvatarCount$Request$ReduceQuotaReq;", "reduceQuotaReq", "Lqshadow/AIGCAvatarCount$Request$PrivilegeReq;", "privilegeReq", "isGet", "Lcom/tencent/mobileqq/wink/magicAvatar/model/a;", "r", "(ILqshadow/AIGCAvatarCount$Request$SelectQuotaReq;Lqshadow/AIGCAvatarCount$Request$ReduceQuotaReq;Lqshadow/AIGCAvatarCount$Request$PrivilegeReq;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "reqWidth", "reqHeight", "width", "height", "j", "croppedPath", "g", WadlProxyConsts.PARAM_FILENAME, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "code", "k", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/wink/magicAvatar/model/e;", "Lkotlin/ParameterName;", "name", "info", "Lcom/tencent/mobileqq/wink/magicAvatar/model/PageInfoCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "path", DomainData.DOMAIN_NAME, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "w", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "t", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "from", "i", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "l", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "materialUrl", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "Lkotlin/Pair;", "o", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", HippyTKDListViewAdapter.X, h.F, "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/view/View;", "view", "elementId", "b", "Lkotlin/jvm/functions/Function1;", "cb", "Landroidx/lifecycle/Observer;", "c", "Landroidx/lifecycle/Observer;", "materialObserver", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MagicAvatarDataSource {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static Function1<? super PageInfoCallbackInfo, Unit> cb;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MagicAvatarDataSource f323499a = new MagicAvatarDataSource();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Observer<List<MetaCategory>> materialObserver = new Observer() { // from class: com.tencent.mobileqq.wink.magicAvatar.model.b
        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object obj) {
            MagicAvatarDataSource.p((List) obj);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/magicAvatar/model/MagicAvatarDataSource$a", "Lcom/tencent/biz/ProtoUtils$TroopProtocolObserver;", "", "errorCode", "", "data", "Landroid/os/Bundle;", "bundle", "", "onResult", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends ProtoUtils.TroopProtocolObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f323502d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f323503e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<AvatarCountInfo> f323504f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f323505h;

        /* JADX WARN: Multi-variable type inference failed */
        a(long j3, boolean z16, CancellableContinuation<? super AvatarCountInfo> cancellableContinuation, String str) {
            this.f323502d = j3;
            this.f323503e = z16;
            this.f323504f = cancellableContinuation;
            this.f323505h = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x001c  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int errorCode, @Nullable byte[] data, @Nullable Bundle bundle) {
            boolean z16;
            Object obj;
            int i3;
            Triple triple;
            AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaDetail quotaDetail;
            AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaDetail quotaDetail2;
            PBUInt32Field pBUInt32Field;
            boolean z17;
            AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaDetail quotaDetail3;
            AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaDetail quotaDetail4;
            PBUInt32Field pBUInt32Field2;
            boolean z18;
            int i16;
            Object obj2;
            int i17;
            AIGCAvatarCount$Response.SelectQuotaRsp.QuotaDetail quotaDetail5;
            AIGCAvatarCount$Response.SelectQuotaRsp.QuotaDetail quotaDetail6;
            PBUInt32Field pBUInt32Field3;
            boolean z19;
            AIGCAvatarCount$Response.SelectQuotaRsp.QuotaDetail quotaDetail7;
            AIGCAvatarCount$Response.SelectQuotaRsp.QuotaDetail quotaDetail8;
            PBUInt32Field pBUInt32Field4;
            boolean z26;
            boolean z27;
            long currentTimeMillis = System.currentTimeMillis() - this.f323502d;
            if (errorCode == 0) {
                int i18 = 0;
                if (data != null) {
                    if (data.length == 0) {
                        z27 = true;
                    } else {
                        z27 = false;
                    }
                    if (!z27) {
                        z16 = true;
                        if (z16) {
                            AIGCAvatarCount$Response aIGCAvatarCount$Response = new AIGCAvatarCount$Response();
                            aIGCAvatarCount$Response.mergeFrom(data);
                            Object obj3 = null;
                            if (this.f323503e) {
                                List<AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo> list = aIGCAvatarCount$Response.select_quota_rsp.quota_infos.get();
                                Intrinsics.checkNotNullExpressionValue(list, "res.select_quota_rsp.quota_infos.get()");
                                Iterator<T> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        obj2 = it.next();
                                        if (((AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo) obj2).quota_type.get() == 1) {
                                            z26 = true;
                                        } else {
                                            z26 = false;
                                        }
                                        if (z26) {
                                            break;
                                        }
                                    } else {
                                        obj2 = null;
                                        break;
                                    }
                                }
                                AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo quotaInfo = (AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo) obj2;
                                if (quotaInfo != null && (quotaDetail7 = quotaInfo.quota_detail) != null && (quotaDetail8 = quotaDetail7.get()) != null && (pBUInt32Field4 = quotaDetail8.remain_quota) != null) {
                                    i17 = pBUInt32Field4.get();
                                } else {
                                    i17 = 0;
                                }
                                List<AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo> list2 = aIGCAvatarCount$Response.select_quota_rsp.quota_infos.get();
                                Intrinsics.checkNotNullExpressionValue(list2, "res.select_quota_rsp.quota_infos.get()");
                                Iterator<T> it5 = list2.iterator();
                                while (true) {
                                    if (!it5.hasNext()) {
                                        break;
                                    }
                                    Object next = it5.next();
                                    if (((AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo) next).quota_type.get() == 2) {
                                        z19 = true;
                                    } else {
                                        z19 = false;
                                    }
                                    if (z19) {
                                        obj3 = next;
                                        break;
                                    }
                                }
                                AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo quotaInfo2 = (AIGCAvatarCount$Response.SelectQuotaRsp.QuotaInfo) obj3;
                                if (quotaInfo2 != null && (quotaDetail5 = quotaInfo2.quota_detail) != null && (quotaDetail6 = quotaDetail5.get()) != null && (pBUInt32Field3 = quotaDetail6.remain_quota) != null) {
                                    i18 = pBUInt32Field3.get();
                                }
                                triple = new Triple(Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(aIGCAvatarCount$Response.privilege_rsp.svip_quota_total.get()));
                            } else {
                                List<AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo> list3 = aIGCAvatarCount$Response.reduce_quota_rsp.quota_infos.get();
                                Intrinsics.checkNotNullExpressionValue(list3, "res.reduce_quota_rsp.quota_infos.get()");
                                Iterator<T> it6 = list3.iterator();
                                while (true) {
                                    if (it6.hasNext()) {
                                        obj = it6.next();
                                        if (((AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo) obj).quota_type.get() == 1) {
                                            z18 = true;
                                        } else {
                                            z18 = false;
                                        }
                                        if (z18) {
                                            break;
                                        }
                                    } else {
                                        obj = null;
                                        break;
                                    }
                                }
                                AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo quotaInfo3 = (AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo) obj;
                                if (quotaInfo3 != null && (quotaDetail3 = quotaInfo3.quota_detail) != null && (quotaDetail4 = quotaDetail3.get()) != null && (pBUInt32Field2 = quotaDetail4.remain_quota) != null) {
                                    i3 = pBUInt32Field2.get();
                                } else {
                                    i3 = 0;
                                }
                                List<AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo> list4 = aIGCAvatarCount$Response.reduce_quota_rsp.quota_infos.get();
                                Intrinsics.checkNotNullExpressionValue(list4, "res.reduce_quota_rsp.quota_infos.get()");
                                Iterator<T> it7 = list4.iterator();
                                while (true) {
                                    if (!it7.hasNext()) {
                                        break;
                                    }
                                    Object next2 = it7.next();
                                    if (((AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo) next2).quota_type.get() == 2) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    if (z17) {
                                        obj3 = next2;
                                        break;
                                    }
                                }
                                AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo quotaInfo4 = (AIGCAvatarCount$Response.ReduceQuotaRsp.QuotaInfo) obj3;
                                if (quotaInfo4 != null && (quotaDetail = quotaInfo4.quota_detail) != null && (quotaDetail2 = quotaDetail.get()) != null && (pBUInt32Field = quotaDetail2.remain_quota) != null) {
                                    i18 = pBUInt32Field.get();
                                }
                                triple = new Triple(Integer.valueOf(i3), Integer.valueOf(i18), Integer.valueOf(aIGCAvatarCount$Response.privilege_rsp.svip_quota_total.get()));
                            }
                            int intValue = ((Number) triple.component1()).intValue();
                            int intValue2 = ((Number) triple.component2()).intValue();
                            int intValue3 = ((Number) triple.component3()).intValue();
                            if (this.f323503e) {
                                i16 = aIGCAvatarCount$Response.select_quota_rsp.extra_info.get().svip_level.get();
                            } else {
                                i16 = aIGCAvatarCount$Response.reduce_quota_rsp.extra_info.get().svip_level.get();
                            }
                            CancellableContinuation<AvatarCountInfo> cancellableContinuation = this.f323504f;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(new AvatarCountInfo(intValue, intValue2, i16, intValue3)));
                            w93.e.f445096a.e(this.f323505h, currentTimeMillis, errorCode);
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            CancellableContinuation<AvatarCountInfo> cancellableContinuation2 = this.f323504f;
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuation2.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new Exception(String.valueOf(errorCode)))));
            w93.e.f445096a.e(this.f323505h, currentTimeMillis, errorCode);
        }
    }

    MagicAvatarDataSource() {
    }

    private final String g(String croppedPath) {
        boolean z16;
        if (croppedPath != null && croppedPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return null;
        }
        try {
            String fileName = FileUtils.getFileName(croppedPath);
            String winkCachePath = ((IWinkAPI) QRoute.api(IWinkAPI.class)).getWinkCachePath(System.nanoTime() + "_" + fileName);
            FileUtils.copyFile(croppedPath, winkCachePath);
            return winkCachePath;
        } catch (Exception e16) {
            w53.b.d("MagicAvatarDataSource", "copyFileForAvatarVideo ioexception", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int j(long reqWidth, long reqHeight, long width, long height) {
        int roundToInt;
        int roundToInt2;
        int coerceAtLeast;
        if (reqWidth == 0 || reqHeight == 0 || reqWidth == -1 || reqHeight == -1) {
            return 1;
        }
        long j3 = reqWidth * reqHeight;
        long j16 = height;
        int i3 = 1;
        long j17 = width;
        while (true) {
            if ((j16 <= reqHeight && j17 <= reqWidth) || j17 * j16 <= j3) {
                break;
            }
            roundToInt = MathKt__MathJVMKt.roundToInt(((float) j16) / ((float) reqHeight));
            roundToInt2 = MathKt__MathJVMKt.roundToInt(((float) j17) / ((float) reqWidth));
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(roundToInt, roundToInt2);
            if (coerceAtLeast < 2) {
                break;
            }
            long j18 = 2;
            j17 /= j18;
            j16 /= j18;
            i3 *= 2;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String k(long code) {
        if (code == 2114) {
            return "\u8bf7\u6362\u4e00\u5f20\u56fe\u7247\u8bd5\u8bd5";
        }
        if (code == 2111) {
            return "\u6d3b\u52a8\u592a\u706b\u7206\uff0c\u8bf7\u7a0d\u540e\u518d\u6765";
        }
        boolean z16 = false;
        if (1001 <= code && code < 1101) {
            z16 = true;
        }
        if (z16) {
            return "\u8bf7\u6362\u4e00\u4e2a\u66f4\u6e05\u6670\u7684\u6709\u4eba\u8138\u7684\u56fe\u7247";
        }
        return "\u9047\u5230\u4e86\u672a\u77e5\u9519\u8bef\uff0c\u8bf7\u91cd\u65b0\u8bd5\u8bd5";
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(List<MetaCategory> data) {
        boolean z16;
        List emptyList;
        Object obj;
        ArrayList<MetaMaterial> arrayList;
        int collectionSizeOrDefault;
        List<MetaCategory> list = data;
        if (list != null && !list.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        MetaMaterial metaMaterial = null;
        if (!z16) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            for (MetaCategory metaCategory : data) {
                if (Intrinsics.areEqual("banner", metaCategory.f30532id)) {
                    ArrayList<MetaMaterial> arrayList2 = metaCategory.materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList2, "category.materials");
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
                    ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
                    for (MetaMaterial metaMaterial2 : arrayList2) {
                        String str = metaMaterial2.f30533id;
                        Intrinsics.checkNotNullExpressionValue(str, "it.id");
                        String str2 = metaMaterial2.thumbUrl;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.thumbUrl");
                        String str3 = metaMaterial2.additionalFields.get("name");
                        if (str3 == null) {
                            str3 = "";
                        }
                        arrayList3.add(new MagicAvatarStyleBanner(str, str2, str3));
                    }
                    emptyList = arrayList3;
                }
            }
            w53.b.f("MagicAvatarDataSource", "handleMagicStudioMaterials list " + emptyList.size());
            Iterator<T> it = data.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, MosaicConstants$JsProperty.APP_RESOURCE)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MetaCategory metaCategory2 = (MetaCategory) obj;
            if (metaCategory2 != null && (arrayList = metaCategory2.materials) != null) {
                Iterator<T> it5 = arrayList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    Object next = it5.next();
                    if (Intrinsics.areEqual(((MetaMaterial) next).f30533id, "magic_avatar_home_page_head_bg")) {
                        metaMaterial = next;
                        break;
                    }
                }
                metaMaterial = metaMaterial;
            }
            Function1<? super PageInfoCallbackInfo, Unit> function1 = cb;
            if (function1 != null) {
                function1.invoke(new PageInfoCallbackInfo(emptyList, metaMaterial));
                return;
            }
            return;
        }
        Function1<? super PageInfoCallbackInfo, Unit> function12 = cb;
        if (function12 != null) {
            function12.invoke(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(List list) {
        f323499a.m(list);
    }

    private final Object r(int i3, AIGCAvatarCount$Request.SelectQuotaReq selectQuotaReq, AIGCAvatarCount$Request.ReduceQuotaReq reduceQuotaReq, AIGCAvatarCount$Request.PrivilegeReq privilegeReq, boolean z16, Continuation<? super AvatarCountInfo> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        AIGCAvatarCount$Request aIGCAvatarCount$Request = new AIGCAvatarCount$Request();
        aIGCAvatarCount$Request.cmd.set(i3);
        aIGCAvatarCount$Request.select_quota_req.set(selectQuotaReq);
        aIGCAvatarCount$Request.reduce_quota_req.set(reduceQuotaReq);
        aIGCAvatarCount$Request.privilege_req.set(privilegeReq);
        ProtoUtils.a(MobileQQ.sMobileQQ.peekAppRuntime(), new a(System.currentTimeMillis(), z16, cancellableContinuationImpl, "OidbSvcTrpcTcp.0x904a_0"), aIGCAvatarCount$Request.toByteArray(), "OidbSvcTrpcTcp.0x904a_0", 36938, 0);
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    static /* synthetic */ Object s(MagicAvatarDataSource magicAvatarDataSource, int i3, AIGCAvatarCount$Request.SelectQuotaReq selectQuotaReq, AIGCAvatarCount$Request.ReduceQuotaReq reduceQuotaReq, AIGCAvatarCount$Request.PrivilegeReq privilegeReq, boolean z16, Continuation continuation, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            z16 = true;
        }
        return magicAvatarDataSource.r(i3, selectQuotaReq, reduceQuotaReq, privilegeReq, z16, continuation);
    }

    private final Object u(String str, String str2, boolean z16, String str3, Continuation<? super MagicAvatarPicAndStyles> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        w53.b.a("MagicAvatarDataSource", "requestStyle url= " + str + ", genderStr= " + str2 + ", glass = " + z16 + ", styleId=" + str3);
        ShadowAIGCAvatar$GetStylePicturesRequest shadowAIGCAvatar$GetStylePicturesRequest = new ShadowAIGCAvatar$GetStylePicturesRequest();
        shadowAIGCAvatar$GetStylePicturesRequest.user_pic_url.set(str);
        shadowAIGCAvatar$GetStylePicturesRequest.with_glasses.set(z16);
        shadowAIGCAvatar$GetStylePicturesRequest.gender.set(str2);
        shadowAIGCAvatar$GetStylePicturesRequest.style.set(str3);
        w93.e.f445096a.f(new MagicAvatarStyleReq(shadowAIGCAvatar$GetStylePicturesRequest), new w93.a<ShadowAIGCAvatar$GetStylePicturesReply>() { // from class: com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource$requestStyle$2$1
            @Override // w93.a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(boolean isSuccess, long retCode, @Nullable String msg2, @Nullable BaseRequest pbRequest, @Nullable ShadowAIGCAvatar$GetStylePicturesReply pbResponse) {
                final String k3;
                int collectionSizeOrDefault;
                QLog.d("MagicAvatarDataSource", 1, "requestStyle onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | retMessage:" + msg2);
                if (retCode != 0 || !isSuccess || pbResponse == null) {
                    k3 = MagicAvatarDataSource.f323499a.k(retCode);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarDataSource$requestStyle$2$1$handlePbResponse$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            QQToast.makeText(BaseApplication.getContext(), k3, 0).show();
                        }
                    });
                    CancellableContinuation<MagicAvatarPicAndStyles> cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(new IllegalStateException("rsp invalid " + retCode + " " + isSuccess))));
                    return;
                }
                List<ShadowAIGCAvatar$StylePictureInfo> list = pbResponse.style_pictures.get();
                Intrinsics.checkNotNullExpressionValue(list, "pbResponse.style_pictures.get()");
                List<ShadowAIGCAvatar$StylePictureInfo> list2 = list;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (ShadowAIGCAvatar$StylePictureInfo shadowAIGCAvatar$StylePictureInfo : list2) {
                    MagicAvatarMaterialInfo magicAvatarMaterialInfo = new MagicAvatarMaterialInfo();
                    String str4 = shadowAIGCAvatar$StylePictureInfo.material_id.get();
                    String str5 = "";
                    if (str4 == null) {
                        str4 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str4, "it.material_id.get() ?: \"\"");
                    }
                    magicAvatarMaterialInfo.setMaterialId(str4);
                    String str6 = shadowAIGCAvatar$StylePictureInfo.material_url.get();
                    if (str6 == null) {
                        str6 = "";
                    } else {
                        Intrinsics.checkNotNullExpressionValue(str6, "it.material_url.get() ?: \"\"");
                    }
                    magicAvatarMaterialInfo.setMaterialUrl(str6);
                    String str7 = shadowAIGCAvatar$StylePictureInfo.style_name.get();
                    if (str7 != null) {
                        Intrinsics.checkNotNullExpressionValue(str7, "it.style_name.get() ?: \"\"");
                        str5 = str7;
                    }
                    magicAvatarMaterialInfo.setStyleName(str5);
                    arrayList.add(magicAvatarMaterialInfo);
                }
                MagicAvatarPicAndStyles magicAvatarPicAndStyles = new MagicAvatarPicAndStyles();
                magicAvatarPicAndStyles.setMaterials(new ArrayList<>(arrayList));
                magicAvatarPicAndStyles.setGlass(pbResponse.with_glasses.get());
                String str8 = pbResponse.gender.get();
                Intrinsics.checkNotNullExpressionValue(str8, "pbResponse.gender.get()");
                magicAvatarPicAndStyles.setGender(str8);
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(magicAvatarPicAndStyles));
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    static /* synthetic */ Object v(MagicAvatarDataSource magicAvatarDataSource, String str, String str2, boolean z16, String str3, Continuation continuation, int i3, Object obj) {
        String str4;
        String str5;
        String str6;
        if ((i3 & 1) != 0) {
            str4 = "";
        } else {
            str4 = str;
        }
        if ((i3 & 2) != 0) {
            str5 = "";
        } else {
            str5 = str2;
        }
        if ((i3 & 4) != 0) {
            z16 = false;
        }
        boolean z17 = z16;
        if ((i3 & 8) != 0) {
            str6 = "";
        } else {
            str6 = str3;
        }
        return magicAvatarDataSource.u(str4, str5, z17, str6, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        QQToast.makeText(BaseApplication.getContext(), msg2, 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String z(String fileName, Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        OutputStream outputStream = null;
        if (bitmap == null) {
            return null;
        }
        String str = u53.b.f438375f + File.separator;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String str2 = str + fileName;
        File file2 = new File(str2);
        try {
            try {
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            } catch (IOException e16) {
                e = e16;
                bufferedOutputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream != null) {
                }
                throw th;
            }
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                try {
                    bufferedOutputStream.close();
                } catch (IOException e17) {
                    w53.b.d("MagicAvatarDataSource", "ioexception2", e17);
                }
                return str2;
            } catch (IOException e18) {
                e = e18;
                w53.b.d("MagicAvatarDataSource", "ioexception", e);
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e19) {
                        w53.b.d("MagicAvatarDataSource", "ioexception2", e19);
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream = file2;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e26) {
                    w53.b.d("MagicAvatarDataSource", "ioexception2", e26);
                }
            }
            throw th;
        }
    }

    public final void e(@NotNull View view, @NotNull String elementId) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementId, "elementId");
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
    }

    @Nullable
    public final Object f(int i3, @NotNull Continuation<? super AvatarCountInfo> continuation) {
        int nextInt = new Random().nextInt();
        AIGCAvatarCount$Request.ReduceQuotaReq reduceQuotaReq = new AIGCAvatarCount$Request.ReduceQuotaReq();
        reduceQuotaReq.busi_type.set(i3);
        reduceQuotaReq.quota_type.set(0);
        reduceQuotaReq.reduce_num.set(1);
        reduceQuotaReq.random_seq.set(nextInt);
        return r(200, new AIGCAvatarCount$Request.SelectQuotaReq(), reduceQuotaReq, new AIGCAvatarCount$Request.PrivilegeReq(), false, continuation);
    }

    @Nullable
    public final Object h(@Nullable Bitmap bitmap, @NotNull Continuation<? super Pair<String, String>> continuation) {
        String z16 = z(String.valueOf(System.currentTimeMillis()), bitmap);
        return TuplesKt.to(z16, g(z16));
    }

    @Nullable
    public final Object i(int i3, @NotNull Continuation<? super AvatarCountInfo> continuation) {
        AIGCAvatarCount$Request.SelectQuotaReq selectQuotaReq = new AIGCAvatarCount$Request.SelectQuotaReq();
        selectQuotaReq.busi_type.set(i3);
        return s(this, 100, selectQuotaReq, new AIGCAvatarCount$Request.ReduceQuotaReq(), new AIGCAvatarCount$Request.PrivilegeReq(), false, continuation, 16, null);
    }

    @Nullable
    public final Object l(@NotNull Continuation<? super AvatarCountInfo> continuation) {
        AIGCAvatarCount$Request.PrivilegeReq privilegeReq = new AIGCAvatarCount$Request.PrivilegeReq();
        privilegeReq.scenes.set("QQ");
        return r(300, new AIGCAvatarCount$Request.SelectQuotaReq(), new AIGCAvatarCount$Request.ReduceQuotaReq(), privilegeReq, false, continuation);
    }

    @Nullable
    public final Object n(@NotNull String str, @NotNull Continuation<? super Bitmap> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = f323499a.j(512L, 512L, options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
            Intrinsics.checkNotNullExpressionValue(decodeFile, "decodeFile(path, opts)");
            Bitmap exifBitmap = ((IPicUtil) QRoute.api(IPicUtil.class)).getExifBitmap(str, decodeFile);
            Intrinsics.checkNotNullExpressionValue(exifBitmap, "api(IPicUtil::class.java\u2026tExifBitmap(path, bitmap)");
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(exifBitmap));
        } catch (Exception e16) {
            QLog.d("MagicAvatarCropViewModel", 1, "loadBitmap err " + e16);
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e16)));
        } catch (OutOfMemoryError e17) {
            QLog.d("MagicAvatarCropViewModel", 1, "loadBitmap OutOfMemoryError " + e17);
            Result.Companion companion2 = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(ResultKt.createFailure(e17)));
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008e A[Catch: Exception -> 0x0030, TryCatch #0 {Exception -> 0x0030, blocks: (B:11:0x002c, B:12:0x0074, B:14:0x008e, B:15:0x0094, B:17:0x009a, B:33:0x00a9, B:36:0x00b2, B:38:0x00af, B:21:0x00b5, B:24:0x00b9, B:27:0x00c2, B:30:0x00bf, B:40:0x00c5), top: B:10:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object o(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull Continuation<? super Pair<String, String>> continuation) {
        MagicAvatarDataSource$makeAvatar$1 magicAvatarDataSource$makeAvatar$1;
        Object coroutine_suspended;
        int i3;
        MagicAvatarDataSource magicAvatarDataSource;
        List<ContentInfo> list;
        T t16;
        T t17;
        if (continuation instanceof MagicAvatarDataSource$makeAvatar$1) {
            magicAvatarDataSource$makeAvatar$1 = (MagicAvatarDataSource$makeAvatar$1) continuation;
            int i16 = magicAvatarDataSource$makeAvatar$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                magicAvatarDataSource$makeAvatar$1.label = i16 - Integer.MIN_VALUE;
                Object obj = magicAvatarDataSource$makeAvatar$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = magicAvatarDataSource$makeAvatar$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        magicAvatarDataSource = (MagicAvatarDataSource) magicAvatarDataSource$makeAvatar$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                        } catch (Exception e16) {
                            e = e16;
                            magicAvatarDataSource.x(e);
                            return TuplesKt.to("", "");
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("base_material_id", str4);
                        jSONObject.put("base_material_url", str3);
                        jSONObject.put(QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, str2);
                        com.tencent.mobileqq.wink.aigc.utils.b bVar = com.tencent.mobileqq.wink.aigc.utils.b.f317941a;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
                        AIGCRequest f16 = bVar.f(str, jSONObject2);
                        MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                        magicAvatarDataSource$makeAvatar$1.L$0 = this;
                        magicAvatarDataSource$makeAvatar$1.label = 1;
                        obj = magicStudioDataSource.i0(f16, magicAvatarDataSource$makeAvatar$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e17) {
                        e = e17;
                        magicAvatarDataSource = this;
                        magicAvatarDataSource.x(e);
                        return TuplesKt.to("", "");
                    }
                }
                AIGCContentOutput aIGCContentOutput = (AIGCContentOutput) ((Pair) obj).component1();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = "";
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = "";
                list = aIGCContentOutput.contentInfos;
                if (list != null) {
                    for (ContentInfo contentInfo : list) {
                        MediaScene mediaScene = contentInfo.scene;
                        if (mediaScene == MediaScene.SceneResultWithQrCode) {
                            String str5 = contentInfo.stringData;
                            if (str5 == null) {
                                t16 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(str5, "it.stringData ?: \"\"");
                                t16 = str5;
                            }
                            objectRef2.element = t16;
                        } else if (mediaScene == MediaScene.SceneResult) {
                            String str6 = contentInfo.stringData;
                            if (str6 == null) {
                                t17 = "";
                            } else {
                                Intrinsics.checkNotNullExpressionValue(str6, "it.stringData ?: \"\"");
                                t17 = str6;
                            }
                            objectRef.element = t17;
                        }
                    }
                }
                return TuplesKt.to(objectRef.element, objectRef2.element);
            }
        }
        magicAvatarDataSource$makeAvatar$1 = new MagicAvatarDataSource$makeAvatar$1(this, continuation);
        Object obj2 = magicAvatarDataSource$makeAvatar$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = magicAvatarDataSource$makeAvatar$1.label;
        if (i3 == 0) {
        }
        AIGCContentOutput aIGCContentOutput2 = (AIGCContentOutput) ((Pair) obj2).component1();
        Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        objectRef3.element = "";
        Ref.ObjectRef objectRef22 = new Ref.ObjectRef();
        objectRef22.element = "";
        list = aIGCContentOutput2.contentInfos;
        if (list != null) {
        }
        return TuplesKt.to(objectRef3.element, objectRef22.element);
    }

    public final void q(@NotNull Function1<? super PageInfoCallbackInfo, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        cb = callback;
        WinkEditorResourceManager.a1().j1().observeForever(materialObserver);
    }

    @Nullable
    public final Object t(@NotNull String str, boolean z16, @NotNull String str2, @NotNull Continuation<? super MagicAvatarPicAndStyles> continuation) {
        return v(this, null, str, z16, str2, continuation, 1, null);
    }

    @Nullable
    public final Object w(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super MagicAvatarPicAndStyles> continuation) {
        return v(this, str, null, false, str2, continuation, 6, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
    
        r8 = kotlin.text.StringsKt__StringsKt.split$default((java.lang.CharSequence) r1, new java.lang.String[]{","}, false, 0, 6, (java.lang.Object) null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void x(@NotNull Exception e16) {
        List emptyList;
        Intrinsics.checkNotNullParameter(e16, "e");
        try {
            String message = e16.getMessage();
            if (message == null || emptyList == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (emptyList.size() == 2) {
                final String k3 = k(Long.parseLong((String) emptyList.get(0)));
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.magicAvatar.model.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        MagicAvatarDataSource.y(k3);
                    }
                });
            }
        } catch (Exception unused) {
            MagicStudioDataSource.f323652a.l0(0L, "");
        }
    }
}
