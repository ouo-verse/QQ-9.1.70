package com.tencent.mobileqq.zootopia.redpacket.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.zootopia.redpacket.RedPacketDialogUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.zplan.meme.Meme;
import com.tencent.zplan.meme.a;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.meme.action.MemeAction;
import com.tencent.zplan.meme.action.MemeZPlanAction;
import com.tencent.zplan.meme.model.BusinessConfig;
import com.tencent.zplan.meme.model.MemeResult;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\b*\u0001R\u0018\u0000 X2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J \u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J \u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J8\u0010&\u001a\u00020%2\u0006\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\tH\u0002J\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0002J\u0016\u0010)\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010*\u001a\u00020\u0007R\u0014\u0010,\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010\fR\u0014\u0010.\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010\fR\u0014\u00100\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010\fR\u0014\u00102\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010\fR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\"\u0010=\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010A\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R\"\u0010G\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR2\u0010M\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020I0Hj\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020I`J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder;", "", "", UserInfo.SEX_FEMALE, "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "", "M", "", "path", "isKeepLoading", "I", "H", "N", "", "code", "K", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lhd3/a;", "data", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/b;", "adapter", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewModel;", "viewModel", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketFragment;", "fragment", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "G", "actionId", "frameCount", "width", "height", "Lcom/tencent/zplan/meme/action/MODE;", "mode", "name", "Lcom/tencent/zplan/meme/action/MemeZPlanAction;", "y", "size", "w", "u", "L", "a", "apngWidth", "b", "apngHeight", "c", "pngWidth", "d", "pngHeight", "e", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewModel;", "f", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketFragment;", "g", "Ljava/lang/String;", "getCurMotionGraphLocalPath", "()Ljava/lang/String;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Ljava/lang/String;)V", "curMotionGraphLocalPath", tl.h.F, "getCurPngLocalPath", BdhLogUtil.LogTag.Tag_Req, "curPngLocalPath", "i", HippyTKDListViewAdapter.X, "()I", "setCurRedPacketId", "(I)V", "curRedPacketId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "j", "Ljava/util/HashMap;", "startTimeMap", "Lid3/d;", "k", "Lid3/d;", "reporter", "com/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder$c", "l", "Lcom/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder$c;", "listener", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class RedPacketViewBinder {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private RedPacketViewModel viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RedPacketFragment fragment;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curRedPacketId;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int apngWidth = w(420);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int apngHeight = w(630);

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int pngWidth = w(420);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int pngHeight = w(630);

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String curMotionGraphLocalPath = "";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String curPngLocalPath = "";

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private HashMap<Integer, Long> startTimeMap = new HashMap<>();

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private id3.d reporter = new id3.d(null, 1, null);

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final c listener = new c();

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder$b", "Lcom/tencent/mobileqq/zootopia/redpacket/a;", "Lhd3/a;", "data", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.redpacket.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.redpacket.ui.b f329097b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ RedPacketViewModel f329098c;

        b(com.tencent.mobileqq.zootopia.redpacket.ui.b bVar, RedPacketViewModel redPacketViewModel) {
            this.f329097b = bVar;
            this.f329098c = redPacketViewModel;
        }

        @Override // com.tencent.mobileqq.zootopia.redpacket.a
        public void a(hd3.a data) {
            Intrinsics.checkNotNullParameter(data, "data");
            RedPacketViewBinder.this.S(data, this.f329097b, this.f329098c);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/redpacket/ui/RedPacketViewBinder$c", "Lcom/tencent/zplan/meme/a;", "", "success", "Lcom/tencent/zplan/meme/model/MemeResult;", "result", "", "l9", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.zplan.meme.a {
        c() {
        }

        @Override // com.tencent.zplan.meme.a
        public void d3(MemeAction memeAction, float f16) {
            a.C10066a.a(this, memeAction, f16);
        }

        @Override // com.tencent.zplan.meme.a
        public void l9(boolean success, MemeResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            RedPacketViewModel redPacketViewModel = RedPacketViewBinder.this.viewModel;
            if (redPacketViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                redPacketViewModel = null;
            }
            hd3.a value = redPacketViewModel.P1().getValue();
            String recordPath = result.getRecordPath();
            boolean z16 = false;
            boolean z17 = result.getAction().getMode() == MODE.SHARPP;
            QLog.i("RedPacketViewBinder", 1, "recordDone " + success + " path: " + result.getRecordPath() + " id " + result.getAction().getActionId() + " choose " + (value != null ? Integer.valueOf(value.getActionId()) : null) + " isMotionGraph " + z17);
            if (z17) {
                RedPacketViewBinder.this.M(success, result);
            }
            if (value != null && result.getAction().getActionId() == value.getActionId()) {
                z16 = true;
            }
            if (z16) {
                if (!success || TextUtils.isEmpty(recordPath)) {
                    RedPacketViewBinder.this.H();
                    return;
                }
                if (z17) {
                    RedPacketViewBinder.this.Q(recordPath != null ? recordPath : "");
                } else {
                    RedPacketViewBinder.this.R(recordPath != null ? recordPath : "");
                }
                RedPacketViewBinder redPacketViewBinder = RedPacketViewBinder.this;
                Intrinsics.checkNotNull(recordPath);
                redPacketViewBinder.I(recordPath, !RedPacketViewBinder.this.F());
            }
        }
    }

    private final void A(final RedPacketFragment fragment, final com.tencent.mobileqq.zootopia.redpacket.ui.b adapter, RedPacketViewModel viewModel) {
        viewModel.Q1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketViewBinder.C(b.this, (hd3.c) obj);
            }
        });
        viewModel.R1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketViewBinder.D(b.this, (List) obj);
            }
        });
        viewModel.S1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketViewBinder.E(RedPacketFragment.this, (hd3.b) obj);
            }
        });
        viewModel.P1().observe(fragment.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RedPacketViewBinder.B(RedPacketViewBinder.this, fragment, (hd3.a) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(RedPacketViewBinder this$0, RedPacketFragment fragment, hd3.a it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        QLog.i("RedPacketViewBinder", 1, "cur choose id " + it.getId() + " actionId " + it.getActionId());
        this$0.curRedPacketId = it.getId();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.G(it);
        fragment.Fh(com.tencent.mobileqq.zootopia.redpacket.i.f329070a.f(it.getId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(com.tencent.mobileqq.zootopia.redpacket.ui.b adapter, hd3.c it) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        adapter.q0(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(com.tencent.mobileqq.zootopia.redpacket.ui.b adapter, List it) {
        Intrinsics.checkNotNullParameter(adapter, "$adapter");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        adapter.setData(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(RedPacketFragment fragment, hd3.b it) {
        Intrinsics.checkNotNullParameter(fragment, "$fragment");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        fragment.Eh(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean F() {
        return (TextUtils.isEmpty(this.curMotionGraphLocalPath) || TextUtils.isEmpty(this.curPngLocalPath)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        ImageView imageView;
        Map<String, Object> mutableMapOf;
        RedPacketFragment redPacketFragment = this.fragment;
        RedPacketFragment redPacketFragment2 = null;
        if (redPacketFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            redPacketFragment = null;
        }
        FragmentActivity activity = redPacketFragment.getActivity();
        if (activity != null && !activity.isFinishing()) {
            RedPacketFragment redPacketFragment3 = this.fragment;
            if (redPacketFragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
            } else {
                redPacketFragment2 = redPacketFragment3;
            }
            fi3.b binding = redPacketFragment2.getBinding();
            if (binding != null && (imageView = binding.f399013i) != null) {
                id3.d dVar = this.reporter;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_id", Integer.valueOf(this.curRedPacketId)));
                dVar.c("imp", imageView, mutableMapOf);
            }
            RedPacketDialogUtil.f329064a.d(activity, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketViewBinder$loadAvatarFailed$2
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
                    if (z16) {
                        RedPacketViewModel redPacketViewModel = RedPacketViewBinder.this.viewModel;
                        if (redPacketViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            redPacketViewModel = null;
                        }
                        hd3.a value = redPacketViewModel.P1().getValue();
                        if (value != null) {
                            RedPacketViewBinder.this.G(value);
                        }
                    }
                }
            });
            return;
        }
        QLog.e("RedPacketViewBinder", 1, "loadAvatarFailed but activity status error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(final String path, final boolean isKeepLoading) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.h
            @Override // java.lang.Runnable
            public final void run() {
                RedPacketViewBinder.J(RedPacketViewBinder.this, path, isKeepLoading);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(RedPacketViewBinder this$0, String path, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        RedPacketFragment redPacketFragment = this$0.fragment;
        if (redPacketFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            redPacketFragment = null;
        }
        redPacketFragment.Jh(path, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K(final int code) {
        View view;
        Map<String, Object> mutableMapOf;
        RedPacketFragment redPacketFragment = this.fragment;
        RedPacketFragment redPacketFragment2 = null;
        if (redPacketFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            redPacketFragment = null;
        }
        FragmentActivity activity = redPacketFragment.getActivity();
        if (activity != null && !activity.isFinishing()) {
            RedPacketFragment redPacketFragment3 = this.fragment;
            if (redPacketFragment3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragment");
            } else {
                redPacketFragment2 = redPacketFragment3;
            }
            fi3.b binding = redPacketFragment2.getBinding();
            if (binding != null && (view = binding.f399011g) != null) {
                id3.d dVar = this.reporter;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_id", Integer.valueOf(this.curRedPacketId)), new Pair("zplan_hongbao_err_code", Integer.valueOf(z(code))));
                dVar.c("imp", view, mutableMapOf);
            }
            RedPacketDialogUtil.f329064a.f(activity, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketViewBinder$onSendFailed$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    id3.d dVar2;
                    int z17;
                    Map<String, Object> mutableMapOf2;
                    dVar2 = RedPacketViewBinder.this.reporter;
                    z17 = RedPacketViewBinder.this.z(code);
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_id", Integer.valueOf(RedPacketViewBinder.this.getCurRedPacketId())), new Pair("zplan_hongbao_err_code", Integer.valueOf(z17)), new Pair("zplan_hongbao_select", Integer.valueOf(z16 ? 1 : 0)));
                    dVar2.d("ev_zplan_hongbao_cover_send_fail", mutableMapOf2);
                    if (z16) {
                        RedPacketViewBinder.this.N();
                    }
                }
            });
            return;
        }
        QLog.e("RedPacketViewBinder", 1, "onSendFailed but activity status error");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(boolean success, MemeResult result) {
        String str;
        Map<String, Object> mutableMapOf;
        Long l3 = this.startTimeMap.get(Integer.valueOf(result.getAction().getActionId()));
        long nanoTime = l3 == null ? -1L : (System.nanoTime() - l3.longValue()) / 1000000;
        if (success) {
            str = "ev_zplan_hongbao_cover_loading_sucess";
        } else {
            str = "ev_zplan_hongbao_cover_loading_fail";
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_loading_time", Long.valueOf(nanoTime)), new Pair("zplan_hongbao_cover_avatar_id", Integer.valueOf(result.getAction().getActionId())));
        this.reporter.d(str, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        RedPacketFragment redPacketFragment = this.fragment;
        if (redPacketFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            redPacketFragment = null;
        }
        redPacketFragment.yh();
        RedPacketViewModel redPacketViewModel = this.viewModel;
        if (redPacketViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            redPacketViewModel = null;
        }
        final hd3.a value = redPacketViewModel.P1().getValue();
        if (value == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                RedPacketViewBinder.O(RedPacketViewBinder.this, value);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(final RedPacketViewBinder this$0, final hd3.a data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        if (Intrinsics.areEqual(MD5Utils.encodeFileHexStr(this$0.curMotionGraphLocalPath), data.getAvatarMd5())) {
            QLog.i("RedPacketViewBinder", 1, "md5 match not upload");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.m
                @Override // java.lang.Runnable
                public final void run() {
                    RedPacketViewBinder.P(RedPacketViewBinder.this, data);
                }
            });
            return;
        }
        RedPacketViewModel redPacketViewModel = this$0.viewModel;
        if (redPacketViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            redPacketViewModel = null;
        }
        redPacketViewModel.b2(this$0.curMotionGraphLocalPath, this$0.curPngLocalPath, this$0.curRedPacketId, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.RedPacketViewBinder$send$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                RedPacketFragment redPacketFragment;
                RedPacketFragment redPacketFragment2;
                id3.d dVar;
                Map<String, Object> mutableMapOf;
                QLog.i("RedPacketViewBinder", 1, "choose redPacket " + RedPacketViewBinder.this.getCurRedPacketId() + " result " + i3);
                redPacketFragment = RedPacketViewBinder.this.fragment;
                RedPacketViewModel redPacketViewModel2 = null;
                if (redPacketFragment == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragment");
                    redPacketFragment2 = null;
                } else {
                    redPacketFragment2 = redPacketFragment;
                }
                RedPacketViewModel redPacketViewModel3 = RedPacketViewBinder.this.viewModel;
                if (redPacketViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    redPacketViewModel2 = redPacketViewModel3;
                }
                redPacketFragment2.xh(redPacketViewModel2.getCurAvatarId(), RedPacketViewBinder.this.getCurRedPacketId(), data.getTitle(), i3 == 0);
                if (i3 != 0) {
                    RedPacketViewBinder.this.K(i3);
                    return;
                }
                dVar = RedPacketViewBinder.this.reporter;
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_id", Integer.valueOf(RedPacketViewBinder.this.getCurRedPacketId())));
                dVar.d("ev_zplan_hongbao_cover_send_success", mutableMapOf);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(RedPacketViewBinder this$0, hd3.a data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        RedPacketFragment redPacketFragment = this$0.fragment;
        if (redPacketFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            redPacketFragment = null;
        }
        redPacketFragment.xh(data.getAvatarId(), data.getId(), data.getTitle(), true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S(hd3.a data, com.tencent.mobileqq.zootopia.redpacket.ui.b adapter, RedPacketViewModel viewModel) {
        hd3.a value = viewModel.P1().getValue();
        if (value != null) {
            value.k(false);
            adapter.r0(value);
        }
        this.curRedPacketId = data.getId();
        data.k(true);
        adapter.r0(data);
        viewModel.Z1(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(RedPacketViewBinder this$0, View it) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        id3.d dVar = this$0.reporter;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_hongbao_cover_id", Integer.valueOf(this$0.curRedPacketId)));
        dVar.c("clck", it, mutableMapOf);
        if (!this$0.F()) {
            RedPacketDialogUtil redPacketDialogUtil = RedPacketDialogUtil.f329064a;
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "it.context");
            redPacketDialogUtil.e(context);
            return;
        }
        this$0.N();
    }

    private final int w(int size) {
        return size - (size % 4);
    }

    private final MemeZPlanAction y(int actionId, int frameCount, int width, int height, MODE mode, String name) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        String currentUin = waitAppRuntime != null ? waitAppRuntime.getCurrentUin() : null;
        MemeZPlanAction memeZPlanAction = new MemeZPlanAction(actionId, frameCount, width, height, mode, currentUin == null ? "" : currentUin, name);
        memeZPlanAction.getConfig().C(BusinessConfig.FrameType.PNG);
        return memeZPlanAction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z(int code) {
        if (code != -2) {
            if (code != -1) {
                return 1;
            }
            return 2;
        }
        return 3;
    }

    public final void L() {
        RedPacketViewModel redPacketViewModel = this.viewModel;
        if (redPacketViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            redPacketViewModel = null;
        }
        hd3.a value = redPacketViewModel.P1().getValue();
        if (value != null) {
            G(value);
        }
    }

    public final void Q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curMotionGraphLocalPath = str;
    }

    public final void R(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.curPngLocalPath = str;
    }

    public final void u(RedPacketFragment fragment, RedPacketViewModel viewModel) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        this.viewModel = viewModel;
        this.fragment = fragment;
        com.tencent.mobileqq.zootopia.redpacket.ui.b adapter = fragment.getAdapter();
        A(fragment, adapter, viewModel);
        adapter.p0(new b(adapter, viewModel));
        fragment.Gh(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.redpacket.ui.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RedPacketViewBinder.v(RedPacketViewBinder.this, view);
            }
        });
    }

    /* renamed from: x, reason: from getter */
    public final int getCurRedPacketId() {
        return this.curRedPacketId;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(hd3.a data) {
        MemeZPlanAction y16 = y(data.getActionId(), 1, this.pngWidth, this.pngHeight, MODE.FRAME, String.valueOf(data.getActionId()));
        MemeZPlanAction y17 = y(data.getActionId(), -1, this.apngWidth, this.apngHeight, MODE.SHARPP, String.valueOf(data.getActionId()));
        this.curMotionGraphLocalPath = "";
        this.curPngLocalPath = "";
        RedPacketFragment redPacketFragment = this.fragment;
        if (redPacketFragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            redPacketFragment = null;
        }
        redPacketFragment.Jh("", true);
        this.startTimeMap.put(Integer.valueOf(data.getActionId()), Long.valueOf(System.nanoTime()));
        Meme meme = Meme.f385754h;
        Meme.y(meme, y16, false, this.listener, 2, null);
        Meme.y(meme, y17, false, this.listener, 2, null);
    }
}
