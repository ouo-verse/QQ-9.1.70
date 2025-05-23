package com.tencent.mobileqq.wink.pubcover;

import a63.WinkBubbleInfo;
import a63.a;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.ams.mosaic.jsengine.component.ComponentFactory;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragDropScrollView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanelViewController;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackContainerView;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.VideoTrackData;
import com.tencent.mobileqq.wink.editor.cover.WinkExtractCoverViewModel;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditDataWrapper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.editor.view.BorderCoverView;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.mobileqq.wink.pubcover.WinkCoverExportVideoReceiver;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment;
import com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel;
import com.tencent.mobileqq.wink.pubcover.c;
import com.tencent.mobileqq.wink.pubcover.e;
import com.tencent.mobileqq.wink.pubcover.s;
import com.tencent.mobileqq.wink.pubcover.template.WinkCoverTemplateMenuPart;
import com.tencent.mobileqq.wink.pubcover.text.WinkCoverTextMenuPart;
import com.tencent.mobileqq.wink.pubcover.w;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.wink.view.WinkStickerFrameLayout;
import com.tencent.mobileqq.winkpublish.report.ExportErrorCode;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.tav.core.AssetImageGenerator;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.OnReadSnapShootListener;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.render.rendernode.BaseEffectNode;
import com.tencent.tavcut.core.session.ICutStatusCallback;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaClipForCover;
import com.tencent.widget.immersive.ImmersiveUtils;
import g63.CommonConfig;
import g63.LayoutConfig;
import g63.ScrollConfig;
import g63.TimeBarConfig;
import g63.VideoTrackConfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Size;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkCoverSelectFragment extends ImmersivePartFragment implements View.OnClickListener, com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h, WinkCoverExportVideoReceiver.a, e.a {
    public static int H0 = 500;
    public static MetaMaterial J0;
    public static String K0;
    protected String C;
    protected ArrayList<LocalMediaInfo> D;
    private WinkCoverSelectViewModel E;
    private FrameLayout G;
    private ImageView H;
    private TextView I;
    private RelativeLayout J;
    private RelativeLayout K;
    private RoundCornerImageView L;
    private WinkStickerFrameLayout N;
    private BorderCoverView P;
    private WinkCoverBgSelectListView Q;
    private com.tencent.mobileqq.wink.pubcover.c R;
    private TextView S;
    private TextView T;
    private TextView U;
    private View V;
    private View W;
    private View X;
    private View Y;
    private s Z;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.d f325458a0;

    /* renamed from: b0, reason: collision with root package name */
    private WinkCoverTextMenuPart f325459b0;

    /* renamed from: c0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.pubcover.text.a f325460c0;

    /* renamed from: d0, reason: collision with root package name */
    private TimelinePanel f325461d0;

    /* renamed from: e0, reason: collision with root package name */
    private TimelinePanelViewController f325462e0;

    /* renamed from: f0, reason: collision with root package name */
    private TimelineViewModelV2 f325463f0;

    /* renamed from: h0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l f325465h0;

    /* renamed from: i0, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d f325466i0;

    /* renamed from: j0, reason: collision with root package name */
    private LinearLayout f325467j0;

    /* renamed from: k0, reason: collision with root package name */
    private View f325468k0;

    /* renamed from: l0, reason: collision with root package name */
    private View f325469l0;

    /* renamed from: p0, reason: collision with root package name */
    private Pair<Integer, Integer> f325473p0;

    /* renamed from: q0, reason: collision with root package name */
    private IPlayer f325474q0;
    private static final List<String> I0 = Arrays.asList(ComponentFactory.ComponentType.PAG, "#03081A", "#FFFFFF", "#BFBDBE", "#32498F", "#9D5364", "#7C7FAC", "#7B886F", "#F0CE8A");
    public static ArrayList<MetaMaterial> L0 = new ArrayList<>();
    public static ArrayList<String> M0 = new ArrayList<>();
    private com.tencent.mobileqq.wink.pubcover.template.l F = null;
    private View M = null;

    /* renamed from: g0, reason: collision with root package name */
    private v f325464g0 = new h();

    /* renamed from: m0, reason: collision with root package name */
    private long f325470m0 = 0;

    /* renamed from: n0, reason: collision with root package name */
    private int f325471n0 = 0;

    /* renamed from: o0, reason: collision with root package name */
    private String f325472o0 = "";

    /* renamed from: r0, reason: collision with root package name */
    String f325475r0 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/QQ_Images/tempCoverBitmap";

    /* renamed from: s0, reason: collision with root package name */
    private boolean f325476s0 = true;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f325477t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f325478u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f325479v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f325480w0 = false;

    /* renamed from: x0, reason: collision with root package name */
    private MetaMaterial f325481x0 = null;

    /* renamed from: y0, reason: collision with root package name */
    private MetaMaterial f325482y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    private GetCoverRunnable f325483z0 = new GetCoverRunnable();
    private WinkCoverExportVideoReceiver A0 = new WinkCoverExportVideoReceiver(this);
    private final ISessionListener B0 = new j();
    private final IPlayer.PlayerListener C0 = new AnonymousClass3();
    private boolean D0 = false;
    private final ISessionListener E0 = new k();
    private ViewTreeObserver.OnGlobalLayoutListener F0 = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.8
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(api = 21)
        public void onGlobalLayout() {
            try {
                WinkCoverSelectFragment.this.G.getViewTreeObserver().removeOnGlobalLayoutListener(WinkCoverSelectFragment.this.F0);
                int width = WinkCoverSelectFragment.this.G.getWidth();
                int height = WinkCoverSelectFragment.this.G.getHeight();
                int i3 = width * 4;
                int i16 = height * 3;
                if (i3 > i16) {
                    width = i16 / 4;
                } else {
                    height = i3 / 3;
                }
                ViewGroup.LayoutParams layoutParams = WinkCoverSelectFragment.this.G.getLayoutParams();
                layoutParams.width = width;
                layoutParams.height = height;
                WinkCoverSelectFragment.this.G.requestLayout();
                ViewGroup.LayoutParams layoutParams2 = WinkCoverSelectFragment.this.N.getLayoutParams();
                layoutParams2.width = width;
                layoutParams2.height = height;
                WinkCoverSelectFragment.this.N.requestLayout();
                ViewGroup.LayoutParams layoutParams3 = WinkCoverSelectFragment.this.P.getLayoutParams();
                layoutParams3.width = width;
                layoutParams3.height = height;
                WinkCoverSelectFragment.this.P.requestLayout();
            } catch (Exception e16) {
                ms.a.e("WinkCoverSelectFragment", e16);
            }
            if (!com.tencent.mobileqq.wink.l.d()) {
                com.tencent.mobileqq.wink.l.e();
                FragmentActivity activity = WinkCoverSelectFragment.this.getActivity();
                if (activity != null) {
                    QQToast.makeText(activity, R.string.f240277oq, 0).show();
                    activity.finish();
                    return;
                }
            }
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.8.1
                @Override // java.lang.Runnable
                public void run() {
                    WinkCoverSelectFragment.this.vi();
                    WinkCoverSelectFragment.this.Ii();
                }
            }, 100L);
        }
    };
    private boolean G0 = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment$3, reason: invalid class name */
    /* loaded from: classes21.dex */
    public class AnonymousClass3 implements IPlayer.PlayerListener {
        AnonymousClass3() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(final t73.a aVar) {
            WinkCoverSelectFragment.this.f325461d0.post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.3.1
                @Override // java.lang.Runnable
                public void run() {
                    Long l3 = (Long) aVar.a();
                    if (l3 != null && WinkCoverSelectFragment.this.f325470m0 < 0) {
                        WinkCoverSelectFragment.this.f325462e0.z(l3.longValue());
                        WinkCoverSelectFragment.this.f325463f0.i3(l3.longValue());
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d() {
            if (WinkCoverSelectFragment.this.getView() == null) {
                return;
            }
            WinkCoverSelectFragment.this.E.c2().observe(WinkCoverSelectFragment.this.getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkCoverSelectFragment.AnonymousClass3.this.c((t73.a) obj);
                }
            });
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            if (WinkCoverSelectFragment.this.f325474q0 == null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkCoverSelectFragment.AnonymousClass3.this.d();
                    }
                });
            }
            WinkCoverSelectFragment.this.f325474q0 = iPlayer;
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long j3, long j16) {
            if (WinkCoverSelectFragment.this.R != null && WinkCoverSelectFragment.this.f325463f0 != null && (WinkCoverSelectFragment.this.f325463f0.C2() instanceof WinkVideoTavCut)) {
                WinkCoverSelectFragment.this.R.b(true, false);
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus playerStatus, @NotNull IPlayer iPlayer) {
            WinkCoverSelectFragment.this.f325463f0.b3();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class GetCoverRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        long f325505d = 0;

        /* renamed from: e, reason: collision with root package name */
        boolean f325506e = false;

        GetCoverRunnable() {
        }

        void a(long j3) {
            this.f325505d = j3;
        }

        void b(boolean z16) {
            this.f325506e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            w53.b.f("WinkCoverSelectFragment", "\u66f4\u65b0cover start:" + this.f325505d);
            Bitmap ii5 = WinkCoverSelectFragment.this.ii(this.f325505d);
            w53.b.f("WinkCoverSelectFragment", "\u66f4\u65b0cover end:" + this.f325505d);
            WinkCoverSelectFragment.this.Zi(ii5, this.f325505d, this.f325506e);
            b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements s.b {
        a() {
        }

        @Override // com.tencent.mobileqq.wink.pubcover.s.b
        public void a(@NonNull WinkStickerModel winkStickerModel) {
            if (WinkCoverSelectFragment.this.f325460c0 != null && winkStickerModel.isTemplateTextSticker()) {
                WinkCoverSelectFragment.this.f325460c0.bd(winkStickerModel, WinkCoverSelectFragment.this.Z);
            } else if (WinkCoverSelectFragment.this.f325459b0 != null) {
                WinkCoverSelectFragment.this.f325459b0.bd(winkStickerModel, WinkCoverSelectFragment.this.Z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements c.Companion.InterfaceC9078a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.pubcover.c.Companion.InterfaceC9078a
        public void a(boolean z16) {
            if (z16) {
                WinkCoverSelectFragment.this.Q.setVisibility(0);
            } else {
                WinkCoverSelectFragment.this.Q.setVisibility(4);
                WinkCoverSelectFragment.this.Q.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (WinkCoverSelectFragment.this.getActivity() != null && !WinkCoverSelectFragment.this.getActivity().isFinishing()) {
                WinkCoverSelectFragment.this.getActivity().setResult(0);
                WinkCoverSelectFragment.this.getActivity().finish();
            }
            FileUtils.delete(WinkCoverSelectFragment.this.f325475r0, false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (WinkCoverSelectFragment.this.getActivity() != null && !WinkCoverSelectFragment.this.getActivity().isFinishing()) {
                WinkCoverSelectFragment.this.getActivity().setResult(0);
                WinkCoverSelectFragment.this.getActivity().finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DialogInterface.OnClickListener f325511d;

        e(DialogInterface.OnClickListener onClickListener) {
            this.f325511d = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            w.f325612a.f();
            this.f325511d.onClick(null, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (WinkCoverSelectFragment.this.getActivity() != null && !WinkCoverSelectFragment.this.getActivity().isFinishing()) {
                WinkCoverSelectFragment.this.getActivity().setResult(0);
                WinkCoverSelectFragment.this.getActivity().finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class h extends v {
        h() {
        }

        @Override // com.tencent.mobileqq.wink.pubcover.v
        public boolean e() {
            return WinkCoverSelectFragment.this.f325476s0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class i implements OnReadSnapShootListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f325516a;

        i(long j3) {
            this.f325516a = j3;
        }

        @Override // com.tencent.tav.player.OnReadSnapShootListener
        public void onSuccess(Bitmap bitmap, CMTime cMTime) {
            if (bitmap == null || bitmap.isRecycled()) {
                bitmap = WinkCoverSelectFragment.this.hi(this.f325516a);
            } else {
                w53.b.f("WinkCoverSelectFragment", "saveVideoProgressCover: readSnapShootBitmap success");
            }
            WinkCoverSelectFragment.this.Ni(bitmap);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class l implements Observer<MetaMaterial> {
        l() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(MetaMaterial metaMaterial) {
            WinkCoverSelectFragment.this.Z.q();
            if (((metaMaterial != null && WinkCoverSelectFragment.this.f325482y0 == null) || (metaMaterial != null && !metaMaterial.f30533id.equals(WinkCoverSelectFragment.this.f325482y0.f30533id))) && WinkCoverSelectFragment.this.f325463f0 != null && WinkCoverSelectFragment.this.f325463f0.C2() != null && WinkCoverSelectFragment.this.f325463f0.C2().m() != null && WinkCoverSelectFragment.this.f325463f0.C2().m().values() != null) {
                ArrayList arrayList = new ArrayList();
                for (WinkStickerModel winkStickerModel : WinkCoverSelectFragment.this.f325463f0.C2().m().values()) {
                    if (winkStickerModel.isTemplateTextSticker()) {
                        arrayList.add(winkStickerModel);
                    }
                }
                WinkCoverSelectFragment.this.f325463f0.C2().T(arrayList);
            }
            if (WinkCoverSelectFragment.this.f325471n0 == 0) {
                WinkCoverSelectFragment.this.di(metaMaterial, 0, "");
            } else {
                WinkCoverSelectFragment winkCoverSelectFragment = WinkCoverSelectFragment.this;
                winkCoverSelectFragment.di(metaMaterial, 1, winkCoverSelectFragment.f325472o0);
            }
            WinkCoverSelectFragment.this.f325482y0 = metaMaterial;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface m<T extends MediaClip> {
        void a(List<T> list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean Ai(com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g gVar) {
        boolean z16;
        if (!(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.n) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.f) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d)) {
            z16 = false;
        } else {
            z16 = true;
        }
        return Boolean.valueOf(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit Ci(Integer num, Float f16) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Di(List list) {
        if (list != null && list.size() > 0) {
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) list.get(0);
            if (QAlbumUtil.getMediaType(localMediaInfo) == 0) {
                String j3 = MediaCompressUtils.f325262a.j(0, localMediaInfo, true, new Function2() { // from class: com.tencent.mobileqq.wink.pubcover.h
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit Ci;
                        Ci = WinkCoverSelectFragment.Ci((Integer) obj, (Float) obj2);
                        return Ci;
                    }
                });
                if (!TextUtils.isEmpty(j3)) {
                    localMediaInfo.path = j3;
                }
            }
            Wi(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Ei() {
        IPlayer iPlayer;
        long min = Math.min(this.f325470m0, this.E.e2().getDuration());
        if (uq3.c.v5() && (iPlayer = this.f325474q0) != null) {
            iPlayer.readSnapShootBitmap(new i(min));
            this.f325474q0.seek(min);
            w53.b.f("WinkCoverSelectFragment", "saveVideoProgressCover: readSnapShootBitmap start");
        } else if (this.f325463f0 != null) {
            Ni(hi(min));
        } else {
            Ni(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fi() {
        Ii();
        aj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gi() {
        TimelineViewModelV2 timelineViewModelV2;
        if (this.G0) {
            return;
        }
        Ji();
        this.G0 = true;
        w wVar = w.f325612a;
        if (wVar.b().getTemplateMetaMaterial() != null && this.F != null) {
            Hi(wVar.b().getTemplateMetaMaterial());
            this.F.Q1(wVar.b().getTemplateMetaMaterial(), false);
            this.f325482y0 = wVar.b().getTemplateMetaMaterial();
        }
        com.tencent.mobileqq.wink.pubcover.c cVar = this.R;
        if (cVar != null) {
            cVar.b(true, true);
        }
        this.f325472o0 = wVar.b().getLastCoverBgSelectColor();
        int lastCoverBgSelectPostion = wVar.b().getLastCoverBgSelectPostion();
        this.f325471n0 = lastCoverBgSelectPostion;
        this.Q.setSelect(lastCoverBgSelectPostion);
        long coverTimeProgress = wVar.b().getVideoDraft().getCoverTimeProgress();
        if (coverTimeProgress > 0 && this.f325462e0 != null && wVar.b().getCurrentTabType() == 0 && (timelineViewModelV2 = this.f325463f0) != null) {
            timelineViewModelV2.i3(coverTimeProgress);
            this.f325462e0.z(coverTimeProgress);
        }
        if (wVar.b().getCurrentTabType() == 1) {
            Mi();
        }
    }

    private void Hi(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        if (!this.f325478u0 && this.f325476s0) {
            this.f325479v0 = true;
        }
        com.tencent.mobileqq.wink.pubcover.template.l lVar = this.F;
        if (lVar != null) {
            lVar.S1(metaMaterial.f30533id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ii() {
        this.G.setVisibility(0);
        this.f325461d0.setVisibility(0);
        this.K.setVisibility(8);
        this.J.setVisibility(0);
    }

    private void Ji() {
        String str;
        w wVar = w.f325612a;
        if (wVar.b().getCurrentTabType() == 1) {
            this.S.setTypeface(Typeface.defaultFromStyle(0));
            this.T.setTypeface(Typeface.defaultFromStyle(1));
            Ri(this.T, Boolean.TRUE);
            Ri(this.S, Boolean.FALSE);
            this.V.setVisibility(8);
            this.W.setVisibility(0);
            if (wVar.b().getAlbumDraft().d() != null && !wVar.b().getAlbumDraft().d().isEmpty()) {
                this.J.setVisibility(8);
                this.K.setVisibility(0);
                this.L.setImageURI(Uri.fromFile(new File(wVar.b().getAlbumDraft().d().get(0).path)));
                this.U.setText("\u70b9\u51fb\u4fee\u6539");
            } else {
                this.J.setVisibility(0);
                this.K.setVisibility(8);
                this.U.setText("\u70b9\u51fb\u4e0a\u4f20\u56fe\u7247");
            }
            this.X.setVisibility(8);
            this.Y.setVisibility(0);
        }
        if (wVar.b().getCurrentTabType() == 0) {
            this.T.setTypeface(Typeface.defaultFromStyle(0));
            this.S.setTypeface(Typeface.defaultFromStyle(1));
            Ri(this.T, Boolean.FALSE);
            Ri(this.S, Boolean.TRUE);
            this.V.setVisibility(0);
            this.W.setVisibility(8);
            this.Y.setVisibility(8);
            this.X.setVisibility(0);
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (wVar.b().getCurrentTabType() == 1) {
            str = "\u76f8\u518c\u5bfc\u5165";
        } else {
            str = "\u89c6\u9891\u5e27";
        }
        buildElementParams.put("xsj_tab_name", str);
        VideoReport.resetElementParams(this.I);
        VideoReport.setElementParams(this.I, buildElementParams);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b0, code lost:
    
        switch(r9) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            default: goto L42;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00b4, code lost:
    
        r1.add(r6.f30533id);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ba, code lost:
    
        r3.add(r6.f30533id);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c0, code lost:
    
        r2.add(r6.f30533id);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void Ki() {
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        MetaMaterial templateMetaMaterial = w.f325612a.b().getTemplateMetaMaterial();
        if (templateMetaMaterial != null) {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, templateMetaMaterial.f30533id);
            buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLETE_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(templateMetaMaterial));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, templateMetaMaterial.f30533id);
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLETE_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(templateMetaMaterial));
        } else {
            buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, "");
            buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLETE_CATEGORY, "");
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, "");
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_TEMPLATE_ID, "");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i3 = 0;
        while (true) {
            w wVar = w.f325612a;
            if (wVar.b().h() != null && i3 < wVar.b().h().size()) {
                MetaMaterial material = wVar.b().h().get(i3).getMaterial();
                if (material != null) {
                    String o16 = com.tencent.mobileqq.wink.editor.c.o(material);
                    o16.hashCode();
                    char c16 = '\uffff';
                    switch (o16.hashCode()) {
                        case -921884268:
                            if (o16.equals("CATEGORY_TEXT_DECOR")) {
                                c16 = 0;
                                break;
                            }
                            break;
                        case -907563552:
                            if (o16.equals("CATEGORY_TEXT_STYLE")) {
                                c16 = 1;
                                break;
                            }
                            break;
                        case 793913343:
                            if (o16.equals("CATEGORY_TEXT_PATTERN")) {
                                c16 = 2;
                                break;
                            }
                            break;
                    }
                }
                i3++;
            }
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_FORM_ID, ni(arrayList3));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_PATTERN_ID, ni(arrayList2));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_ART_ID, ni(arrayList));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_FILLED_COLOR, I0.get(this.f325471n0));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_VIDEO_FINAL_SCALE_VALUE, li());
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_FORM_ID, ni(arrayList3));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_PATTERN_ID, ni(arrayList2));
        WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_COVER_CHAR_ART_ID, ni(arrayList));
        VideoReport.reportEvent("dt_clck", this.I, buildElementParams);
    }

    private void Li() {
        TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
        if (timelineViewModelV2 != null && timelineViewModelV2.u2() != null && this.f325463f0.u2().size() != 0 && this.f325463f0.u2().get(0) != null && this.f325463f0.u2().get(0).resource != null && this.f325463f0.u2().get(0).resource.size != null) {
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.EventId.XSJ_VIDEO_ORIGINAL_SCALE_VALUE, this.f325463f0.u2().get(0).resource.size.height + ":" + this.f325463f0.u2().get(0).resource.size.width);
            VideoReport.reportEvent("ev_xsj_camera_action", buildElementParams);
        }
    }

    private void Mi() {
        int i3;
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        if (w.f325612a.b().getAlbumDraft().d() == null) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_IS_EXIST_PIC, Integer.valueOf(i3));
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_UPLOAD_COVER);
        buildElementParams.put("xsj_custom_pgid", getPageId());
        VideoReport.reportEvent("ev_xsj_abnormal_imp", null, buildElementParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0249: MOVE (r8 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) = (r10 I:??[int, float, boolean, short, byte, char, OBJECT, ARRAY]) (LINE:586), block:B:77:0x0249 */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0281  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void Ni(Bitmap bitmap) {
        boolean z16;
        z93.c f16;
        boolean z17;
        ExportErrorCode exportErrorCode;
        z93.c f17;
        WinkPublishQualityReportData.Builder builder;
        WinkPublishQualityReportData.Builder ext3;
        StringBuilder sb5;
        long j3 = 0;
        boolean z18 = false;
        try {
            try {
            } catch (Exception e16) {
                e = e16;
                z16 = false;
            } catch (Throwable th5) {
                th = th5;
                if (getActivity() != null) {
                    getActivity().finish();
                    if (!z18) {
                    }
                    if (!z18) {
                    }
                    ExportErrorCode exportErrorCode2 = new ExportErrorCode(j3, null);
                    f16 = Wink.INSTANCE.f();
                    if (f16 != null) {
                    }
                }
                throw th;
            }
            if (bitmap == null) {
                ms.a.c("WinkCoverSelectFragment", "\u7528\u6237\u672a\u6539\u53d8\u5c01\u9762\u56fe\uff0c\u6216\u8005\u83b7\u53d6\u5c01\u9762\u56fe\u5931\u8d25");
                if (getActivity() != null && !getActivity().isFinishing()) {
                    getActivity().setResult(0);
                }
                if (getActivity() != null && !getActivity().isFinishing()) {
                    getActivity().finish();
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(WinkCoverSelectFragment.this.getActivity(), -1, WinkCoverSelectFragment.this.getActivity().getString(R.string.f239977nx), 0).show();
                        }
                    });
                    ExportErrorCode exportErrorCode3 = new ExportErrorCode(ExportErrorCode.ERROR_CODE_COVER_EXTRACT_FAILED, null);
                    z93.c f18 = Wink.INSTANCE.f();
                    if (f18 != null) {
                        WinkPublishQualityReportData.Builder builder2 = new WinkPublishQualityReportData.Builder();
                        builder2.eventId("E_EXTRACT_VIDEO_COVER").ext3("5").retCode(exportErrorCode3.transformedCode() + "").desc(exportErrorCode3.getMessage());
                        f18.a(builder2.getReportData(), 1);
                        return;
                    }
                    return;
                }
                return;
            }
            ms.a.f("WinkCoverSelectFragment", "saveDataAndQuit: w=" + bitmap.getWidth() + " h=" + bitmap.getHeight());
            String str = u53.b.f438379j + File.separator + this.C + "_" + System.currentTimeMillis() + ".JPG";
            File file = new File(str);
            if (!file.getParentFile().exists() && !file.getParentFile().mkdirs()) {
                ms.a.c("WinkCoverSelectFragment", "\u4fdd\u5b58\u5c01\u9762\uff0c\u521b\u5efa\u7236\u8def\u5f84\u5931\u8d25");
            }
            if (!file.createNewFile()) {
                ms.a.c("WinkCoverSelectFragment", "\u4fdd\u5b58\u5c01\u9762\uff0c\u521b\u5efa\u5c01\u9762\u6587\u4ef6\u5931\u8d25");
            }
            z16 = FileUtils.saveBitmapToFile(bitmap, str);
            try {
                if (z16) {
                    ms.a.f("WinkCoverSelectFragment", "\u5c01\u9762\u4fdd\u5b58\u6210\u529f,path=" + str);
                    Intent intent = new Intent();
                    intent.putExtra(AEEditorConstants.KEY_VIDEO_COVER_PATH, str);
                    intent.putExtra(AEEditorConstants.KEY_VIDEO_MEDIA_PATH, getMediaPath());
                    getActivity().setResult(-1, intent);
                } else {
                    ms.a.c("WinkCoverSelectFragment", "\u5c01\u9762\u4fdd\u5b58\u51fa\u9519");
                    getActivity().setResult(0);
                }
                bitmap.recycle();
            } catch (Exception e17) {
                e = e17;
                ms.a.c("WinkCoverSelectFragment", "\u5c01\u9762\u4fdd\u5b58\u51fa\u9519:" + e.toString());
                if (getActivity() != null && !getActivity().isFinishing()) {
                    getActivity().setResult(0);
                }
                if (getActivity() != null && !getActivity().isFinishing()) {
                    getActivity().finish();
                    if (!z16) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.22
                            @Override // java.lang.Runnable
                            public void run() {
                                QQToast.makeText(WinkCoverSelectFragment.this.getActivity(), -1, WinkCoverSelectFragment.this.getActivity().getString(R.string.f239977nx), 0).show();
                            }
                        });
                    }
                    if (!z16) {
                        j3 = ExportErrorCode.ERROR_CODE_COVER_EXTRACT_FAILED;
                    }
                    exportErrorCode = new ExportErrorCode(j3, null);
                    f17 = Wink.INSTANCE.f();
                    if (f17 != null) {
                        builder = new WinkPublishQualityReportData.Builder();
                        ext3 = builder.eventId("E_EXTRACT_VIDEO_COVER").ext3("5");
                        sb5 = new StringBuilder();
                        sb5.append(exportErrorCode.transformedCode());
                        sb5.append("");
                        ext3.retCode(sb5.toString()).desc(exportErrorCode.getMessage());
                        f17.a(builder.getReportData(), 1);
                    }
                    return;
                }
                return;
            }
            if (getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
                if (!z16) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(WinkCoverSelectFragment.this.getActivity(), -1, WinkCoverSelectFragment.this.getActivity().getString(R.string.f239977nx), 0).show();
                        }
                    });
                }
                if (!z16) {
                    j3 = ExportErrorCode.ERROR_CODE_COVER_EXTRACT_FAILED;
                }
                exportErrorCode = new ExportErrorCode(j3, null);
                f17 = Wink.INSTANCE.f();
                if (f17 != null) {
                    builder = new WinkPublishQualityReportData.Builder();
                    ext3 = builder.eventId("E_EXTRACT_VIDEO_COVER").ext3("5");
                    sb5 = new StringBuilder();
                    sb5.append(exportErrorCode.transformedCode());
                    sb5.append("");
                    ext3.retCode(sb5.toString()).desc(exportErrorCode.getMessage());
                    f17.a(builder.getReportData(), 1);
                }
            }
        } catch (Throwable th6) {
            th = th6;
            z18 = z17;
            if (getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
                if (!z18) {
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.22
                        @Override // java.lang.Runnable
                        public void run() {
                            QQToast.makeText(WinkCoverSelectFragment.this.getActivity(), -1, WinkCoverSelectFragment.this.getActivity().getString(R.string.f239977nx), 0).show();
                        }
                    });
                }
                if (!z18) {
                    j3 = ExportErrorCode.ERROR_CODE_COVER_EXTRACT_FAILED;
                }
                ExportErrorCode exportErrorCode22 = new ExportErrorCode(j3, null);
                f16 = Wink.INSTANCE.f();
                if (f16 != null) {
                    WinkPublishQualityReportData.Builder builder3 = new WinkPublishQualityReportData.Builder();
                    builder3.eventId("E_EXTRACT_VIDEO_COVER").ext3("5").retCode(exportErrorCode22.transformedCode() + "").desc(exportErrorCode22.getMessage());
                    f16.a(builder3.getReportData(), 1);
                }
            }
            throw th;
        }
    }

    private void Oi() {
        com.tencent.mobileqq.wink.pubcover.template.l lVar = this.F;
        Map<String, WinkStickerModel> map = null;
        if (lVar != null) {
            if (lVar.L1().getValue() == null && this.F.M1().getValue() == null) {
                w.f325612a.b().m(null);
            } else if (this.F.M1().getValue() != null) {
                w.f325612a.b().m(this.F.M1().getValue());
            }
        }
        w wVar = w.f325612a;
        wVar.b().l(this.f325471n0);
        wVar.b().k(this.f325472o0);
        if (this.f325463f0 != null && wVar.b().getCurrentTabType() == 0) {
            wVar.b().getVideoDraft().f(this.f325463f0.getCurSeekTimeUs());
            wVar.b().getVideoDraft().g(this.f325476s0);
            if (this.f325476s0 && this.R != null) {
                wVar.b().getVideoDraft().i(this.R.getClipHeight());
                wVar.b().getVideoDraft().h(this.R.getClipWidth());
            }
        }
        if (this.R != null) {
            wVar.g(new Matrix(this.R.m()));
        }
        TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
        if (timelineViewModelV2 != null) {
            map = timelineViewModelV2.C2().m();
        }
        if (map != null) {
            wVar.b().n(new ArrayList<>(map.values()));
        }
    }

    private void Pi() {
        TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
        if (timelineViewModelV2 != null) {
            this.f325470m0 = timelineViewModelV2.getCurSeekTimeUs();
        }
        Qi();
        Oi();
    }

    private void Qi() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.j
            @Override // java.lang.Runnable
            public final void run() {
                WinkCoverSelectFragment.this.Ei();
            }
        }, 64, null, true);
    }

    private void Ri(TextView textView, Boolean bool) {
        if (bool.booleanValue()) {
            textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_primary));
        } else {
            textView.setTextColor(textView.getContext().getColorStateList(R.color.qui_common_text_secondary));
        }
    }

    private void Ti() {
        final com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(getContext());
        a.Companion companion = a63.a.INSTANCE;
        WinkBubbleInfo e16 = companion.a().e(getActivity(), "winkCoverImageTip");
        if (this.T != null && e16 != null) {
            r16.o0(e16.getTipsString());
            r16.m0(3);
            r16.k0(0);
            r16.R(0);
            r16.S(this.T);
            r16.s0();
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.24
                @Override // java.lang.Runnable
                public void run() {
                    if (r16 != null && !WinkCoverSelectFragment.this.getActivity().isFinishing()) {
                        r16.o();
                    }
                }
            }, e16.getShowTime());
            companion.g(e16);
        }
    }

    private void Ui() {
        if (this.Y != null && this.X != null) {
            aj();
        }
    }

    private void Vi() {
        if (this.Y != null && this.X != null) {
            cj();
        }
    }

    private void Wi(List<LocalMediaInfo> list) {
        w.a aVar = new w.a();
        aVar.e(list);
        w.f325612a.b().i(aVar);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.i
            @Override // java.lang.Runnable
            public final void run() {
                WinkCoverSelectFragment.this.Fi();
            }
        });
    }

    private void Xi(String str, final Long l3, boolean z16) {
        WinkCoverSelectViewModel winkCoverSelectViewModel;
        if ((!this.f325478u0 || z16) && !FileUtils.isEmptyFile(str) && (winkCoverSelectViewModel = this.E) != null && winkCoverSelectViewModel.e2() != null && this.E.e2().getEditDatas() != null && this.E.e2().getEditDatas().size() > 0 && this.E.e2().getEditDatas().get(0) != null) {
            final List<MediaClip> x16 = com.tencent.videocut.render.extension.e.x(str, 0.0f, null);
            this.f325477t0 = true;
            this.f325478u0 = true;
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.4
                @Override // java.lang.Runnable
                public void run() {
                    if (WinkCoverSelectFragment.this.R != null && WinkCoverSelectFragment.this.Yi(x16, l3.longValue(), true, 0, false)) {
                        WinkCoverSelectFragment.this.R.i();
                        WinkCoverSelectFragment.this.R.b(true, false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Yi(List<? extends MediaClip> list, long j3, boolean z16, int i3, boolean z17) {
        if (i3 != w.f325612a.b().getCurrentTabType()) {
            return false;
        }
        this.f325463f0.z3(list, j3, z16);
        if (z17) {
            this.R.z(true, false);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zi(Bitmap bitmap, final long j3, final boolean z16) {
        TimelineViewModelV2 timelineViewModelV2;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null && !bitmap.isRecycled() && this.f325476s0 && (timelineViewModelV2 = this.f325463f0) != null) {
            if (timelineViewModelV2.u2().size() > 0) {
                bitmap2 = com.tencent.videocut.render.extension.e.a(bitmap2, this.f325463f0.u2().get(0));
            }
            float width = bitmap2.getWidth();
            float height = bitmap2.getHeight();
            byte[] ji5 = ji(bitmap2);
            final List<MediaClipForCover> s16 = com.tencent.videocut.render.extension.e.s(width, height, (int) this.f325463f0.z2(), "id_" + j3, ji5, 0.0f, null);
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.5
                @Override // java.lang.Runnable
                public void run() {
                    WinkCoverSelectFragment.this.Yi(s16, j3, true, 0, z16);
                }
            });
        }
    }

    private void aj() {
        Mi();
        if (this.K != null && this.J != null && this.L != null) {
            w wVar = w.f325612a;
            if (wVar.b().getAlbumDraft().d() != null && !wVar.b().getAlbumDraft().d().isEmpty()) {
                this.E.f2(wVar.b().getAlbumDraft().d().get(0), new m() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.21
                    @Override // com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.m
                    public void a(final List list) {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.21.1
                            @Override // java.lang.Runnable
                            public void run() {
                                boolean z16;
                                if (list != null && WinkCoverSelectFragment.this.R != null) {
                                    WinkCoverSelectFragment.this.Yi(list, 0L, true, 1, false);
                                    Matrix lastMatrix = w.f325612a.b().getAlbumDraft().getLastMatrix();
                                    com.tencent.mobileqq.wink.pubcover.c cVar = WinkCoverSelectFragment.this.R;
                                    if (lastMatrix == null) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    cVar.z(z16, true);
                                    WinkCoverSelectFragment.this.R.x(lastMatrix);
                                    WinkCoverSelectFragment.this.R.b(true, false);
                                }
                            }
                        });
                    }
                });
            }
            Ji();
        }
    }

    private void cj() {
        TimelinePanel timelinePanel;
        final long j3 = this.f325470m0;
        if (this.f325476s0) {
            Si(j3, false);
        } else {
            String b26 = this.E.b2();
            long j16 = 0;
            if (j3 > 0) {
                j16 = j3;
            }
            Xi(b26, Long.valueOf(j16), true);
        }
        if (this.f325462e0 != null && (timelinePanel = this.f325461d0) != null) {
            timelinePanel.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.20
                @Override // java.lang.Runnable
                public void run() {
                    ms.a.c("WinkCoverSelectFragment", "smoothScrollTo updateVideoTab:" + j3);
                    WinkCoverSelectFragment.this.f325463f0.i3(j3);
                    WinkCoverSelectFragment.this.f325462e0.z(j3);
                }
            }, 200L);
        }
        Matrix lastMatrix = w.f325612a.b().getVideoDraft().getLastMatrix();
        this.R.z(false, true);
        this.R.x(lastMatrix);
        this.R.b(true, false);
        Ji();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(MetaMaterial metaMaterial, int i3, String str) {
        String i26;
        TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
        if (timelineViewModelV2 == null) {
            w53.b.c("WinkCoverSelectFragment", "addTemplateMaterial | error ! timelineViewModel is null.");
            return;
        }
        if (metaMaterial == null) {
            i26 = WinkExportUtils.v();
        } else {
            i26 = WinkEditorResourceManager.a1().i2(metaMaterial);
        }
        String str2 = i26;
        J0 = metaMaterial;
        K0 = str2;
        L0.add(metaMaterial);
        M0.add(str2);
        TimelineViewModelV2 timelineViewModelV22 = this.f325463f0;
        timelineViewModelV22.H3(new x.UpdateTemplateAction(str2, metaMaterial, false, false, true, false, timelineViewModelV22.b2(), i3, str, false), false);
    }

    private void fi(MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) this.f325463f0.C2();
        Long l3 = Long.MAX_VALUE;
        WinkStickerModel r16 = com.tencent.mobileqq.wink.editor.sticker.l.r(metaMaterial, winkVideoTavCut, this.G.getWidth(), this.G.getHeight(), 0L, l3.longValue(), false, true);
        if (r16 != null) {
            winkVideoTavCut.t(r16, false);
        }
    }

    private void gi() {
        VideoReport.setElementId(this.I, "em_xsj_save_button");
        VideoReport.setElementEndExposePolicy(this.I, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(this.I, ClickPolicy.REPORT_NONE);
        VideoReport.setElementId(this.f325467j0, WinkDaTongReportConstant.ElementId.EM_XSJ_COVER_TEMPLATE_BUTTON);
        VideoReport.setElementId(this.f325468k0, WinkDaTongReportConstant.ElementId.EM_XSJ_ADD_CHAR_BUTTON);
        VideoReport.setElementId(this.Q, WinkDaTongReportConstant.ElementId.EM_XSJ_COVER_COLOR_FILL_BUTTON);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap hi(long j3) {
        int i3;
        int i16;
        w53.b.f("WinkCoverSelectFragment", "saveVideoProgressCover: extractCoverBitmap start");
        Bitmap bitmap = null;
        try {
            AssetImageGenerator.UN_CATCH_EGL_ERROR = true;
            TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
            long j16 = j3 / 1000;
            Pair<Integer, Integer> pair = this.f325473p0;
            if (pair != null) {
                i3 = ((Integer) pair.first).intValue();
            } else {
                i3 = 720;
            }
            Pair<Integer, Integer> pair2 = this.f325473p0;
            if (pair2 != null) {
                i16 = ((Integer) pair2.second).intValue();
            } else {
                i16 = 1280;
            }
            Size size = new Size(i3, i16);
            String v3 = com.tencent.mobileqq.wink.editor.export.j.v(mi(this.C));
            WinkCoverSelectViewModel winkCoverSelectViewModel = this.E;
            bitmap = timelineViewModelV2.a2(j16, size, v3, winkCoverSelectViewModel.Q1(winkCoverSelectViewModel.e2()));
            AssetImageGenerator.UN_CATCH_EGL_ERROR = false;
            return bitmap;
        } catch (Exception e16) {
            w53.b.e("WinkCoverSelectFragment", e16);
            return bitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap ii(long j3) {
        w53.b.f("WinkCoverSelectFragment", "saveVideoProgressCover: extractCoverBitmap start");
        ms.a.f("showOrignCover", "startTime1:" + System.currentTimeMillis());
        Bitmap bitmap = null;
        try {
            AssetImageGenerator.UN_CATCH_EGL_ERROR = true;
            ms.a.f("showOrignCover", "startTime2:" + System.currentTimeMillis());
            bitmap = this.E.U1(Long.valueOf(j3 / 1000));
            ms.a.f("showOrignCover", "startTime6:" + System.currentTimeMillis());
            AssetImageGenerator.UN_CATCH_EGL_ERROR = false;
            return bitmap;
        } catch (Exception e16) {
            w53.b.e("WinkCoverSelectFragment", e16);
            return bitmap;
        }
    }

    private void initParamsFromIntent() {
        if (getActivity().getIntent().getExtras() != null) {
            this.C = getActivity().getIntent().getStringExtra(QQWinkConstants.MISSION_ID);
            w53.b.a("WinkCoverSelectFragment", "initParamsFromIntent, missionId = " + this.C);
            this.D = getActivity().getIntent().getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
        }
    }

    private byte[] ji(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            if (!bitmap.isRecycled()) {
                bitmap.recycle();
            }
        } catch (Exception e16) {
            w53.b.a("WinkCoverSelectFragment", "cbitmap.recycle() " + e16.toString());
        }
        return byteArray;
    }

    private String li() {
        com.tencent.mobileqq.wink.pubcover.c cVar = this.R;
        if (cVar != null) {
            return cVar.n();
        }
        return "";
    }

    private String ni(List<String> list) {
        if (list != null && list.size() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int i3 = 0;
            while (true) {
                if (i3 >= list.size()) {
                    break;
                }
                if (list.get(i3) != null) {
                    if (i3 == list.size() - 1) {
                        stringBuffer.append(list.get(i3));
                        break;
                    }
                    stringBuffer.append(list.get(i3));
                    stringBuffer.append(",");
                }
                i3++;
            }
            return stringBuffer.toString();
        }
        return "";
    }

    private void pi(DialogInterface.OnClickListener onClickListener) {
        TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
        if (timelineViewModelV2 == null) {
            return;
        }
        Map<String, WinkStickerModel> m3 = ((WinkVideoTavCut) timelineViewModelV2.C2()).m();
        if (m3 != null) {
            w.f325612a.b().n(new ArrayList<>(m3.values()));
        }
        w wVar = w.f325612a;
        if (wVar.b().getCurrentTabType() == 0) {
            wVar.b().getVideoDraft().f(this.f325463f0.getCurSeekTimeUs());
        }
        if (this.f325463f0.C2() != null && wVar.e()) {
            DialogUtil.createCustomDialog(getContext(), 230).setTitle(getContext().getString(R.string.f216185xm)).setNegativeButton(getContext().getString(R.string.cancel), new f()).setPositiveButton(getContext().getString(R.string.f216195xn), new e(onClickListener)).show();
        } else {
            wVar.f();
            onClickListener.onClick(null, 0);
        }
    }

    private void qi() {
        TimelinePanelViewController timelinePanelViewController = new TimelinePanelViewController();
        this.f325462e0 = timelinePanelViewController;
        timelinePanelViewController.x(true);
        this.f325465h0 = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l(this.f325464g0);
        this.f325466i0 = new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.d();
        this.f325462e0.h(this.f325465h0);
        this.f325462e0.h(this.f325466i0);
    }

    private void registerDaTongReportPageId(View view) {
        String tag;
        if (view == null) {
            QLog.i("WinkCoverSelectFragment", 1, "reportDaTongRegister mContentView == null , subPage: " + getTAG());
            return;
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        if (!TextUtils.isEmpty(getPageId())) {
            tag = getPageId();
        } else {
            tag = getTAG();
        }
        VideoReport.setPageId(view, tag);
        VideoReport.setPageParams(view, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        QLog.i("WinkCoverSelectFragment", 1, "reportDaTongRegister subPage: " + getTAG() + ", pageId: " + tag);
    }

    private void ri() {
        DragDropScrollView dragDropScrollView = new DragDropScrollView(getContext());
        dragDropScrollView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f325466i0.g(dragDropScrollView);
    }

    @RequiresApi(api = 17)
    private void si() {
        long j3;
        WinkCoverSelectViewModel winkCoverSelectViewModel = this.E;
        if (winkCoverSelectViewModel != null && winkCoverSelectViewModel.e2() != null) {
            if (this.F == null) {
                com.tencent.mobileqq.wink.pubcover.template.l lVar = (com.tencent.mobileqq.wink.pubcover.template.l) getViewModel(com.tencent.mobileqq.wink.pubcover.template.l.class);
                this.F = lVar;
                lVar.M1().observe(this, new l());
            }
            if (this.f325463f0 == null) {
                this.f325463f0 = (TimelineViewModelV2) getViewModel(TimelineViewModelV2.class);
                boolean z16 = false;
                this.f325476s0 = false;
                if (this.E.k2()) {
                    this.f325478u0 = true;
                    w53.b.f("WinkCoverSelectFragment", "\u5f53\u524d\u89c6\u9891\u5df2\u7ecf\u5bfc\u51fa\u6210\u529f\u3002");
                } else {
                    this.f325479v0 = true;
                    this.f325476s0 = true;
                }
                final long j16 = this.f325470m0;
                if (oi() != null && oi().getPreferredCoverTime() > 0 && this.f325470m0 < 0) {
                    j16 = oi().getPreferredCoverTime();
                }
                if (this.f325476s0) {
                    this.E.h2(new WinkCoverSelectViewModel.b() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.10

                        /* renamed from: a, reason: collision with root package name */
                        boolean f325484a = false;

                        @Override // com.tencent.mobileqq.wink.pubcover.WinkCoverSelectViewModel.b
                        public void a(LAKRenderModel lAKRenderModel, String str, List<BaseEffectNode> list, long j17, List<MediaClip> list2) {
                            WinkCoverSelectFragment.this.f325464g0.g(lAKRenderModel, j17, str, list, list2);
                            if (this.f325484a) {
                                return;
                            }
                            this.f325484a = true;
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.10.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    boolean z17;
                                    AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                                    WinkCoverSelectFragment winkCoverSelectFragment = WinkCoverSelectFragment.this;
                                    long j18 = j16;
                                    if (j18 <= 0) {
                                        j18 = 0;
                                    }
                                    if (winkCoverSelectFragment.f325470m0 < 0) {
                                        z17 = true;
                                    } else {
                                        z17 = false;
                                    }
                                    winkCoverSelectFragment.Si(j18, z17);
                                }
                            });
                        }
                    });
                }
                dr.WinkTavCutParams W1 = this.E.W1(this.G.getWidth(), this.G.getHeight(), this.D0);
                this.D0 = false;
                HashMap<String, Object> hashMap = new HashMap<>();
                w wVar = w.f325612a;
                if (wVar.b().getTemplateMetaMaterial() != null) {
                    z16 = true;
                }
                hashMap.put("need_recovery_template_from_draft", Boolean.valueOf(z16));
                TimelineViewModelV2 timelineViewModelV2 = this.f325463f0;
                FrameLayout frameLayout = this.G;
                IPlayer.PlayerListener playerListener = this.C0;
                ISessionListener iSessionListener = this.E0;
                if (j16 > 0) {
                    j3 = j16;
                } else {
                    j3 = 0;
                }
                timelineViewModelV2.Q2(this, frameLayout, W1, playerListener, iSessionListener, false, true, true, j3, hashMap);
                wVar.b().getVideoDraft().e(this.f325463f0, this.f325476s0);
                if (this.f325463f0.C2() instanceof WinkVideoTavCut) {
                    WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) this.f325463f0.C2();
                    winkVideoTavCut.o(0.0f);
                    winkVideoTavCut.F(this.B0);
                    winkVideoTavCut.m0(new ICutStatusCallback() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.11
                        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
                        public void onLightEntityReload(@org.jetbrains.annotations.Nullable Entity entity) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.11.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    WinkCoverSelectFragment.this.Gi();
                                }
                            });
                        }

                        @Override // com.tencent.tavcut.core.session.ICutStatusCallback
                        public void onRenderChainReady() {
                        }
                    });
                }
                this.Z = new s(this.N, this.P, this.f325463f0.C2());
                this.f325463f0.C2().C(this.Z.m());
                this.Z.s(new a());
                com.tencent.mobileqq.wink.pubcover.c cVar = new com.tencent.mobileqq.wink.pubcover.c(this.f325463f0, this.P, wVar.c(), new b());
                this.R = cVar;
                cVar.C(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.14
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WinkCoverSelectFragment.this.N != null) {
                            WinkCoverSelectFragment.this.N.w();
                        }
                    }
                });
            }
            this.f325463f0.A2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkCoverSelectFragment.this.xi((Long) obj);
                }
            });
            this.f325463f0.B2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.n
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkCoverSelectFragment.this.yi((VideoTrackData) obj);
                }
            });
            this.f325463f0.m2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.pubcover.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkCoverSelectFragment.this.zi((Long) obj);
                }
            });
            Li();
            Ti();
        }
    }

    @RequiresApi(api = 21)
    private void ti() {
        TimelinePanelViewController timelinePanelViewController = this.f325462e0;
        if (timelinePanelViewController != null) {
            timelinePanelViewController.j(this.f325461d0);
            VideoTrackConfig videoTrackConfig = new VideoTrackConfig();
            VideoTrackConfig e16 = videoTrackConfig.e(videoTrackConfig.getThumbWidth(), videoTrackConfig.getThumbHeight(), 35.6f, 0.0f, videoTrackConfig.getTransitionViewWidth(), videoTrackConfig.getTransitionViewHeight(), false, false, false);
            LayoutConfig layoutConfig = new LayoutConfig();
            this.f325462e0.w(new CommonConfig(new ScrollConfig(), layoutConfig.d(com.tencent.videocut.utils.o.g() / 2, 0.0f, layoutConfig.getCourseWidth(), layoutConfig.getCourseHeight(), layoutConfig.getCourseElevation(), Color.parseColor("#00B4FF")), e16, new TimeBarConfig()));
            this.f325462e0.r();
            this.f325462e0.getPanelEventHandler().b(this, new Function1() { // from class: com.tencent.mobileqq.wink.pubcover.k
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Boolean Ai;
                    Ai = WinkCoverSelectFragment.Ai((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g) obj);
                    return Ai;
                }
            });
        }
    }

    private void ui() {
        VideoTrackContainerView videoTrackContainerView = new VideoTrackContainerView(getContext());
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, eVar.a(56.0f));
        layoutParams.topMargin = eVar.a(6.0f);
        layoutParams.bottomMargin = eVar.a(6.0f);
        videoTrackContainerView.setLayoutParams(layoutParams);
        this.f325465h0.x(videoTrackContainerView);
        videoTrackContainerView.setItemOnLongClickListener(new com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a() { // from class: com.tencent.mobileqq.wink.pubcover.l
            @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.a
            public final void a(String str, Point point) {
                WinkCoverSelectFragment.Bi(str, point);
            }
        });
    }

    private void wi(Context context) {
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.j(1);
        aVar.l(false);
        com.tencent.mobileqq.wink.picker.g.f324860a.h(context, 9, WinkContext.INSTANCE.d().getTraceId(), aVar.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void xi(Long l3) {
        this.f325462e0.C(l3.longValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void yi(VideoTrackData videoTrackData) {
        this.f325465h0.K(videoTrackData.d(), videoTrackData.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void zi(Long l3) {
        this.f325462e0.z(l3.longValue());
    }

    @Override // com.tencent.mobileqq.wink.pubcover.e.a
    public void I3(int i3, String str) {
        this.f325471n0 = i3;
        this.f325472o0 = str;
        WinkVideoTavCut winkVideoTavCut = (WinkVideoTavCut) this.f325463f0.C2();
        if (i3 == 0) {
            winkVideoTavCut.q3(0, str);
        } else {
            winkVideoTavCut.q3(1, str);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.h
    public void Jc(@NotNull com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.g gVar) {
        if (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) {
            com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i iVar = (com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.i) gVar;
            if (!iVar.getIsOutCalled()) {
                return;
            }
            this.Z.q();
            long j3 = 0;
            this.f325463f0.o3(0L, oi().getDuration());
            this.f325463f0.a3(iVar.getData(), iVar.getIsOutCalled());
            WinkCoverSelectViewModel winkCoverSelectViewModel = this.E;
            if (winkCoverSelectViewModel != null) {
                j3 = winkCoverSelectViewModel.e2().getDuration();
            }
            long min = Math.min(iVar.getData(), j3);
            WinkCoverSelectViewModel winkCoverSelectViewModel2 = this.E;
            if (winkCoverSelectViewModel2 != null && winkCoverSelectViewModel2.k2() && !this.f325478u0) {
                this.f325476s0 = false;
                Xi(this.E.b2(), Long.valueOf(min), false);
                this.E.l2();
            }
            if (this.f325479v0 && this.f325476s0) {
                Si(min, false);
                return;
            }
            return;
        }
        if (!(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.b) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.o) && !(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j)) {
            if (!(gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.a) && (gVar instanceof com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d)) {
                this.f325463f0.L2((com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d) gVar, isHidden());
                return;
            }
            return;
        }
        this.f325463f0.J2();
    }

    @Override // com.tencent.mobileqq.wink.pubcover.e.a
    public void Pa() {
        this.Q.e();
    }

    public void Si(long j3, boolean z16) {
        boolean z17 = true;
        this.f325477t0 = true;
        w53.b.f("WinkCoverSelectFragment", "\u66f4\u65b0cover will\uff1a" + j3);
        boolean z18 = this.f325483z0.f325506e;
        ThreadManager.getFileThreadHandler().removeCallbacks(this.f325483z0);
        this.f325483z0.a(j3);
        GetCoverRunnable getCoverRunnable = this.f325483z0;
        if (!z16 && !z18) {
            z17 = false;
        }
        getCoverRunnable.b(z17);
        ThreadManager.getFileThreadHandler().post(this.f325483z0);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        WinkCoverTemplateMenuPart winkCoverTemplateMenuPart = new WinkCoverTemplateMenuPart();
        this.f325458a0 = winkCoverTemplateMenuPart;
        arrayList.add(winkCoverTemplateMenuPart);
        WinkCoverTextMenuPart winkCoverTextMenuPart = new WinkCoverTextMenuPart();
        this.f325459b0 = winkCoverTextMenuPart;
        arrayList.add(winkCoverTextMenuPart);
        com.tencent.mobileqq.wink.pubcover.text.a aVar = new com.tencent.mobileqq.wink.pubcover.text.a();
        this.f325460c0 = aVar;
        arrayList.add(aVar);
        return arrayList;
    }

    public void bj(List<WinkStickerModel> list) {
        this.f325463f0.G3(list);
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        if (i3 == 4) {
            pi(new d());
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    public void ei(MetaMaterial metaMaterial) {
        long min = Math.min(this.f325463f0.getCurSeekTimeUs(), this.E.e2().getDuration());
        if (!this.f325478u0 && this.f325476s0) {
            this.f325479v0 = true;
            this.f325481x0 = metaMaterial;
            long j3 = this.f325470m0;
            if (j3 >= 0) {
                min = j3;
            }
            Si(min, false);
        }
        fi(metaMaterial);
    }

    @Override // com.tencent.mobileqq.wink.pubcover.WinkCoverExportVideoReceiver.a
    public void g9() {
        w53.b.f("WinkCoverSelectFragment", "\u6536\u5230\u89c6\u9891\u5bfc\u51fa\u6210\u529f\u6d88\u606f\u3002");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i5_;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkCoverSelectFragment";
    }

    protected String getMediaPath() {
        String str;
        Bundle arguments = getArguments();
        if (getActivity().getIntent().getExtras() != null) {
            str = getActivity().getIntent().getStringExtra(AEEditorConstants.KEY_VIDEO_MEDIA_PATH);
        } else {
            str = "";
        }
        if (TextUtils.isEmpty(str) && arguments != null && arguments.containsKey(AEEditorConstants.KEY_VIDEO_MEDIA_PATH)) {
            str = arguments.getString(AEEditorConstants.KEY_VIDEO_MEDIA_PATH);
        }
        ms.a.f("WinkCoverSelectFragment", "getMediaPath, mediaPath = " + str);
        return str;
    }

    public String getPageId() {
        return WinkDaTongReportConstant.PageId.PG_XSJ_PUBLISH_COVER_PAGE;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!uq3.c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Nullable
    public ViewGroup ki() {
        return this.G;
    }

    protected String mi(String str) {
        WinkEditDataWrapper b16 = com.tencent.mobileqq.wink.editor.draft.a.b(str);
        if (b16 != null) {
            return b16.getTemplateFilePath();
        }
        return null;
    }

    protected WinkEditDataWrapper oi() {
        WinkCoverSelectViewModel winkCoverSelectViewModel = this.E;
        if (winkCoverSelectViewModel != null) {
            return winkCoverSelectViewModel.e2();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if (i3 == 9 && i16 == -1) {
            final ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(QQWinkConstants.INPUT_MEDIA);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.g
                @Override // java.lang.Runnable
                public final void run() {
                    WinkCoverSelectFragment.this.Di(parcelableArrayListExtra);
                }
            }, 64, null, true);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@android.support.annotation.NonNull Context context) {
        super.onAttach(context);
        WinkEditorResourceManager.a1().N2();
        WinkExportUtils.R();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        pi(new c());
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.f1064468q) {
            if (!FastClickUtils.isFastDoubleClick("WinkCoverSelectFragment:cancel", H0)) {
                pi(new g());
            }
        } else if (id5 == R.id.f107026_a) {
            com.tencent.mobileqq.wink.pubcover.c cVar = this.R;
            if (cVar != null && cVar.getIsChangeEnd() && !FastClickUtils.isFastDoubleClick("WinkCoverSelectFragment:save", H0)) {
                Pi();
                Ki();
            }
        } else {
            int i3 = 0;
            if (id5 != R.id.f111066k8 && id5 != R.id.f111106kb) {
                if (id5 == R.id.f1185474f) {
                    WinkCoverTextMenuPart winkCoverTextMenuPart = this.f325459b0;
                    if (winkCoverTextMenuPart != null) {
                        winkCoverTextMenuPart.Q9(null);
                    }
                    this.Q.e();
                } else if (id5 == R.id.f1186574q) {
                    com.tencent.mobileqq.wink.editor.d dVar = this.f325458a0;
                    if (dVar != null) {
                        dVar.Q9(null);
                    }
                } else if (id5 == R.id.f918756c) {
                    w wVar = w.f325612a;
                    if (wVar.b().getCurrentTabType() != 0 && this.R != null) {
                        wVar.b().j(0);
                        wVar.b().getAlbumDraft().b(this.R.m());
                        Vi();
                    }
                } else if (id5 == R.id.f9178564) {
                    w wVar2 = w.f325612a;
                    if (wVar2.b().getCurrentTabType() != 1 && this.R != null) {
                        wVar2.b().j(1);
                        wVar2.b().getVideoDraft().b(this.R.m());
                        this.f325470m0 = this.f325463f0.getCurSeekTimeUs();
                        wVar2.b().getVideoDraft().f(this.f325470m0);
                        Ui();
                    }
                }
            } else {
                Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                if (w.f325612a.b().getAlbumDraft().d() != null) {
                    i3 = 1;
                }
                buildElementParams.put(WinkDaTongReportConstant.ElementParamValue.XSJ_IS_EXIST_PIC, Integer.valueOf(i3));
                buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementId.EM_XSJ_UPLOAD_COVER);
                buildElementParams.put("xsj_custom_pgid", getPageId());
                VideoReport.reportEvent("ev_xsj_abnormal_clck", null, buildElementParams);
                wi(view.getContext());
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        CommonConfig commonConfig = this.f325462e0.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String();
        LayoutConfig layoutConfig = commonConfig.getLayoutConfig();
        this.f325462e0.w(commonConfig.a(commonConfig.getScrollConfig(), layoutConfig.d(com.tencent.videocut.utils.o.g() / 2, layoutConfig.getCourseTopMargin(), layoutConfig.j(), layoutConfig.h(), layoutConfig.g(), layoutConfig.getCourseColor()), commonConfig.getVideoTrackConfig(), commonConfig.getTimeBarConfig()));
        VideoTrackData value = this.f325463f0.B2().getValue();
        if (value != null) {
            this.f325465h0.y();
            this.f325465h0.K(value.d(), value.c());
        }
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initParamsFromIntent();
        w wVar = w.f325612a;
        wVar.d();
        this.f325470m0 = wVar.b().getVideoDraft().getCoverTimeProgress();
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        v vVar = this.f325464g0;
        if (vVar != null) {
            vVar.f();
        }
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.l lVar = this.f325465h0;
        if (lVar != null) {
            lVar.F();
        }
        FileUtils.delete(this.f325475r0, false);
        WinkCoverSelectViewModel winkCoverSelectViewModel = this.E;
        if (winkCoverSelectViewModel != null) {
            winkCoverSelectViewModel.l2();
        }
        this.A0.c(getContext());
        s sVar = this.Z;
        if (sVar != null) {
            sVar.r();
        }
        super.onDestroy();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        WinkVideoTavCut winkVideoTavCut;
        TimelineViewModelV2 timelineViewModelV2;
        super.onResume();
        if (Build.VERSION.SDK_INT <= 24 && (timelineViewModelV2 = this.f325463f0) != null && timelineViewModelV2.C2() != null) {
            this.f325463f0.C2().Z();
            return;
        }
        TimelineViewModelV2 timelineViewModelV22 = this.f325463f0;
        if (timelineViewModelV22 != null && (winkVideoTavCut = (WinkVideoTavCut) timelineViewModelV22.C2()) != null && winkVideoTavCut.getCurrentPlayer() != null) {
            winkVideoTavCut.getCurrentPlayer().requestRender();
        }
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    @RequiresApi(api = 21)
    public void onViewCreated(@android.support.annotation.NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        qi();
        this.G = (FrameLayout) view.findViewById(R.id.f11736719);
        this.H = (ImageView) view.findViewById(R.id.f1064468q);
        this.I = (TextView) view.findViewById(R.id.f107026_a);
        this.J = (RelativeLayout) view.findViewById(R.id.f111066k8);
        this.K = (RelativeLayout) view.findViewById(R.id.f111106kb);
        this.L = (RoundCornerImageView) view.findViewById(R.id.f107096_h);
        this.f325461d0 = (TimelinePanel) view.findViewById(R.id.f1189275g);
        this.f325467j0 = (LinearLayout) view.findViewById(R.id.f1186574q);
        this.f325468k0 = view.findViewById(R.id.f1185474f);
        this.N = (WinkStickerFrameLayout) view.findViewById(R.id.f11735718);
        this.P = (BorderCoverView) view.findViewById(R.id.f11733716);
        this.M = view.findViewById(R.id.f164923ua1);
        this.Q = (WinkCoverBgSelectListView) view.findViewById(R.id.f11732715);
        this.f325469l0 = view.findViewById(R.id.f113306q_);
        this.S = (TextView) view.findViewById(R.id.f918756c);
        this.T = (TextView) view.findViewById(R.id.f9178564);
        this.V = view.findViewById(R.id.f918956e);
        this.W = view.findViewById(R.id.f9179565);
        this.X = view.findViewById(R.id.f918856d);
        this.Y = view.findViewById(R.id.f111096ka);
        this.U = (TextView) view.findViewById(R.id.f111116kc);
        if (QQTheme.isNowThemeIsNight()) {
            this.V.setBackgroundResource(R.drawable.f160591jk1);
            this.W.setBackgroundResource(R.drawable.f160591jk1);
        }
        gi();
        this.H.setOnClickListener(this);
        this.I.setOnClickListener(this);
        this.J.setOnClickListener(this);
        this.f325467j0.setOnClickListener(this);
        this.f325468k0.setOnClickListener(this);
        this.T.setOnClickListener(this);
        this.S.setOnClickListener(this);
        this.Q.setListener(this);
        this.K.setOnClickListener(this);
        if (this.E == null) {
            this.E = (WinkCoverSelectViewModel) getViewModel(WinkCoverSelectViewModel.class);
        }
        this.E.j2(this.C, getActivity());
        ArrayList<LocalMediaInfo> arrayList = this.D;
        if (arrayList != null && arrayList.size() > 0) {
            this.E.m2(this.D.get(0));
        }
        this.f325473p0 = WinkExtractCoverViewModel.r2(this.E.e2());
        this.G.getViewTreeObserver().addOnGlobalLayoutListener(this.F0);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.WinkCoverSelectFragment.7
            @Override // java.lang.Runnable
            public void run() {
                if (WinkCoverSelectFragment.this.f325469l0 != null) {
                    WinkCoverSelectFragment.this.f325469l0.setVisibility(8);
                }
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(View view, Bundle bundle) {
        super.onViewCreatedBeforePartInit(view, bundle);
        if (ImmersiveUtils.isSupporImmersive() == 1 && getActivity() != null) {
            ImmersiveUtils.setStatusTextColor(isUseDarkTextStatusBar(), getActivity().getWindow());
        }
        registerDaTongReportPageId(view);
        this.A0.b(getContext());
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), getContext().getColor(R.color.qui_common_bg_bottom_light));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        this.D0 = true;
    }

    @RequiresApi(api = 21)
    protected void vi() {
        ti();
        ui();
        ri();
        si();
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class j implements ISessionListener {
        j() {
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull LAKRenderModel lAKRenderModel, long j3, long j16) {
            if (WinkCoverSelectFragment.this.R != null) {
                WinkCoverSelectFragment.this.R.i();
            }
            if (WinkCoverSelectFragment.this.R != null && WinkCoverSelectFragment.this.f325463f0 != null && (WinkCoverSelectFragment.this.f325463f0.C2() instanceof WinkVideoTavCut)) {
                WinkCoverSelectFragment.this.R.b(true, false);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class k implements ISessionListener {
        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(LAKRenderModel lAKRenderModel) {
            if (WinkCoverSelectFragment.this.E != null && WinkCoverSelectFragment.this.E.a2() != null) {
                LAKRenderModel a26 = WinkCoverSelectFragment.this.E.a2();
                WinkCoverSelectFragment.this.f325463f0.E3(a26.getTimeLines(), com.tencent.videocut.render.extension.e.E(a26, new ArrayList()));
                return;
            }
            WinkCoverSelectFragment.this.f325463f0.D3(lAKRenderModel.getTimeLines());
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel lAKRenderModel, long j3, long j16) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.pubcover.r
                @Override // java.lang.Runnable
                public final void run() {
                    WinkCoverSelectFragment.k.this.b(lAKRenderModel);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Bi(String str, Point point) {
    }
}
