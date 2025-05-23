package com.tencent.mobileqq.onlinestatus.debug;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanel;
import com.tencent.mobileqq.onlinestatus.af;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.au;
import com.tencent.mobileqq.onlinestatus.av;
import com.tencent.mobileqq.onlinestatus.aw;
import com.tencent.mobileqq.onlinestatus.ba;
import com.tencent.mobileqq.onlinestatus.bt;
import com.tencent.mobileqq.onlinestatus.debug.OnlineStatusDebugFragment;
import com.tencent.mobileqq.onlinestatus.model.CustomShareInfo;
import com.tencent.mobileqq.onlinestatus.networkhandler.CustomHandler;
import com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver;
import com.tencent.mobileqq.onlinestatus.utils.NewStatusCache;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.onlinestatus.OnlineStatusShareInfo$GetShareInfoRsp;
import tencent.im.onlinestatus.OnlineStatusShareInfo$SetShareInfoRsp;
import tencent.im.onlinestatus.OnlineStatusShareInfo$ShareInfoItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002IM\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0014J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0013\u001a\u00020\u0004H\u0016J&\u0010\u0018\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001dj\b\u0012\u0004\u0012\u00020\u0014`\u001eH\u0016J\u0018\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u001dj\b\u0012\u0004\u0012\u00020\u0014`\u001eH\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u0010#R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0016\u0010<\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010#R\u0016\u0010>\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010#R\u0016\u0010@\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010#R\u0016\u0010C\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u00103R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010P\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020R0Q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/onlinestatus/aw$a;", "Lcom/tencent/mobileqq/onlinestatus/OnlineStatusPanel$a;", "", "Fh", "", "syncTye", "", "extInfo", "Dh", "Ch", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/onlinestatus/au;", "oldItem", "curItem", "curView", "g2", "v", "l3", "statusItem", "Q9", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getDataList", "Qg", "Landroid/widget/Button;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/Button;", "mSetStatusBtn", "D", "mSetShareInfoBtn", "E", "mGetShareInfoBtn", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "mStatusResTv", "G", "mShareInfoResTv", "Lcom/tencent/mobileqq/onlinestatus/bt;", "H", "Lcom/tencent/mobileqq/onlinestatus/bt;", "mStatusPanelCtrl", "I", "mInfoTypeBtn", "Landroid/widget/EditText;", "J", "Landroid/widget/EditText;", "mInfoUrlInput", "K", "mInfoSubtitleInput", "L", "mPreSetImageBtn", "M", "mSetMusicStatusBtn", "N", "mSetVideoStatusBtn", "P", "Landroid/view/View;", "mClearNewStatusCacheBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/onlinestatus/au;", "mOnlineStatusItem", BdhLogUtil.LogTag.Tag_Req, "mShareType", "com/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment$a", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment$a;", "mOnlineStatusUpdateObserver", "com/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment$b", "T", "Lcom/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment$b;", "mShareInfoObserver", "", "Lcom/tencent/mobileqq/onlinestatus/debug/a;", "U", "Ljava/util/List;", "mImageList", "<init>", "()V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class OnlineStatusDebugFragment extends QIphoneTitleBarFragment implements aw.a, OnlineStatusPanel.a {

    /* renamed from: C, reason: from kotlin metadata */
    private Button mSetStatusBtn;

    /* renamed from: D, reason: from kotlin metadata */
    private Button mSetShareInfoBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private Button mGetShareInfoBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView mStatusResTv;

    /* renamed from: G, reason: from kotlin metadata */
    private TextView mShareInfoResTv;

    /* renamed from: H, reason: from kotlin metadata */
    private bt mStatusPanelCtrl;

    /* renamed from: I, reason: from kotlin metadata */
    private Button mInfoTypeBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private EditText mInfoUrlInput;

    /* renamed from: K, reason: from kotlin metadata */
    private EditText mInfoSubtitleInput;

    /* renamed from: L, reason: from kotlin metadata */
    private Button mPreSetImageBtn;

    /* renamed from: M, reason: from kotlin metadata */
    private Button mSetMusicStatusBtn;

    /* renamed from: N, reason: from kotlin metadata */
    private Button mSetVideoStatusBtn;

    /* renamed from: P, reason: from kotlin metadata */
    private View mClearNewStatusCacheBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private au mOnlineStatusItem;

    /* renamed from: R, reason: from kotlin metadata */
    private int mShareType;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final a mOnlineStatusUpdateObserver = new a();

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final b mShareInfoObserver = new b();

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final List<com.tencent.mobileqq.onlinestatus.debug.a> mImageList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment$a", "Lcom/tencent/mobileqq/onlinestatus/av;", "", "isSuccess", "Landroid/os/Bundle;", "data", "", "f", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class a extends av {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.av
        public void f(boolean isSuccess, @Nullable Bundle data) {
            if (OnlineStatusDebugFragment.this.mStatusResTv != null) {
                TextView textView = OnlineStatusDebugFragment.this.mStatusResTv;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mStatusResTv");
                    textView = null;
                }
                textView.setText("\u8bbe\u7f6e\u5728\u7ebf\u72b6\u6001 isSuccess: " + isSuccess + "\ndata: " + data);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/onlinestatus/debug/OnlineStatusDebugFragment$b", "Lcom/tencent/mobileqq/onlinestatus/observer/OnlineStatusCustomObserver;", "", "isSuccess", "", "data", "", "c", "b", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public static final class b extends OnlineStatusCustomObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver
        public void b(boolean isSuccess, @Nullable Object data) {
            com.tencent.mobileqq.onlinestatus.observer.a aVar;
            Object obj;
            OnlineStatusShareInfo$ShareInfoItem onlineStatusShareInfo$ShareInfoItem;
            OnlineStatusShareInfo$GetShareInfoRsp onlineStatusShareInfo$GetShareInfoRsp;
            Integer num;
            String str;
            String str2;
            Integer num2;
            Long l3;
            PBBytesField pBBytesField;
            ByteStringMicro byteStringMicro;
            PBUInt64Field pBUInt64Field;
            PBUInt32Field pBUInt32Field;
            PBBytesField pBBytesField2;
            ByteStringMicro byteStringMicro2;
            PBBytesField pBBytesField3;
            ByteStringMicro byteStringMicro3;
            PBUInt32Field pBUInt32Field2;
            if (OnlineStatusDebugFragment.this.mStatusResTv == null) {
                return;
            }
            String str3 = null;
            if (data instanceof com.tencent.mobileqq.onlinestatus.observer.a) {
                aVar = (com.tencent.mobileqq.onlinestatus.observer.a) data;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                obj = aVar.a();
            } else {
                obj = null;
            }
            if (obj instanceof OnlineStatusShareInfo$ShareInfoItem) {
                onlineStatusShareInfo$ShareInfoItem = (OnlineStatusShareInfo$ShareInfoItem) obj;
            } else {
                onlineStatusShareInfo$ShareInfoItem = null;
            }
            if (aVar != null) {
                FromServiceMsg res = aVar.getRes();
                onlineStatusShareInfo$GetShareInfoRsp = new OnlineStatusShareInfo$GetShareInfoRsp();
                onlineStatusShareInfo$GetShareInfoRsp.mergeFrom(res.getWupBuffer());
            } else {
                onlineStatusShareInfo$GetShareInfoRsp = null;
            }
            TextView textView = OnlineStatusDebugFragment.this.mShareInfoResTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareInfoResTv");
                textView = null;
            }
            if (onlineStatusShareInfo$GetShareInfoRsp != null && (pBUInt32Field2 = onlineStatusShareInfo$GetShareInfoRsp.err_code) != null) {
                num = Integer.valueOf(pBUInt32Field2.get());
            } else {
                num = null;
            }
            if (onlineStatusShareInfo$GetShareInfoRsp != null && (pBBytesField3 = onlineStatusShareInfo$GetShareInfoRsp.err_msg) != null && (byteStringMicro3 = pBBytesField3.get()) != null) {
                str = byteStringMicro3.toStringUtf8();
            } else {
                str = null;
            }
            if (onlineStatusShareInfo$ShareInfoItem != null && (pBBytesField2 = onlineStatusShareInfo$ShareInfoItem.share_url) != null && (byteStringMicro2 = pBBytesField2.get()) != null) {
                str2 = byteStringMicro2.toStringUtf8();
            } else {
                str2 = null;
            }
            if (onlineStatusShareInfo$ShareInfoItem != null && (pBUInt32Field = onlineStatusShareInfo$ShareInfoItem.share_type) != null) {
                num2 = Integer.valueOf(pBUInt32Field.get());
            } else {
                num2 = null;
            }
            if (onlineStatusShareInfo$ShareInfoItem != null && (pBUInt64Field = onlineStatusShareInfo$ShareInfoItem.uin) != null) {
                l3 = Long.valueOf(pBUInt64Field.get());
            } else {
                l3 = null;
            }
            if (onlineStatusShareInfo$ShareInfoItem != null && (pBBytesField = onlineStatusShareInfo$ShareInfoItem.share_wording) != null && (byteStringMicro = pBBytesField.get()) != null) {
                str3 = byteStringMicro.toStringUtf8();
            }
            textView.setText("\u62c9\u53d6\u5206\u4eab\u4fe1\u606f isSuccess: " + isSuccess + " \nrsp: { code: " + num + " msg: " + str + " } \nshareInfo: { url: " + str2 + "  type: " + num2 + " uin: " + l3 + " subTitle: " + str3 + " }");
        }

        @Override // com.tencent.mobileqq.onlinestatus.observer.OnlineStatusCustomObserver
        public void c(boolean isSuccess, @Nullable Object data) {
            com.tencent.mobileqq.onlinestatus.observer.a aVar;
            Object obj;
            CustomShareInfo customShareInfo;
            OnlineStatusShareInfo$SetShareInfoRsp onlineStatusShareInfo$SetShareInfoRsp;
            Integer num;
            PBBytesField pBBytesField;
            ByteStringMicro byteStringMicro;
            PBUInt32Field pBUInt32Field;
            if (OnlineStatusDebugFragment.this.mStatusResTv == null) {
                return;
            }
            String str = null;
            if (data instanceof com.tencent.mobileqq.onlinestatus.observer.a) {
                aVar = (com.tencent.mobileqq.onlinestatus.observer.a) data;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                obj = aVar.a();
            } else {
                obj = null;
            }
            if (obj instanceof CustomShareInfo) {
                customShareInfo = (CustomShareInfo) obj;
            } else {
                customShareInfo = null;
            }
            if (aVar != null) {
                FromServiceMsg res = aVar.getRes();
                onlineStatusShareInfo$SetShareInfoRsp = new OnlineStatusShareInfo$SetShareInfoRsp();
                onlineStatusShareInfo$SetShareInfoRsp.mergeFrom(res.getWupBuffer());
            } else {
                onlineStatusShareInfo$SetShareInfoRsp = null;
            }
            TextView textView = OnlineStatusDebugFragment.this.mShareInfoResTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mShareInfoResTv");
                textView = null;
            }
            if (onlineStatusShareInfo$SetShareInfoRsp != null && (pBUInt32Field = onlineStatusShareInfo$SetShareInfoRsp.err_code) != null) {
                num = Integer.valueOf(pBUInt32Field.get());
            } else {
                num = null;
            }
            if (onlineStatusShareInfo$SetShareInfoRsp != null && (pBBytesField = onlineStatusShareInfo$SetShareInfoRsp.err_msg) != null && (byteStringMicro = pBBytesField.get()) != null) {
                str = byteStringMicro.toStringUtf8();
            }
            textView.setText("\u8bbe\u7f6e\u5206\u4eab\u4fe1\u606f isSuccess: " + isSuccess + "\nrsp: { code: " + num + " msg: " + str + " }\nshareInfo: " + customShareInfo);
        }
    }

    public OnlineStatusDebugFragment() {
        List<com.tencent.mobileqq.onlinestatus.debug.a> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new com.tencent.mobileqq.onlinestatus.debug.a[]{new com.tencent.mobileqq.onlinestatus.debug.a("\u5929\u7a7a", "https://static-res.qq.com/static-res/jaxlin/bg_sky.png"), new com.tencent.mobileqq.onlinestatus.debug.a("\u6c99\u6f20", "https://static-res.qq.com/static-res/jaxlin/bg_sand.png"), new com.tencent.mobileqq.onlinestatus.debug.a("\u82b1", "https://static-res.qq.com/static-res/jaxlin/bg_flower.png")});
        this.mImageList = listOf;
    }

    private final void Ch() {
        TextView textView = this.mShareInfoResTv;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mShareInfoResTv");
            textView = null;
        }
        textView.setText("");
        TextView textView3 = this.mStatusResTv;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mStatusResTv");
        } else {
            textView2 = textView3;
        }
        textView2.setText("");
    }

    private final void Dh(int syncTye, String extInfo) {
        QLog.d("OnlineStatusDebugFragment", 1, "launchOpenSDK extInfo: " + extInfo);
        Intent intent = new Intent();
        intent.putExtra(IOnlineStatusService.SYNC_TYPE, syncTye);
        intent.putExtra("extInfo", extInfo);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.putExtra(SplashActivity.FRAGMENT_ID, 1);
        intent.putExtra(AppConstants.Key.SHARE_REQ_SCHEME_CONTENT, "mqqapi://open_connect/common_channel?src_type=app&app_id=12345678");
        intent.putExtra("pkg_name", "com.tencent.mobileqq");
        RouteUtils.startActivity(getContext(), intent, RouterConstants.UI_ROUTER_SPLASH);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(View view, OnlineStatusDebugFragment this$0) {
        Intrinsics.checkNotNullParameter(view, "$view");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ba baVar = new ba();
        baVar.f255571j = view.getWidth();
        this$0.mStatusPanelCtrl = new bt(view.getContext(), (FrameLayout) view.findViewById(R.id.zy4), this$0, baVar, this$0);
    }

    private final void Fh() {
        Button button = this.mSetShareInfoBtn;
        View view = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSetShareInfoBtn");
            button = null;
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: lc2.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Gh(OnlineStatusDebugFragment.this, view2);
            }
        });
        Button button2 = this.mGetShareInfoBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mGetShareInfoBtn");
            button2 = null;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: lc2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Ih(OnlineStatusDebugFragment.this, view2);
            }
        });
        Button button3 = this.mSetStatusBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSetStatusBtn");
            button3 = null;
        }
        button3.setOnClickListener(new View.OnClickListener() { // from class: lc2.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Jh(OnlineStatusDebugFragment.this, view2);
            }
        });
        Button button4 = this.mInfoTypeBtn;
        if (button4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoTypeBtn");
            button4 = null;
        }
        button4.setOnClickListener(new View.OnClickListener() { // from class: lc2.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Kh(OnlineStatusDebugFragment.this, view2);
            }
        });
        Button button5 = this.mPreSetImageBtn;
        if (button5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPreSetImageBtn");
            button5 = null;
        }
        button5.setOnClickListener(new View.OnClickListener() { // from class: lc2.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Mh(OnlineStatusDebugFragment.this, view2);
            }
        });
        Button button6 = this.mSetMusicStatusBtn;
        if (button6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSetMusicStatusBtn");
            button6 = null;
        }
        button6.setOnClickListener(new View.OnClickListener() { // from class: lc2.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Oh(OnlineStatusDebugFragment.this, view2);
            }
        });
        Button button7 = this.mSetVideoStatusBtn;
        if (button7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSetVideoStatusBtn");
            button7 = null;
        }
        button7.setOnClickListener(new View.OnClickListener() { // from class: lc2.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                OnlineStatusDebugFragment.Ph(OnlineStatusDebugFragment.this, view2);
            }
        });
        View view2 = this.mClearNewStatusCacheBtn;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mClearNewStatusCacheBtn");
        } else {
            view = view2;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: lc2.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                OnlineStatusDebugFragment.Hh(view3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(OnlineStatusDebugFragment this$0, View view) {
        AppInterface appInterface;
        BaseBusinessHandler baseBusinessHandler;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch();
        EditText editText = this$0.mInfoUrlInput;
        CustomHandler customHandler = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoUrlInput");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText2 = this$0.mInfoSubtitleInput;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoSubtitleInput");
            editText2 = null;
        }
        String obj2 = editText2.getText().toString();
        au N = af.C().N();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            baseBusinessHandler = appInterface.getBusinessHandler(CustomHandler.class.getName());
        } else {
            baseBusinessHandler = null;
        }
        if (baseBusinessHandler instanceof CustomHandler) {
            customHandler = (CustomHandler) baseBusinessHandler;
        }
        AppRuntime.Status oldStatus = N.f255494g;
        long j3 = N.f255489b;
        Intrinsics.checkNotNullExpressionValue(oldStatus, "oldStatus");
        CustomShareInfo customShareInfo = new CustomShareInfo(1, obj, obj2, oldStatus, j3);
        if (customHandler != null) {
            customHandler.L2(customShareInfo);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        NewStatusCache.f256304a.d();
        QQToast.makeText(view.getContext(), 2, "\u7f13\u5b58\u6e05\u9664\u6210\u529f", 0).show();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(OnlineStatusDebugFragment this$0, View view) {
        AppInterface appInterface;
        BusinessHandler businessHandler;
        CustomHandler customHandler;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            businessHandler = appInterface.getBusinessHandler(CustomHandler.class.getName());
        } else {
            businessHandler = null;
        }
        if (businessHandler instanceof CustomHandler) {
            customHandler = (CustomHandler) businessHandler;
        } else {
            customHandler = null;
        }
        if (customHandler != null) {
            String currentAccountUin = appInterface.getCurrentAccountUin();
            Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
            CustomHandler.J2(customHandler, currentAccountUin, null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(OnlineStatusDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Ch();
        EditText editText = this$0.mInfoUrlInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoUrlInput");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText3 = this$0.mInfoSubtitleInput;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoSubtitleInput");
        } else {
            editText2 = editText3;
        }
        String obj2 = editText2.getText().toString();
        au auVar = this$0.mOnlineStatusItem;
        if (auVar == null) {
            auVar = af.C().N();
        }
        AppRuntime.Status oldStatus = auVar.f255494g;
        long j3 = auVar.f255489b;
        Intrinsics.checkNotNullExpressionValue(oldStatus, "oldStatus");
        CustomShareInfo customShareInfo = new CustomShareInfo(1, obj, obj2, oldStatus, j3);
        IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IOnlineStatusService.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IO\u2026ava, ProcessConstant.ALL)");
        ((IOnlineStatusService) runtimeService).updateOnlineStatusUsingShareInfo(customShareInfo);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(final OnlineStatusDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ActionSheet actionSheet = null;
        Dialog createDialog = ActionSheetHelper.createDialog(this$0.getContext(), null);
        if (createDialog instanceof ActionSheet) {
            actionSheet = (ActionSheet) createDialog;
        }
        if (actionSheet != null) {
            actionSheet.addButton("\u65e0");
            actionSheet.addButton("\u56fe\u7247");
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: lc2.k
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    OnlineStatusDebugFragment.Lh(OnlineStatusDebugFragment.this, actionSheet, view2, i3);
                }
            });
            actionSheet.show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(OnlineStatusDebugFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        this$0.mShareType = i3;
        Button button = null;
        if (i3 != 0) {
            if (i3 == 1) {
                Button button2 = this$0.mInfoTypeBtn;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInfoTypeBtn");
                } else {
                    button = button2;
                }
                button.setText("\u56fe\u7247");
            }
        } else {
            Button button3 = this$0.mInfoTypeBtn;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mInfoTypeBtn");
            } else {
                button = button3;
            }
            button.setText("\u65e0");
        }
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(final OnlineStatusDebugFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final ActionSheet actionSheet = null;
        Dialog createDialog = ActionSheetHelper.createDialog(this$0.getContext(), null);
        if (createDialog instanceof ActionSheet) {
            actionSheet = (ActionSheet) createDialog;
        }
        if (actionSheet != null) {
            Iterator<com.tencent.mobileqq.onlinestatus.debug.a> it = this$0.mImageList.iterator();
            while (it.hasNext()) {
                actionSheet.addButton(it.next().getDesc());
            }
            actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: lc2.b
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view2, int i3) {
                    OnlineStatusDebugFragment.Nh(OnlineStatusDebugFragment.this, actionSheet, view2, i3);
                }
            });
            actionSheet.show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(OnlineStatusDebugFragment this$0, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        com.tencent.mobileqq.onlinestatus.debug.a aVar = this$0.mImageList.get(i3);
        EditText editText = this$0.mInfoUrlInput;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoUrlInput");
            editText = null;
        }
        editText.setText(aVar.getUrl());
        actionSheet.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(OnlineStatusDebugFragment this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mInfoUrlInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoUrlInput");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText3 = this$0.mInfoSubtitleInput;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoSubtitleInput");
        } else {
            editText2 = editText3;
        }
        String obj2 = editText2.getText().toString();
        if (this$0.mShareType != 0 && !TextUtils.isEmpty(obj)) {
            str = "{\"songId\":\"003UkWuI0E8U0l\",\"songType\":2,\"remainTime\":123600,\"pauseFlag\":false,\"duration\":256000,\"shareType\":" + this$0.mShareType + ",\"shareUrl\": \"" + obj + "\", \"shareWording\": \"" + obj2 + "\"}";
        } else {
            str = "{\"songId\":\"003UkWuI0E8U0l\",\"songType\":2,\"remainTime\":123600,\"pauseFlag\":false,\"duration\":256000}";
        }
        this$0.Dh(2, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(OnlineStatusDebugFragment this$0, View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        EditText editText = this$0.mInfoUrlInput;
        EditText editText2 = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoUrlInput");
            editText = null;
        }
        String obj = editText.getText().toString();
        EditText editText3 = this$0.mInfoSubtitleInput;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoSubtitleInput");
        } else {
            editText2 = editText3;
        }
        String obj2 = editText2.getText().toString();
        if (this$0.mShareType != 0 && !TextUtils.isEmpty(obj)) {
            str = "{\"cid\":\"mzc00200sr8rguz\",\"url\":\"preload_play\\/play\\/index?cid=mzc00200sr8rguz&source2=30102\",\"shareType\":" + this$0.mShareType + ",\"shareUrl\":\"" + obj + "\",\"shareWording\":\"" + obj2 + "\"}";
        } else {
            str = "{\"cid\":\"mzc00200sr8rguz\",\"url\":\"preload_play\\/play\\/index?cid=mzc00200sr8rguz&source2=30102\"}";
        }
        this$0.Dh(1, str);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    @NotNull
    public ArrayList<au> Qg() {
        bt btVar = this.mStatusPanelCtrl;
        if (btVar != null) {
            if (btVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mStatusPanelCtrl");
                btVar = null;
            }
            ArrayList<au> e16 = btVar.e();
            Intrinsics.checkNotNullExpressionValue(e16, "mStatusPanelCtrl.selectedItems");
            return e16;
        }
        return new ArrayList<>();
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void g2(@Nullable au oldItem, @Nullable au curItem, @Nullable View curView) {
        this.mOnlineStatusItem = curItem;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.fql;
    }

    @Override // com.tencent.mobileqq.onlinestatus.OnlineStatusPanel.a
    @NotNull
    public ArrayList<au> getDataList() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new ArrayList<>();
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        ArrayList<au> L = af.C().L(((IOnlineStatusService) runtimeService).getOnlineStatus(), af.C().M(peekAppRuntime), false);
        Intrinsics.checkNotNullExpressionValue(L, "getInstance().getOnlineS\u2026ist(status, extID, false)");
        return L;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        AppInterface appInterface;
        super.onCreate(savedInstanceState);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.addObserver(this.mOnlineStatusUpdateObserver);
        }
        if (appInterface != null) {
            appInterface.addObserver(this.mShareInfoObserver);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.mOnlineStatusUpdateObserver);
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.mShareInfoObserver);
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull final View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle("\u5728\u7ebf\u72b6\u6001\u6d4b\u8bd5");
        View findViewById = view.findViewById(R.id.f83634k3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.set_status_with_info_btn)");
        this.mSetStatusBtn = (Button) findViewById;
        View findViewById2 = view.findViewById(R.id.f83534jt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.set_info_only_btn)");
        this.mSetShareInfoBtn = (Button) findViewById2;
        View findViewById3 = view.findViewById(R.id.vns);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.get_info_only_btn)");
        this.mGetShareInfoBtn = (Button) findViewById3;
        View findViewById4 = view.findViewById(R.id.f88284wn);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.status_res_tv)");
        this.mStatusResTv = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.xnv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.info_res_tv)");
        this.mShareInfoResTv = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.f83554jv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.set_info_type_btn)");
        this.mInfoTypeBtn = (Button) findViewById6;
        View findViewById7 = view.findViewById(R.id.f83564jw);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.set_info_url_et)");
        this.mInfoUrlInput = (EditText) findViewById7;
        View findViewById8 = view.findViewById(R.id.f83544ju);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "view.findViewById(R.id.set_info_subtitle_et)");
        this.mInfoSubtitleInput = (EditText) findViewById8;
        View findViewById9 = view.findViewById(R.id.f26710e_);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "view.findViewById(R.id.pre_set_image_btn)");
        this.mPreSetImageBtn = (Button) findViewById9;
        View findViewById10 = view.findViewById(R.id.f83604k0);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "view.findViewById(R.id.set_music_status_btn)");
        this.mSetMusicStatusBtn = (Button) findViewById10;
        View findViewById11 = view.findViewById(R.id.f83674k7);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "view.findViewById(R.id.set_video_status_btn)");
        this.mSetVideoStatusBtn = (Button) findViewById11;
        View findViewById12 = view.findViewById(R.id.txq);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "view.findViewById(R.id.clear_new_status_cache_btn)");
        this.mClearNewStatusCacheBtn = findViewById12;
        view.post(new Runnable() { // from class: lc2.a
            @Override // java.lang.Runnable
            public final void run() {
                OnlineStatusDebugFragment.Eh(view, this);
            }
        });
        Fh();
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void l3(@Nullable View v3) {
    }

    @Override // com.tencent.mobileqq.onlinestatus.aw.a
    public void Q9(@Nullable au statusItem, @Nullable View v3) {
    }
}
