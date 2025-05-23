package com.tencent.state.square.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.compat.f;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.state.SquarePublicActivity;
import com.tencent.state.VasBaseSubFragment;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.service.ImageService;
import com.tencent.state.service.ResultCallback;
import com.tencent.state.service.SetStatusResult;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.service.VasMultiMotionService;
import com.tencent.state.service.VasPublishStatusService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.SquareUtil;
import com.tencent.state.square.api.IDecodeTaskCompletionListener;
import com.tencent.state.square.api.IFaceDecoder;
import com.tencent.state.square.api.p015const.LauncherConst;
import com.tencent.state.square.avatar.AvatarAnimConfig;
import com.tencent.state.square.avatar.IAvatarAnimListener;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.MapResourceType;
import com.tencent.state.square.data.OnlineStatus;
import com.tencent.state.square.data.RecordSource;
import com.tencent.state.square.data.RelationType;
import com.tencent.state.square.data.Resource;
import com.tencent.state.square.data.SquareItemKt;
import com.tencent.state.square.data.SquareMultiMotionDetailData;
import com.tencent.state.square.databinding.VasSquareErrorViewBinding;
import com.tencent.state.square.databinding.VasSquareFragmentInviteDetailBinding;
import com.tencent.state.square.detail.StatusReportHelper;
import com.tencent.state.square.media.MapPlayableSource;
import com.tencent.state.square.media.SquareMedia;
import com.tencent.state.square.record.RecordType;
import com.tencent.state.square.resource.FilamentCoverRecordHelper;
import com.tencent.state.square.resource.FilamentCoverRecorder;
import com.tencent.state.utils.RegexUtils;
import com.tencent.state.view.AvatarOnlineStatusDetailBubble;
import com.tencent.state.view.BubbleEditListener;
import com.tencent.state.view.IAvatarBubble;
import com.tencent.state.view.OnlineStatusBubbleViewHelper;
import com.tencent.state.view.SquareEndInviteDialog;
import com.tencent.state.view.SquareImageView;
import hs4.t;
import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.Charsets;
import mqq.app.Constants;
import ne0.a;
import oicq.wlogin_sdk.tools.util;
import vs4.o;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001NB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010!\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010#\u001a\u00020\u001bH\u0002J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010%\u001a\u00020\u001bH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0016J\b\u0010+\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001bH\u0002J\b\u0010/\u001a\u00020\u001bH\u0002J\b\u00100\u001a\u00020\u001bH\u0002J\u0018\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\t2\u0006\u00103\u001a\u00020\u0015H\u0002J\b\u00104\u001a\u00020\u0015H\u0016J\u0012\u00105\u001a\u00020\u001b2\b\u00106\u001a\u0004\u0018\u000107H\u0016J$\u00108\u001a\u0002072\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010?\u001a\u00020\u001bH\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J\u001a\u0010A\u001a\u00020\u001b2\u0006\u0010B\u001a\u0002072\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010C\u001a\u00020\u001bH\u0002J\b\u0010D\u001a\u00020\u001bH\u0002J\b\u0010E\u001a\u00020\u001bH\u0002J\u0014\u0010F\u001a\u00020\u001b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010H\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\tH\u0002J\b\u0010I\u001a\u00020\u001bH\u0002J\u001a\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020\t2\b\u0010L\u001a\u0004\u0018\u00010MH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006O"}, d2 = {"Lcom/tencent/state/square/detail/MultiMotionInviteFragment;", "Lcom/tencent/state/VasBaseSubFragment;", "Lcom/tencent/state/square/avatar/IAvatarAnimListener;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/state/view/BubbleEditListener;", "()V", "avatarFaceDecoder", "Lcom/tencent/state/square/api/IFaceDecoder;", MultiMotionInviteFragment.BILL_KEY, "", "binding", "Lcom/tencent/state/square/databinding/VasSquareFragmentInviteDetailBinding;", "coverRecorder", "Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "getCoverRecorder", "()Lcom/tencent/state/square/resource/FilamentCoverRecorder;", "coverRecorder$delegate", "Lkotlin/Lazy;", "data", "Lcom/tencent/state/square/data/SquareMultiMotionDetailData;", "lockService", "", "reporter", "Lcom/tencent/state/square/IReporter;", "statusService", "Lcom/tencent/state/service/VasPublishStatusService;", "acceptInvite", "", "bindAvatar", "bindAvatarBubble", "bindBackground", "bindCurrentStatus", "bindPreview", "bindSenderStatus", "bindView", "breakEdit", "checkInviteStatus", "doEditStatusBubble", "doStatusChange", "isSuccess", "endInvite", "ensureAcceptInvite", "enterEdit", "getCurTextScale", "getEditTextLength", "", "initClickListener", "initReport", "initService", "loadHeadIcon", "uin", "isTroop", "needImmersive", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onEditTextChange", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "publishStatus", "refresh", "reportImpl", "showFailToast", "text", "showInviteStatusToast", "showSuccessToast", "tryUpdateCover", "toUin", "resource", "Lcom/tencent/state/square/data/Resource;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MultiMotionInviteFragment extends VasBaseSubFragment implements IAvatarAnimListener, View.OnClickListener, BubbleEditListener {
    private static final String BILL_KEY = "billNum";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MultiMotionInviteFragment";
    private String billNum;
    private VasSquareFragmentInviteDetailBinding binding;

    /* renamed from: coverRecorder$delegate, reason: from kotlin metadata */
    private final Lazy coverRecorder;
    private SquareMultiMotionDetailData data;
    private boolean lockService;
    private IReporter reporter;
    private final IFaceDecoder avatarFaceDecoder = Square.INSTANCE.getConfig().getObtainInstanceHelper().getFaceDecoder();
    private VasPublishStatusService statusService = new VasPublishStatusService();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/tencent/state/square/detail/MultiMotionInviteFragment$Companion;", "", "()V", "BILL_KEY", "", "TAG", "newInstance", "Lcom/tencent/state/square/detail/MultiMotionInviteFragment;", MultiMotionInviteFragment.BILL_KEY, "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final MultiMotionInviteFragment newInstance(String billNum) {
            Intrinsics.checkNotNullParameter(billNum, "billNum");
            MultiMotionInviteFragment multiMotionInviteFragment = new MultiMotionInviteFragment();
            multiMotionInviteFragment.billNum = billNum;
            return multiMotionInviteFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MultiMotionInviteFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<FilamentCoverRecorder>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$coverRecorder$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final FilamentCoverRecorder invoke() {
                return new FilamentCoverRecorder();
            }
        });
        this.coverRecorder = lazy;
    }

    private final void acceptInvite() {
        o receiver;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            if (!this.lockService) {
                SquareLogger squareLog = SquareBaseKt.getSquareLog();
                StringBuilder sb5 = new StringBuilder();
                SquareMultiMotionDetailData squareMultiMotionDetailData = this.data;
                sb5.append((squareMultiMotionDetailData == null || (receiver = squareMultiMotionDetailData.getReceiver()) == null) ? null : Long.valueOf(receiver.f443328a));
                sb5.append(" accept invite");
                squareLog.i(TAG, sb5.toString());
                this.lockService = true;
                String textString = vasSquareFragmentInviteDetailBinding.avatarBubble.getTextString();
                if (textString == null) {
                    textString = "";
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(SquareReportConst.Key.KEY_IS_SET_CUSTOMIZE_TEXT, Integer.valueOf(textString.length() <= 0 ? 0 : 1));
                IReporter iReporter = this.reporter;
                if (iReporter != null) {
                    TextView textView = vasSquareFragmentInviteDetailBinding.accept;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.accept");
                    iReporter.reportEvent("clck", textView, linkedHashMap);
                }
                if (this.data != null) {
                    publishStatus();
                    return;
                }
                return;
            }
            showFailToast(getResources().getString(R.string.xcv));
        }
    }

    private final void bindAvatar(SquareMultiMotionDetailData data) {
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            vasSquareFragmentInviteDetailBinding.avatar.setConfig(new AvatarAnimConfig(true, SquareMedia.INSTANCE.getCommonPlayerPool(), null, false, 12, null));
            vasSquareFragmentInviteDetailBinding.avatar.setLoopPlay(true);
            MapPlayableSource mapPlayableSource$default = SquareItemKt.toMapPlayableSource$default(data.getResource(), MapResourceType.Filament, String.valueOf(data.getSender().f443328a), null, 4, null);
            vasSquareFragmentInviteDetailBinding.avatar.setStaticSource(mapPlayableSource$default, true);
            vasSquareFragmentInviteDetailBinding.avatar.setAnimSource(mapPlayableSource$default, this, false);
            tryUpdateCover(String.valueOf(data.getSender().f443328a), data.getResource());
        }
    }

    private final void bindAvatarBubble(SquareMultiMotionDetailData data) {
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            t tVar = data.getSender().f443331d;
            Intrinsics.checkNotNullExpressionValue(tVar, "data.sender.statusInfo");
            OnlineStatus formatOnlineStatus = UserFormatKt.formatOnlineStatus(tVar);
            formatOnlineStatus.setCustomText("");
            IAvatarBubble.DefaultImpls.setData$default(vasSquareFragmentInviteDetailBinding.avatarBubble, String.valueOf(data.getSender().f443328a), formatOnlineStatus, null, null, RelationType.SELF, false, false, null, 192, null);
            vasSquareFragmentInviteDetailBinding.avatarBubble.setEditListener(this);
            AvatarOnlineStatusDetailBubble.showEditedView$default(vasSquareFragmentInviteDetailBinding.avatarBubble, null, true, 1, null);
        }
    }

    private final void bindBackground(final SquareMultiMotionDetailData data) {
        SquareImageView squareImageView;
        if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, data.getBackgroundUrl(), false, 2, null)) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "bindBackground " + data.getBackgroundUrl() + " is null", null, 4, null);
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(data.getBackgroundUrl(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
        drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$bindBackground$$inlined$apply$lambda$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable p06, Throwable p16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "onLoadFailed " + data.getBackgroundUrl(), null, 4, null);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable drawable2) {
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding;
                SquareImageView squareImageView2;
                vasSquareFragmentInviteDetailBinding = MultiMotionInviteFragment.this.binding;
                if (vasSquareFragmentInviteDetailBinding == null || (squareImageView2 = vasSquareFragmentInviteDetailBinding.background) == null) {
                    return;
                }
                squareImageView2.setImageDrawable(drawable2);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable p06) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable p06, int p16) {
            }
        });
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding == null || (squareImageView = vasSquareFragmentInviteDetailBinding.background) == null) {
            return;
        }
        squareImageView.setImageDrawable(drawable);
    }

    private final void bindCurrentStatus(SquareMultiMotionDetailData data) {
        TextView textView;
        byte[] bArr = data.getSender().f443329b;
        Intrinsics.checkNotNullExpressionValue(bArr, "data.sender.nick");
        String str = new String(bArr, Charsets.UTF_8);
        if (str.length() > 8) {
            StringBuilder sb5 = new StringBuilder();
            String substring = str.substring(0, 8);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            sb5.append(substring);
            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
            str = sb5.toString();
        }
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding == null || (textView = vasSquareFragmentInviteDetailBinding.tipsText) == null) {
            return;
        }
        textView.setText(getResources().getString(R.string.f169744xd0, str, data.getSender().f443331d.f406211c));
    }

    private final void bindPreview(final SquareMultiMotionDetailData data) {
        SquareImageView squareImageView;
        if (!RegexUtils.isValidUrl$default(RegexUtils.INSTANCE, data.getPreviewUrl(), false, 2, null)) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "bindPreview " + data.getPreviewUrl() + " is null", null, 4, null);
            return;
        }
        URLDrawable drawable = URLDrawable.getDrawable(data.getPreviewUrl(), SquareUtil.getUrlDrawableOptions$default(SquareUtil.INSTANCE, null, null, 3, null));
        drawable.setURLDrawableListener(new URLDrawable.URLDrawableListener() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$bindPreview$$inlined$apply$lambda$1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable p06, Throwable p16) {
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "onLoadFailed " + data.getPreviewUrl(), null, 4, null);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable drawable2) {
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding;
                SquareImageView squareImageView2;
                vasSquareFragmentInviteDetailBinding = MultiMotionInviteFragment.this.binding;
                if (vasSquareFragmentInviteDetailBinding == null || (squareImageView2 = vasSquareFragmentInviteDetailBinding.previewImage) == null) {
                    return;
                }
                squareImageView2.setImageDrawable(drawable2);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable p06) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable p06, int p16) {
            }
        });
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding == null || (squareImageView = vasSquareFragmentInviteDetailBinding.previewImage) == null) {
            return;
        }
        squareImageView.setImageDrawable(drawable);
    }

    private final void bindSenderStatus(SquareMultiMotionDetailData data) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        TextView textView;
        byte[] bArr = data.getSender().f443331d.f406215g;
        Intrinsics.checkNotNullExpressionValue(bArr, "data.sender.statusInfo.customText");
        Charset charset = Charsets.UTF_8;
        String str = new String(bArr, charset);
        if (str.length() > 0) {
            String valueOf = String.valueOf(data.getSender().f443328a);
            byte[] bArr2 = data.getSender().f443329b;
            Intrinsics.checkNotNullExpressionValue(bArr2, "data.sender.nick");
            String str2 = new String(bArr2, charset);
            if (str2.length() > 8) {
                StringBuilder sb5 = new StringBuilder();
                String substring = str2.substring(0, 8);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                sb5.append(substring);
                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                str2 = sb5.toString();
            }
            String str3 = str2 + ':' + str;
            loadHeadIcon(valueOf, false);
            VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
            if (vasSquareFragmentInviteDetailBinding != null && (textView = vasSquareFragmentInviteDetailBinding.senderStatus) != null) {
                textView.setText(str3);
            }
            VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding2 = this.binding;
            if (vasSquareFragmentInviteDetailBinding2 == null || (linearLayout2 = vasSquareFragmentInviteDetailBinding2.statusContainer) == null) {
                return;
            }
            linearLayout2.setVisibility(0);
            return;
        }
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding3 = this.binding;
        if (vasSquareFragmentInviteDetailBinding3 == null || (linearLayout = vasSquareFragmentInviteDetailBinding3.statusContainer) == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bindView(SquareMultiMotionDetailData data) {
        int coerceAtLeast;
        RelativeLayout relativeLayout;
        bindBackground(data);
        bindPreview(data);
        bindAvatar(data);
        bindCurrentStatus(data);
        bindSenderStatus(data);
        bindAvatarBubble(data);
        checkInviteStatus(data);
        Context it = getContext();
        if (it != null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            SquareUtil squareUtil = SquareUtil.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(squareUtil.getStatusBarHeight(it), ViewExtensionsKt.dip((Fragment) this, 25.0f));
            layoutParams.topMargin = coerceAtLeast;
            VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
            if (vasSquareFragmentInviteDetailBinding == null || (relativeLayout = vasSquareFragmentInviteDetailBinding.titleContainer) == null) {
                return;
            }
            relativeLayout.setLayoutParams(layoutParams);
        }
    }

    private final void breakEdit() {
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            vasSquareFragmentInviteDetailBinding.avatarBubble.clearFocus();
            Context context = getContext();
            Object systemService = context != null ? context.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
            InputMethodManager inputMethodManager = (InputMethodManager) (systemService instanceof InputMethodManager ? systemService : null);
            if (inputMethodManager != null) {
                ScrollView mContainer = vasSquareFragmentInviteDetailBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
                inputMethodManager.hideSoftInputFromWindow(mContainer.getWindowToken(), 0);
            }
            View view = vasSquareFragmentInviteDetailBinding.darkView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.darkView");
            view.setVisibility(8);
            LinearLayout linearLayout = vasSquareFragmentInviteDetailBinding.customTextTitleGroup;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customTextTitleGroup");
            linearLayout.setVisibility(8);
            Button button = vasSquareFragmentInviteDetailBinding.textEditComplete;
            Intrinsics.checkNotNullExpressionValue(button, "binding.textEditComplete");
            button.setVisibility(8);
            vasSquareFragmentInviteDetailBinding.avatarBubble.showChangeStatusView();
        }
    }

    private final void checkInviteStatus(SquareMultiMotionDetailData data) {
        if (data.getReceiver().f443330c == 0 && data.getSender().f443330c == 1) {
            return;
        }
        if (data.getSender().f443330c != 1) {
            String string = getResources().getString(R.string.xcw);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026uare_invite_expire_toast)");
            showInviteStatusToast(string);
        } else {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                SquarePublicActivity.Launcher.start$default(activity, 0, (Bundle) null, (Integer) null, 14, (Object) null);
                activity.onBackPressed();
            }
        }
    }

    private final void doEditStatusBubble() {
        int i3;
        OnlineStatus statusInfo;
        String customText;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            View view = vasSquareFragmentInviteDetailBinding.darkView;
            Intrinsics.checkNotNullExpressionValue(view, "binding.darkView");
            view.setVisibility(0);
            LinearLayout linearLayout = vasSquareFragmentInviteDetailBinding.customTextTitleGroup;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "binding.customTextTitleGroup");
            linearLayout.setVisibility(0);
            SquareImageView squareImageView = vasSquareFragmentInviteDetailBinding.editCustomClearIcon;
            Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.editCustomClearIcon");
            SquareMultiMotionDetailData squareMultiMotionDetailData = this.data;
            if (squareMultiMotionDetailData != null && (statusInfo = squareMultiMotionDetailData.getStatusInfo()) != null && (customText = statusInfo.getCustomText()) != null) {
                if (customText.length() == 0) {
                    i3 = 8;
                    squareImageView.setVisibility(i3);
                    TextView textView = vasSquareFragmentInviteDetailBinding.editCustomTextNum;
                    Intrinsics.checkNotNullExpressionValue(textView, "binding.editCustomTextNum");
                    textView.setText(getCurTextScale());
                    Button button = vasSquareFragmentInviteDetailBinding.textEditComplete;
                    Intrinsics.checkNotNullExpressionValue(button, "binding.textEditComplete");
                    button.setVisibility(0);
                    AvatarOnlineStatusDetailBubble.showEditedView$default(vasSquareFragmentInviteDetailBinding.avatarBubble, null, false, 3, null);
                }
            }
            i3 = 0;
            squareImageView.setVisibility(i3);
            TextView textView2 = vasSquareFragmentInviteDetailBinding.editCustomTextNum;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.editCustomTextNum");
            textView2.setText(getCurTextScale());
            Button button2 = vasSquareFragmentInviteDetailBinding.textEditComplete;
            Intrinsics.checkNotNullExpressionValue(button2, "binding.textEditComplete");
            button2.setVisibility(0);
            AvatarOnlineStatusDetailBubble.showEditedView$default(vasSquareFragmentInviteDetailBinding.avatarBubble, null, false, 3, null);
        }
    }

    private final void endInvite() {
        Map<String, Object> mutableMapOf;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            if (!this.lockService) {
                IReporter iReporter = this.reporter;
                if (iReporter != null) {
                    SquareImageView squareImageView = vasSquareFragmentInviteDetailBinding.end;
                    Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.end");
                    iReporter.reportEvent("clck", squareImageView, new LinkedHashMap());
                }
                Context it = getContext();
                if (it != null) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    SquareEndInviteDialog squareEndInviteDialog = new SquareEndInviteDialog(it, false, 0, 0, 0, null, null, 126, null);
                    squareEndInviteDialog.setPositiveCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$endInvite$$inlined$let$lambda$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            IReporter iReporter2;
                            SquareMultiMotionDetailData squareMultiMotionDetailData;
                            String str;
                            Map<String, Object> mutableMapOf2;
                            int i3 = z16 ? 2 : 1;
                            iReporter2 = MultiMotionInviteFragment.this.reporter;
                            if (iReporter2 != null) {
                                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 1), TuplesKt.to(SquareReportConst.Key.KEY_END_THREE_DAY_BLACK_LIST, Integer.valueOf(z16 ? 1 : 0)));
                                iReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_SQUARE_END_POP_WINDOW, mutableMapOf2);
                            }
                            VasMultiMotionService vasMultiMotionService = VasMultiMotionService.INSTANCE;
                            squareMultiMotionDetailData = MultiMotionInviteFragment.this.data;
                            if (squareMultiMotionDetailData == null || (str = squareMultiMotionDetailData.getBillNum()) == null) {
                                str = "";
                            }
                            vasMultiMotionService.endInvite(str, i3, new ResultCallback<Resource>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$endInvite$$inlined$let$lambda$1.1
                                @Override // com.tencent.state.service.ResultCallback
                                public void onResultFailure(int i16, String str2) {
                                    ResultCallback.DefaultImpls.onResultFailure(this, i16, str2);
                                }

                                @Override // com.tencent.state.service.ResultCallback
                                public void onResultFailure(int i16, String str2, String str3) {
                                    ResultCallback.DefaultImpls.onResultFailure(this, i16, str2, str3);
                                }

                                @Override // com.tencent.state.service.ResultCallback
                                public void onResultSuccess(Resource result) {
                                    SquareMultiMotionDetailData squareMultiMotionDetailData2;
                                    IReporter iReporter3;
                                    o sender;
                                    try {
                                        Bundle bundle = new Bundle();
                                        squareMultiMotionDetailData2 = MultiMotionInviteFragment.this.data;
                                        bundle.putString(LauncherConst.KEY_LOCATE_TO_UIN, String.valueOf((squareMultiMotionDetailData2 == null || (sender = squareMultiMotionDetailData2.getSender()) == null) ? null : Long.valueOf(sender.f443328a)));
                                        Context context = MultiMotionInviteFragment.this.getContext();
                                        if (context != null) {
                                            SquarePublicActivity.Launcher.start$default(context, 0, bundle, (Integer) null, 10, (Object) null);
                                            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                                            Intrinsics.checkNotNullExpressionValue(context, "context");
                                            commonUtils.showToast(context, "\u5df2\u7ed3\u675f\u5bf9\u65b9\u7684\u53cc\u4eba\u72b6\u6001", 2);
                                        }
                                        FragmentActivity activity = MultiMotionInviteFragment.this.getActivity();
                                        if (activity != null) {
                                            activity.onBackPressed();
                                        }
                                        iReporter3 = MultiMotionInviteFragment.this.reporter;
                                        if (iReporter3 != null) {
                                            iReporter3.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_DOUBLE_POSE_END_TIPS, new LinkedHashMap());
                                        }
                                    } catch (Throwable th5) {
                                        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "ensureAcceptInvite:" + th5.getMessage(), null, 4, null);
                                    }
                                }
                            });
                        }
                    });
                    squareEndInviteDialog.setNegativeCallback(new Function1<Boolean, Unit>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$endInvite$$inlined$let$lambda$2
                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16) {
                            IReporter iReporter2;
                            Map<String, Object> mutableMapOf2;
                            iReporter2 = MultiMotionInviteFragment.this.reporter;
                            if (iReporter2 != null) {
                                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 0));
                                iReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_SQUARE_END_POP_WINDOW, mutableMapOf2);
                            }
                        }
                    });
                    squareEndInviteDialog.show();
                    IReporter iReporter2 = this.reporter;
                    if (iReporter2 != null) {
                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
                        iReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_SQUARE_ADD_FRIEND_GUIDE, mutableMapOf);
                        return;
                    }
                    return;
                }
                return;
            }
            showFailToast(getResources().getString(R.string.xcv));
        }
    }

    private final void ensureAcceptInvite() {
        String str;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble;
        String str2 = this.billNum;
        if (str2 == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "publishStatus FAIL billNum is null", null, 4, null);
            showFailToast$default(this, null, 1, null);
            this.lockService = false;
        } else if (str2 != null) {
            VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
            if (vasSquareFragmentInviteDetailBinding == null || (avatarOnlineStatusDetailBubble = vasSquareFragmentInviteDetailBinding.avatarBubble) == null || (str = avatarOnlineStatusDetailBubble.getTextString()) == null) {
                str = "";
            }
            VasMultiMotionService.INSTANCE.acceptInvite(str2, str, new ResultCallback<Boolean>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$ensureAcceptInvite$$inlined$let$lambda$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str3) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str3);
                }

                @Override // com.tencent.state.service.ResultCallback
                public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
                    onResultSuccess(bool.booleanValue());
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message, String prompt) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "ensureAcceptInvite fail " + error + ", " + message + ", " + prompt, null, 4, null);
                    MultiMotionInviteFragment.this.lockService = false;
                    MultiMotionInviteFragment.this.showFailToast(prompt);
                }

                public void onResultSuccess(boolean result) {
                    SquareBaseKt.getSquareLog().i("MultiMotionInviteFragment", "publishStatus success");
                    MultiMotionInviteFragment.this.lockService = false;
                    MultiMotionInviteFragment.this.showSuccessToast();
                    Context context = MultiMotionInviteFragment.this.getContext();
                    if (context != null) {
                        SquarePublicActivity.Launcher.start$default(context, 0, (Bundle) null, (Integer) null, 14, (Object) null);
                    }
                    FragmentActivity activity = MultiMotionInviteFragment.this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            });
        }
    }

    private final FilamentCoverRecorder getCoverRecorder() {
        return (FilamentCoverRecorder) this.coverRecorder.getValue();
    }

    private final String getCurTextScale() {
        int editTextLength = getEditTextLength();
        if (editTextLength > 32) {
            String string = getResources().getString(R.string.xe7);
            Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026social_edit_max_num_tips)");
            return string;
        }
        return editTextLength + "/32";
    }

    private final int getEditTextLength() {
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble;
        OnlineStatusBubbleViewHelper onlineStatusBubbleViewHelper = OnlineStatusBubbleViewHelper.INSTANCE;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        return onlineStatusBubbleViewHelper.getEditTextLength((vasSquareFragmentInviteDetailBinding == null || (avatarOnlineStatusDetailBubble = vasSquareFragmentInviteDetailBinding.avatarBubble) == null) ? null : avatarOnlineStatusDetailBubble.getTextString());
    }

    private final void initClickListener() {
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            vasSquareFragmentInviteDetailBinding.accept.setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.end.setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.back.setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.jumpBtn.setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.darkView.setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.editCustomClearIcon.setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.textEditComplete.setOnClickListener(this);
            VasSquareErrorViewBinding vasSquareErrorViewBinding = vasSquareFragmentInviteDetailBinding.requestErrorBackground;
            Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding, "binding.requestErrorBackground");
            vasSquareErrorViewBinding.getMContainer().setOnClickListener(this);
            vasSquareFragmentInviteDetailBinding.previewContainer.setOnClickListener(this);
        }
    }

    private final void initService() {
        this.statusService.init();
    }

    private final void loadHeadIcon(String uin, boolean isTroop) {
        SquareImageView squareImageView;
        Bitmap bitmapFromCache = this.avatarFaceDecoder.getBitmapFromCache(uin, isTroop);
        if (bitmapFromCache != null && !bitmapFromCache.isRecycled()) {
            VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
            if (vasSquareFragmentInviteDetailBinding == null || (squareImageView = vasSquareFragmentInviteDetailBinding.senderIcon) == null) {
                return;
            }
            squareImageView.setImageBitmap(bitmapFromCache);
            return;
        }
        this.avatarFaceDecoder.setDecodeTaskCompletionListener(new IDecodeTaskCompletionListener() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$loadHeadIcon$1
            /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
            
                r1 = r0.this$0.binding;
             */
            @Override // com.tencent.state.square.api.IDecodeTaskCompletionListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onDecodeTaskCompleted(int remainingTasks, int type, String uin2, Bitmap avatar) {
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding2;
                SquareImageView squareImageView2;
                if (avatar == null || vasSquareFragmentInviteDetailBinding2 == null || (squareImageView2 = vasSquareFragmentInviteDetailBinding2.senderIcon) == null) {
                    return;
                }
                squareImageView2.setImageBitmap(avatar);
            }
        });
        this.avatarFaceDecoder.requestDecodeFace(uin, isTroop);
    }

    private final void publishStatus() {
        String str;
        AvatarOnlineStatusDetailBubble avatarOnlineStatusDetailBubble;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding == null || (avatarOnlineStatusDetailBubble = vasSquareFragmentInviteDetailBinding.avatarBubble) == null || (str = avatarOnlineStatusDetailBubble.getTextString()) == null) {
            str = "";
        }
        final String str2 = str;
        SquareMultiMotionDetailData squareMultiMotionDetailData = this.data;
        if (squareMultiMotionDetailData != null) {
            VasPublishStatusService vasPublishStatusService = this.statusService;
            t tVar = squareMultiMotionDetailData.getSender().f443331d;
            Intrinsics.checkNotNullExpressionValue(tVar, "it.sender.statusInfo");
            vasPublishStatusService.requestSetStatus(UserFormatKt.formatOnlineStatus(tVar), squareMultiMotionDetailData.getResource().getActionId(), str2, new AvatarLocationInfo(0.0d, 0.0d, null, null, null, 31, null), new Function1<SetStatusResult, Unit>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$publishStatus$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SetStatusResult setStatusResult) {
                    invoke2(setStatusResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SetStatusResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    MultiMotionInviteFragment.this.doStatusChange(result.isSetStatusSuccess());
                }
            });
        }
    }

    private final void refresh() {
        final VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            ScrollView mContainer = vasSquareFragmentInviteDetailBinding.getMContainer();
            Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
            mContainer.setVisibility(8);
            VasMultiMotionService.getInviteDetail$default(VasMultiMotionService.INSTANCE, null, this.billNum, new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$refresh$1
                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int i3, String str, String str2) {
                    ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultFailure(int error, String message) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "getInviteDetail error" + error + ", message:" + message, null, 4, null);
                    VasSquareErrorViewBinding vasSquareErrorViewBinding = vasSquareFragmentInviteDetailBinding.requestErrorBackground;
                    Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding, "binding.requestErrorBackground");
                    RelativeLayout mContainer2 = vasSquareErrorViewBinding.getMContainer();
                    Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.requestErrorBackground.root");
                    mContainer2.setVisibility(0);
                    ScrollView mContainer3 = vasSquareFragmentInviteDetailBinding.getMContainer();
                    Intrinsics.checkNotNullExpressionValue(mContainer3, "binding.root");
                    mContainer3.setVisibility(0);
                }

                @Override // com.tencent.state.service.ResultCallback
                public void onResultSuccess(SquareMultiMotionDetailData result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    VasSquareErrorViewBinding vasSquareErrorViewBinding = vasSquareFragmentInviteDetailBinding.requestErrorBackground;
                    Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding, "binding.requestErrorBackground");
                    RelativeLayout mContainer2 = vasSquareErrorViewBinding.getMContainer();
                    Intrinsics.checkNotNullExpressionValue(mContainer2, "binding.requestErrorBackground.root");
                    mContainer2.setVisibility(8);
                    ScrollView mContainer3 = vasSquareFragmentInviteDetailBinding.getMContainer();
                    Intrinsics.checkNotNullExpressionValue(mContainer3, "binding.root");
                    mContainer3.setVisibility(0);
                    MultiMotionInviteFragment.this.data = result;
                    MultiMotionInviteFragment.this.bindView(result);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportImpl() {
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_IS_SET_CUSTOMIZE_TEXT, 0);
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                TextView textView = vasSquareFragmentInviteDetailBinding.accept;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.accept");
                iReporter.reportEvent("imp", textView, linkedHashMap);
            }
            IReporter iReporter2 = this.reporter;
            if (iReporter2 != null) {
                SquareImageView squareImageView = vasSquareFragmentInviteDetailBinding.end;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.end");
                iReporter2.reportEvent("imp", squareImageView, new LinkedHashMap());
            }
            IReporter iReporter3 = this.reporter;
            if (iReporter3 != null) {
                RelativeLayout relativeLayout = vasSquareFragmentInviteDetailBinding.previewContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.previewContainer");
                iReporter3.reportEvent("imp", relativeLayout, new LinkedHashMap());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showFailToast(String text) {
        Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (text == null) {
                text = getResources().getString(R.string.xd6);
                Intrinsics.checkNotNullExpressionValue(text, "resources.getString(R.st\u2026quare_toast_publish_fail)");
            }
            commonUtils.showToast(it, text, 1);
        }
    }

    private final void showInviteStatusToast(final String text) {
        final Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            commonUtils.showDialog(it, text, "\u6211\u77e5\u9053\u4e86", (String) null, false, new Function0<Unit>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$showInviteStatusToast$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SquarePublicActivity.Launcher.start$default(it, 0, (Bundle) null, (Integer) null, 14, (Object) null);
                    FragmentActivity activity = this.getActivity();
                    if (activity != null) {
                        activity.onBackPressed();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showSuccessToast() {
        Context it = getContext();
        if (it != null) {
            ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            commonUtils.showToast(it, getResources().getString(R.string.xd7), 2);
        }
    }

    @Override // com.tencent.state.view.BubbleEditListener
    public void enterEdit() {
        doEditStatusBubble();
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, Class cls) {
        return a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        String str;
        o sender;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding == null || v3 == null) {
            return;
        }
        int id5 = v3.getId();
        if (id5 == R.id.p9r) {
            acceptInvite();
            return;
        }
        if (id5 == R.id.pcx) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.onBackPressed();
                return;
            }
            return;
        }
        if (id5 == R.id.prx) {
            endInvite();
            return;
        }
        if (id5 != R.id.qdl && id5 != R.id.q4c) {
            if (id5 == R.id.poc || id5 == R.id.qqg) {
                breakEdit();
                return;
            }
            if (id5 == R.id.f163368pr2) {
                vasSquareFragmentInviteDetailBinding.avatarBubble.clearText();
                return;
            }
            if (id5 == R.id.qh9) {
                VasSquareErrorViewBinding vasSquareErrorViewBinding = vasSquareFragmentInviteDetailBinding.requestErrorBackground;
                Intrinsics.checkNotNullExpressionValue(vasSquareErrorViewBinding, "binding.requestErrorBackground");
                RelativeLayout mContainer = vasSquareErrorViewBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "binding.requestErrorBackground.root");
                mContainer.setVisibility(8);
                refresh();
                return;
            }
            return;
        }
        IReporter iReporter = this.reporter;
        if (iReporter != null) {
            RelativeLayout relativeLayout = vasSquareFragmentInviteDetailBinding.previewContainer;
            Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.previewContainer");
            iReporter.reportEvent("clck", relativeLayout, new LinkedHashMap());
        }
        vasSquareFragmentInviteDetailBinding.avatarBubble.clearFocus();
        Bundle bundle = new Bundle();
        SquareMultiMotionDetailData squareMultiMotionDetailData = this.data;
        if (squareMultiMotionDetailData == null || (sender = squareMultiMotionDetailData.getSender()) == null || (str = String.valueOf(sender.f443328a)) == null) {
            str = "";
        }
        bundle.putString(LauncherConst.KEY_LOCATE_TO_UIN, str);
        Context context = getContext();
        if (context != null) {
            SquarePublicActivity.Launcher.start$default(context, 0, bundle, (Integer) null, 10, (Object) null);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        VasSquareFragmentInviteDetailBinding inflate = VasSquareFragmentInviteDetailBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        Intrinsics.checkNotNullExpressionValue(inflate, "VasSquareFragmentInviteD\u2026 binding = this\n        }");
        ScrollView mContainer = inflate.getMContainer();
        Intrinsics.checkNotNullExpressionValue(mContainer, "VasSquareFragmentInviteD\u2026ing = this\n        }.root");
        return mContainer;
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.statusService.destroy();
        FilamentCoverRecorder coverRecorder = getCoverRecorder();
        if (coverRecorder != null) {
            coverRecorder.onDestroy();
        }
    }

    @Override // com.tencent.state.view.BubbleEditListener
    public void onEditTextChange() {
        SquareImageView squareImageView;
        TextView textView;
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null && (textView = vasSquareFragmentInviteDetailBinding.editCustomTextNum) != null) {
            textView.setText(getCurTextScale());
        }
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding2 = this.binding;
        if (vasSquareFragmentInviteDetailBinding2 == null || (squareImageView = vasSquareFragmentInviteDetailBinding2.editCustomClearIcon) == null) {
            return;
        }
        squareImageView.setVisibility(getEditTextLength() > 0 ? 0 : 8);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onFirstFrame() {
        IAvatarAnimListener.DefaultImpls.onFirstFrame(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        a.e(this, str, str2, j3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayEnd() {
        IAvatarAnimListener.DefaultImpls.onPlayEnd(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayError(int i3) {
        IAvatarAnimListener.DefaultImpls.onPlayError(this, i3);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onPlayStart() {
        IAvatarAnimListener.DefaultImpls.onPlayStart(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onRemovedListener() {
        IAvatarAnimListener.DefaultImpls.onRemovedListener(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticFailed() {
        IAvatarAnimListener.DefaultImpls.onStaticFailed(this);
    }

    @Override // com.tencent.state.square.avatar.IAvatarAnimListener
    public void onStaticSuccess() {
        IAvatarAnimListener.DefaultImpls.onStaticSuccess(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        f.m(this);
    }

    @Override // com.tencent.state.VasBaseLifecycleFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        VasSquareErrorViewBinding vasSquareErrorViewBinding;
        RelativeLayout mContainer;
        ScrollView mContainer2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ImageService.Companion companion = ImageService.INSTANCE;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        companion.initImageLoader(context);
        initClickListener();
        initService();
        this.reporter = SquareBase.INSTANCE.getConfig().getReporter();
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null && (mContainer2 = vasSquareFragmentInviteDetailBinding.getMContainer()) != null) {
            mContainer2.setVisibility(8);
        }
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding2 = this.binding;
        if (vasSquareFragmentInviteDetailBinding2 != null && (vasSquareErrorViewBinding = vasSquareFragmentInviteDetailBinding2.requestErrorBackground) != null && (mContainer = vasSquareErrorViewBinding.getMContainer()) != null) {
            mContainer.setBackgroundColor(-1);
        }
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(BILL_KEY)) == null) {
            str = "";
        }
        this.billNum = str;
        initReport();
        VasMultiMotionService.getInviteDetail$default(VasMultiMotionService.INSTANCE, null, this.billNum, new ResultCallback<SquareMultiMotionDetailData>() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$onViewCreated$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str2, String str3) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str2, str3);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding3;
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding4;
                VasSquareErrorViewBinding vasSquareErrorViewBinding2;
                RelativeLayout mContainer3;
                ScrollView mContainer4;
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "getInviteDetail error" + error + ", message:" + message, null, 4, null);
                vasSquareFragmentInviteDetailBinding3 = MultiMotionInviteFragment.this.binding;
                if (vasSquareFragmentInviteDetailBinding3 != null && (mContainer4 = vasSquareFragmentInviteDetailBinding3.getMContainer()) != null) {
                    mContainer4.setVisibility(0);
                }
                vasSquareFragmentInviteDetailBinding4 = MultiMotionInviteFragment.this.binding;
                if (vasSquareFragmentInviteDetailBinding4 == null || (vasSquareErrorViewBinding2 = vasSquareFragmentInviteDetailBinding4.requestErrorBackground) == null || (mContainer3 = vasSquareErrorViewBinding2.getMContainer()) == null) {
                    return;
                }
                mContainer3.setVisibility(0);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(SquareMultiMotionDetailData result) {
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding3;
                VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding4;
                ScrollView mContainer3;
                VasSquareErrorViewBinding vasSquareErrorViewBinding2;
                RelativeLayout mContainer4;
                Intrinsics.checkNotNullParameter(result, "result");
                vasSquareFragmentInviteDetailBinding3 = MultiMotionInviteFragment.this.binding;
                if (vasSquareFragmentInviteDetailBinding3 != null && (vasSquareErrorViewBinding2 = vasSquareFragmentInviteDetailBinding3.requestErrorBackground) != null && (mContainer4 = vasSquareErrorViewBinding2.getMContainer()) != null) {
                    mContainer4.setVisibility(8);
                }
                vasSquareFragmentInviteDetailBinding4 = MultiMotionInviteFragment.this.binding;
                if (vasSquareFragmentInviteDetailBinding4 != null && (mContainer3 = vasSquareFragmentInviteDetailBinding4.getMContainer()) != null) {
                    mContainer3.setVisibility(0);
                }
                MultiMotionInviteFragment.this.data = result;
                MultiMotionInviteFragment.this.bindView(result);
                MultiMotionInviteFragment.this.reportImpl();
            }
        }, 1, null);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return a.f(this);
    }

    @Override // com.tencent.state.VasBaseSubFragment, com.tencent.state.VasBaseFragment, com.tencent.state.VasBaseLifecycleFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, Class cls) {
        return a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doStatusChange(boolean isSuccess) {
        if (isSuccess) {
            ensureAcceptInvite();
            StatusReportHelper.INSTANCE.reportPublishSuccess(StatusReportHelper.PublishScene.INVITE);
        } else {
            this.lockService = false;
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "publishStatus FAIL updateOnlineStatus", null, 4, null);
            showFailToast$default(this, null, 1, null);
        }
    }

    private final void initReport() {
        VasSquareFragmentInviteDetailBinding vasSquareFragmentInviteDetailBinding = this.binding;
        if (vasSquareFragmentInviteDetailBinding != null) {
            IReporter iReporter = this.reporter;
            if (iReporter != null) {
                ScrollView mContainer = vasSquareFragmentInviteDetailBinding.getMContainer();
                Intrinsics.checkNotNullExpressionValue(mContainer, "binding.root");
                iReporter.setPageInfo(this, mContainer, SquareReportConst.PageId.PAGE_ID_PEOPLE_ACCEPT, new LinkedHashMap());
            }
            IReporter iReporter2 = this.reporter;
            if (iReporter2 != null) {
                TextView textView = vasSquareFragmentInviteDetailBinding.accept;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.accept");
                iReporter2.setElementInfo(textView, SquareReportConst.ElementId.ELEMENT_ID_ACCEPT_PUBLISH, new LinkedHashMap(), false, false);
            }
            IReporter iReporter3 = this.reporter;
            if (iReporter3 != null) {
                RelativeLayout relativeLayout = vasSquareFragmentInviteDetailBinding.previewContainer;
                Intrinsics.checkNotNullExpressionValue(relativeLayout, "binding.previewContainer");
                iReporter3.setElementInfo(relativeLayout, SquareReportConst.ElementId.ELEMENT_ID_PREVIEW_BOX, new LinkedHashMap(), false, false);
            }
            IReporter iReporter4 = this.reporter;
            if (iReporter4 != null) {
                SquareImageView squareImageView = vasSquareFragmentInviteDetailBinding.end;
                Intrinsics.checkNotNullExpressionValue(squareImageView, "binding.end");
                iReporter4.setElementInfo(squareImageView, "em_zplan_double_pose_end_btn", new LinkedHashMap(), false, false);
            }
        }
    }

    private final void tryUpdateCover(String toUin, Resource resource) {
        if (resource != null) {
            String currentAccountUin = SquareBaseKt.getSquareCommon().getCurrentAccountUin();
            FilamentCoverRecordHelper.INSTANCE.checkAndRecord(getCoverRecorder(), resource.getActionId() + util.base64_pad_url + currentAccountUin + util.base64_pad_url + toUin, currentAccountUin, toUin, resource, true, RecordType.FILAMENT_SQUARE, new FilamentCoverRecorder.IRecordCallback() { // from class: com.tencent.state.square.detail.MultiMotionInviteFragment$tryUpdateCover$1
                @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
                public void onRecordError(int type, FilamentCoverRecorder.RecordRequest request, int errorCode) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "MultiMotionInviteFragment", "onRecordError: uin=" + request.getSender().getUin() + ", actionId=" + request.getResource().getActionId() + ", errorCode=" + errorCode, null, 4, null);
                }

                @Override // com.tencent.state.square.resource.FilamentCoverRecorder.IRecordCallback
                public void onRecordSuccess(FilamentCoverRecorder.RecordRequest request, RecordSource cover) {
                    Intrinsics.checkNotNullParameter(request, "request");
                    Intrinsics.checkNotNullParameter(cover, "cover");
                    SquareBaseKt.getSquareLog().i("MultiMotionInviteFragment", "onRecordSuccess: uin=" + request.getSender().getUin() + ", actionId=" + request.getResource().getActionId() + ", cover=" + cover);
                }
            });
        }
    }

    static /* synthetic */ void showFailToast$default(MultiMotionInviteFragment multiMotionInviteFragment, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        multiMotionInviteFragment.showFailToast(str);
    }
}
