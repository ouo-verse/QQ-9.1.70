package id;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.reborn.debug.QZoneDebugShellFragment;
import com.qzone.reborn.debug.route.QZoneDebugRouteFragment;
import com.qzone.util.ToastUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$SecurityData;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import com.tencent.util.QQToastUtil;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b+\u0010,J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u0005H\u0002J\b\u0010%\u001a\u00020\u0005H\u0002J \u0010*\u001a\u00020)2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020&H\u0002\u00a8\u0006-"}, d2 = {"Lid/bi;", "Lid/b;", "Landroid/content/Context;", "context", "", "Lhd/b;", "a", "d", "Y", "T", "v", HippyTKDListViewAdapter.X, "Lhd/a;", "J", "k0", "Z", "B", "m0", UserInfo.SEX_FEMALE, "D", "g0", "e0", "H", "N", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "b0", "i0", "L", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "d0", "w", "P", "X", "U", "W", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "V", "", "title", QAdRewardDefine$SecurityData.DATA_KEY, "", "o0", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bi extends b {

    /* renamed from: a, reason: collision with root package name */
    public static final bi f407489a = new bi();

    bi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchFeedDetailWithData(context, "mqqapi://qzoneschema/?schema=bXF6b25lOi8vYXJvdXNlL2RldGFpbD9hcHBpZD0zMTEmdWluPTYxMDc0MDAyNiZjZWxsaWQ9M2EyNzY3MjQ2YzE1OTE2NjBlMDEwZjAwJmxvZ2luZnJvbT01Mg==", "CAAEDB0AAQC2AQE3HCYAMmaRFWxMVgBsfIYYM2EyNzY3MjQ2YzE1OTE2NjBlMDEwZjAwlgCmALzM1ig2MTA3NDAwMjZfMzExXzNhMjc2NzI0NmMxNTkxNjYwZTAxMGYwMF8w5gD8D/wQ/BH2EgD2EwD8FPYVAPwW/Bf6GAwZDAv8Gfwa/Bv8HPwd/B74Hwz8IPYhAPwi/CP8JPwl+SYM+CcM/Cj8KfYqAPwr+CwM/C38Lvwv/DD8Mfwy9jMA/DQAAR0AAQDiCgIkZyc6FiHkuIDmoJHlm5vmlrnlub/lkYrlk6Xlk6Xor6Xllp3llp0sPEYAVgBsfIycpgC8zNYA5gD8D/wQ/BH8EvwT/BT6FQwcLDYARgBcC/YWAPwX/Bj8GfoaDBwsPAv6GwwcLDwL/Bz8Hfwe/B/2IAD9IQAM+SIM9iMA9iQA+iUMHCw2AEYAXAv8Jvwn/Cj8Kfwq/Cv6LAwcLDYARgBcC/wt/C76LwYAFgAmAAv8MPoxDBwsPExaBgAcLDYAC2YAC/wy9jMA+TQM/DX8Nvw39jgA+TkM/ToADAsWACw5DAAEHQAAHwYG54aK54yrHCw5DEYAWgkMHCgMNgBGAAtoDHgMhgAABR0AAQQfCQABCgYAFgAmADgAAQALGgcAAAFQaHR0cDovL20ucXBpYy5jbi9wc2M/LzVkNjExNGI2LWYzZjYtNDdiYi1hMjFhLTdjMTA5MjhhYjE0Ny9MaXlTcHhvd0UweWVXWHdCZFhOKlNhNFNScHYqNlhkQ2dsQ0VPLllWdVZ4bDc3SkdWWkhMMWhWVGt1NFBqazdVOWVsVzY2R0Z5OGNHOHA3U2ZCMGQxbWt3Y3paSkpJaDdhTnFSQzN0bEpSSSEvYiZlaz0xJmtwPTEmcHQ9MCZibz1RQVpWQ0VBR1ZRZ1dFQ0EhJnRsPTEmdnVpbj0zNTg3NzQ1MjgyJnRtPTE3MjA3ODIwMDAmZGlzX3Q9MTcyMDc4NDI2NiZkaXNfaz05MDZlYjIyZTgzZTk5YjM2ZThkZThjOTM4MmUwYTNjZSNzY2U9MTItMTEtMSZyZj12MV9hbmRfc3FfXzBfcmRtX3ItNDIyLTEzEQZAIQhVPExcbHYAC0xcbHyIDJYArLzM3OYA9g8A9hAA+hEMHAv8EvwT/BT6FQYAFgAmADYARgBcZgAL+RYM/Bf8GPkZDPwa9hsA/Bz8HfoeBgAWACgMPEYAVgBsfIyYDKy8xgDYDOoGABYAJgA8RgBcC/wP/BD8EfYSAPYTAPwU/BX8FvwX9hgA/Bn8Gvwb+RwM/B34Hgz6HwYAFgAmADYARgBWAGYAdgCGAJYApgC4DMzWAOYA9g8A9hAA/BH2EgAL+iAMFgAmAAv6IQYAHCYANgBGAFYAaAx8jJYArLgMC/wi9iMA+SQM/CX2JgD8J/YoAPwp/Cr2KwAL/B/6IAwWAAv2IQD6IgYAFgAmADYARgBcZgAL+iMIDBYAJgA6BgAWACgMOgYAFgAmAAtGAAtKDBYAJgA2AEYAXGYAdgCMnKYAC1gMaAx2AIkMmAymALgMyAzYDOYA/A/2EAAL+iQGABYAJgA8TFYAbHYAhgCWAAv2JQD8JvYnAPwo/Cn8Kvwr+CwM+S0M9i4A+C8M+jAJDBkMC/kxDPgyDPgzDPg0DPY1APw2CxYAJgA8TFxmAHYAhgCcrLzIDNYA7PwP/BD8EfYSAPwT+hQMFgAsPEYAVgBsfIycpgC8zNYA5gD8D/wQ/BH8EvwT/BT6FQwcLDYARgBcC/YWAPwX/Bj8GfoaDBwsPAv6GwwcLDwL/Bz8Hfwe/B/2IAD9IQAM+SIM9iMA9iQA+iUMHCw2AEYAXAv8Jvwn/Cj8Kfwq/Cv6LAwcLDYARgBcC/wt/C76LwYAFgAmAAv8MPoxDBwsPExaBgAcLDYAC2YAC/wy9jMA+TQM/DX8Nvw39jgA+TkM/ToADAv2FQD8FvkXDPwY9hkA/Br2GwD8HPwd/B78H/wg/CH8Ivwj/CT8Jfwm/Cf8KPwp9ioA/Cv5LAz2LQAcJgA2AEYAXGkMfIgMnKy8");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.b B(final Context context) {
        return new hd.a("\u73af\u5883\u5207\u6362", new View.OnClickListener() { // from class: id.bc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.C(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "\u73af\u5883\u5207\u6362", "KEY_ENV_SWITCH");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a D(final Context context) {
        return new hd.a("\u7fa4\u76f8\u518c", new View.OnClickListener() { // from class: id.be
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.E(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "\u7fa4\u76f8\u518c", "KEY_GROUP_ALBUM");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a F(final Context context) {
        return new hd.a(QzoneConfig.DEFAULT_VALUE_INTIMATE_SPACE_NAME, new View.OnClickListener() { // from class: id.bb
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.G(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, QzoneConfig.DEFAULT_VALUE_INTIMATE_SPACE_NAME, "KEY_INTIMATE_SPACE");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a H(final Context context) {
        return new hd.a("\u4e3a\u4f60\u63a8\u8350", new View.OnClickListener() { // from class: id.av
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.I(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "\u4e3a\u4f60\u63a8\u8350", "KEY_LOCAL_PHOTO");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a J(Context context) {
        return new hd.a("\u6a21\u62df\u5d29\u6e83", new View.OnClickListener() { // from class: id.bd
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.K(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        throw new RuntimeException("qzone mock crash for test, please ignore");
    }

    private final hd.b L(final Context context) {
        return new hd.a("Mock\u6570\u636e\u76f8\u5173", new View.OnClickListener() { // from class: id.az
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.M(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "Mock\u6570\u636e", "KEY_MOCK_DATA");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a N(final Context context) {
        return new hd.a("NT\u6279\u91cf\u4e0a\u4f20", new View.OnClickListener() { // from class: id.at
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.O(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "NT\u6279\u91cf\u4e0a\u4f20", "KEY_NT_UPLOAD");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.b P() {
        return new hd.d("\u65b0\u7248\u8bc4\u8bba\u8f6c\u53d1\u9762\u677f", "KEY_ENABLE_USE_NEW_COMMENT_PANEL", true, null, 8, null);
    }

    private final hd.b Q() {
        return new hd.d("\u7a7a\u95f4 Feeds \u6539\u7248", "KEY_ENABLE_NEW_FEED_PRO_PAGE", com.qzone.reborn.a.e(com.qzone.reborn.a.f52169a, "exp_qzone_new_frame", null, 2, null), null, 8, null);
    }

    private final hd.b R() {
        return new hd.d("\u6d6e\u5c42\u5206\u4eab\u56fe\u7247\u65b0\u56fe\u5e93", "KEY_ENABLE_NEW_LAYER_SHARE_PIC", true, null, 8, null);
    }

    private final hd.b S() {
        return new hd.d("\u65b0\u7248\u672c\u5730\u9884\u89c8\u6d6e\u5c42", "KEY_ENABLE_NEW_LOCAL_GALLERY", true, null, 8, null);
    }

    private final hd.b T() {
        return new hd.d("\u6253\u5f00\u624bQ\u8fdb\u51fa\u573a\u52a8\u753b\u6548\u679c", "KEY_USE_QQ_OPEN_AND_CLOSE_ANIMATION", false, null, 8, null);
    }

    private final hd.b U() {
        return new hd.d("\u65b0\u7248\u7a7a\u95f4\u88ab\u52a8\u6d88\u606f", "KEY_ENABLE_NEW_PASSIVE_MESSAGE", false, null, 8, null);
    }

    private final hd.b V() {
        return new hd.d("\u53d1\u8868\u9875\u56fe\u7247GridView\u5207\u6362\u65b0\u56fe\u5e93", "KEY_ENABLE_NEW_PUBLISH_GRID_VIEW_PIC", true, null, 8, null);
    }

    private final hd.b W() {
        return new hd.d("\u65b0\u7248\u7a7a\u95f4\u88ab\u52a8\u6d88\u606f(\u65e7 UI)", "KEY_ENABLE_OLD_STYLE_PASSIVE_MESSAGE", true, null, 8, null);
    }

    private final hd.b X() {
        return new hd.d("\u65b0\u7248\u76f8\u518c\u591a\u9009\u6d6e\u5c42", "KEY_ENABLE_USE_NEW_ALBUM_SELECT_LAYER", true, null, 8, null);
    }

    private final hd.b Y() {
        return new hd.d("\u6253\u5f00\u957f\u56fe\u8001\u6d6e\u5c42", "KEY_OPEN_OLD_LONG_PIC_LAYER", false, null, 8, null);
    }

    private final hd.a Z(final Context context) {
        return new hd.a("\u6027\u80fd\u76f8\u5173", new View.OnClickListener() { // from class: id.as
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.a0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "\u6027\u80fd\u76f8\u5173", "KEY_PERFORMANCE_DEBUG");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a b0(Context context) {
        return new hd.a("\u52a0\u53f7\u6309\u94ae\u957f\u6309\u5f15\u5bfc\u6c14\u6ce1\u91cd\u7f6e", new View.OnClickListener() { // from class: id.bf
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.c0(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.qzone.reborn.util.l lVar = com.qzone.reborn.util.l.f59550a;
        lVar.b0(true);
        lVar.c0(false);
        lVar.a0(true);
        QQToastUtil.showQQToastInUiThread(0, "\u91cd\u7f6e\u6210\u529f");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.b d0(Context context) {
        return new hd.d("\u5173\u95edQQ\u89c6\u9891\u4e00\u4f53\u5316", "KEY_CLOSE_QQ_VIDEO", false, null, 8, null);
    }

    private final hd.a e0(final Context context) {
        return new hd.a("\u7a7a\u95f4\u65b0\u76f8\u518c", new View.OnClickListener() { // from class: id.bh
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.f0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "\u7a7a\u95f4\u65b0\u76f8\u518c", "KEY_QZONE_ALBUMX");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a g0(final Context context) {
        ((IQQKuiklyService) QRoute.api(IQQKuiklyService.class)).startKMPCore();
        return new hd.a("\u7a7a\u95f4Feed\u6539\u7248", new View.OnClickListener() { // from class: id.au
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.h0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.h().a(context);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a i0(final Context context) {
        return new hd.a("\u8def\u7531\u6d4b\u8bd5", new View.OnClickListener() { // from class: id.ba
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.j0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        ho.i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneDebugRouteFragment.class.getName()).request();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.a k0(final Context context) {
        return new hd.a("SuperPlayer\u8c03\u8bd5", new View.OnClickListener() { // from class: id.aw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.l0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        context.startActivity(com.qzone.common.activities.base.ak.l(context, "FRAGMENT_DEBUG_SUPER_PLAYER"));
        EventCollector.getInstance().onViewClicked(view);
    }

    private final hd.b m0(final Context context) {
        return new hd.a("\u7528\u6237\u4fe1\u606f", new View.OnClickListener() { // from class: id.bg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.n0(context, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n0(Context context, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(context, "$context");
        f407489a.o0(context, "\u7528\u6237\u4fe1\u606f", "KEY_USER_INFO");
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void o0(Context context, String title, String dataKey) {
        ho.i.d(context, "/qzone/holder_page").withString("public_fragment_class", QZoneDebugShellFragment.class.getName()).withString("KEY_DEBUG_DATA_FACTORY", dataKey).withString("KEY_TITLE", title).request();
    }

    private final hd.b v() {
        return new hd.d("\u76f8\u518c\u5f15\u5bfc\u4e0a\u4f20\u65e0\u51b7\u5374\u5468\u671f", "KEY_MOCK_PUBLISH_MOOD_BANNER", false, null, 8, null);
    }

    private final hd.b w() {
        return new hd.d("\u5f02\u6b65\u521d\u59cb\u5316\u52a0\u8f7dWebView", "KEY_ASYNC_INIT_WEB_VIEW", true, null, 8, null);
    }

    private final hd.b x() {
        return new hd.d("\u53d6\u6d88\u6c14\u6ce1\u9891\u63a7", "KEY_OPEN_QZONE_BUBBLE_TEST", false, new CompoundButton.OnCheckedChangeListener() { // from class: id.ay
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                bi.y(compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (z16) {
            ToastUtil.g(com.qzone.util.l.a(R.string.jm_), 3);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final hd.a z(final Context context) {
        return new hd.a("\u8be6\u60c5\u9875\u6d4b\u8bd5", new View.OnClickListener() { // from class: id.ax
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                bi.A(context, view);
            }
        });
    }

    @Override // id.b
    public List<hd.b> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        arrayList.add(g0(context));
        arrayList.add(e0(context));
        arrayList.add(N(context));
        arrayList.add(H(context));
        arrayList.add(D(context));
        arrayList.add(F(context));
        arrayList.add(b0(context));
        arrayList.add(i0(context));
        arrayList.add(B(context));
        arrayList.add(m0(context));
        arrayList.add(Z(context));
        arrayList.add(L(context));
        arrayList.add(J(context));
        arrayList.add(k0(context));
        arrayList.add(z(context));
        return arrayList;
    }

    @Override // id.b
    public List<hd.b> d(Context context) {
        List<hd.b> mutableListOf;
        Intrinsics.checkNotNullParameter(context, "context");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Q(), d0(context), new hd.d("\u6d6e\u5c42\u5c55\u793a\u56fe\u7247\u683c\u5f0f", "KEY_OPEN_SHOW_LAYER_PIC_TYPE", false, null, 8, null), x(), v(), Y(), T(), w(), P(), X(), W(), U(), S(), R(), V());
        return mutableListOf;
    }
}
