package com.tencent.mobileqq.guild.media.listen.presenter;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.aio.GuildMediaAioViewModel;
import com.tencent.mobileqq.guild.media.aio.b;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.logic.ab;
import com.tencent.mobileqq.guild.media.core.notify.ad;
import com.tencent.mobileqq.guild.media.core.notify.o;
import com.tencent.mobileqq.guild.media.core.notify.t;
import com.tencent.mobileqq.guild.media.core.p;
import com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter;
import com.tencent.mobileqq.guild.media.listen.widget.ListenWidget;
import com.tencent.mobileqq.guild.media.listen.widget.MediaListenOrderDialogFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\b*\u0001:\u0018\u0000 \u00192\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010/\u001a\u00020-\u00a2\u0006\u0004\b=\u0010>B\u0019\b\u0016\u0012\u0006\u0010/\u001a\u00020-\u0012\u0006\u0010?\u001a\u000200\u00a2\u0006\u0004\b=\u0010@J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\t\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0002J&\u0010\u0010\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0002H\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\rH\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\rH\u0016J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\rH\u0016J\u0018\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0016J\u0010\u0010)\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\rH\u0016J\b\u0010*\u001a\u00020\u0002H\u0016J\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010,\u001a\u00020\u0002R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010.R\u0018\u00102\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00101R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u00104R\u0016\u00107\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u00106R\u0016\u00109\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00108R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010;\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter;", "Lcom/tencent/mobileqq/guild/media/listen/presenter/a;", "", "D", "", "curPtsMS", "B", "Lkotlin/Function0;", NodeProps.ON_CLICK, "v", "", "", "colorList", "", "index", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "w", "J", "", HippyTKDListViewAdapter.X, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "u", "K", "a", "durationMS", "g", "e", "from", "d", "_needShow", "i", WidgetCacheConstellationData.NUM, "b", ViewStickEventHelper.IS_SHOW, "f", "res", UIJsPlugin.EVENT_SHOW_TOAST, "context", "btnStr", "j", "operate", tl.h.F, "c", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;", "listenWidget", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/mobileqq/guild/media/listen/presenter/i;", "Lcom/tencent/mobileqq/guild/media/listen/presenter/i;", "musicInfo", "I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, "Z", "needShow", "com/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter$b", "Lcom/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter$b;", "leakDialogCloseEvent", "<init>", "(Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;)V", "_fragment", "(Lcom/tencent/mobileqq/guild/media/listen/widget/ListenWidget;Landroidx/fragment/app/Fragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class ListenWidgetPresenter implements a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ListenWidget listenWidget;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Fragment fragment;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private MusicInfo musicInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int playState;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needShow;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b leakDialogCloseEvent;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/listen/presenter/ListenWidgetPresenter$b", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/t;", "event", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements o<t> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ListenWidgetPresenter this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.K();
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull t event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!ListenWidgetPresenter.this.listenWidget.m()) {
                return;
            }
            ListenWidgetPresenter.this.listenWidget.e();
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final ListenWidgetPresenter listenWidgetPresenter = ListenWidgetPresenter.this;
            uIHandlerV2.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.h
                @Override // java.lang.Runnable
                public final void run() {
                    ListenWidgetPresenter.b.c(ListenWidgetPresenter.this);
                }
            }, 500L);
        }
    }

    public ListenWidgetPresenter(@NotNull ListenWidget listenWidget) {
        Intrinsics.checkNotNullParameter(listenWidget, "listenWidget");
        this.listenWidget = listenWidget;
        this.musicInfo = new MusicInfo(null, null, null, 0, 0, 0, 63, null);
        this.needShow = true;
        this.leakDialogCloseEvent = new b();
        D();
    }

    private final void A() {
        QLog.i("QGMC.MediaListen.ListenWidgetPresenter", 1, "[prefetchPlayList] start");
        p.f228716a.d();
    }

    private final void B(long curPtsMS) {
        String str;
        if (!this.musicInfo.d().isEmpty()) {
            str = "";
            for (com.tencent.lyric.data.e eVar : this.musicInfo.d()) {
                if (curPtsMS >= eVar.f147071b) {
                    str = eVar.f147070a;
                    Intrinsics.checkNotNullExpressionValue(str, "sentence.mText");
                }
            }
        } else {
            str = "\u6682\u65e0\u6b4c\u8bcd";
        }
        this.listenWidget.setLyricText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(ListenWidgetPresenter this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.listenWidget.getQuietMusic().setVisibility(i3);
    }

    private final void D() {
        this.listenWidget.getOrderLl().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ListenWidgetPresenter.E(ListenWidgetPresenter.this, view);
            }
        });
        this.listenWidget.getPauseOrResumeBtnLl().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ListenWidgetPresenter.F(ListenWidgetPresenter.this, view);
            }
        });
        this.listenWidget.getNextPlayBtnLl().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ListenWidgetPresenter.G(ListenWidgetPresenter.this, view);
            }
        });
        this.listenWidget.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ListenWidgetPresenter.H(ListenWidgetPresenter.this, view);
            }
        });
        if (this.fragment != null) {
            com.tencent.mobileqq.guild.media.core.notify.p d16 = j.d();
            Fragment fragment = this.fragment;
            Intrinsics.checkNotNull(fragment);
            LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "fragment!!.viewLifecycleOwner");
            d16.k0(viewLifecycleOwner, t.class, this.leakDialogCloseEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final ListenWidgetPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("clck", view, this$0.listenWidget.i());
        this$0.v(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter$setUiClickListener$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                ListenWidgetPresenter.this.J();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final ListenWidgetPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter$setUiClickListener$2$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                int i3;
                int i16;
                i3 = ListenWidgetPresenter.this.playState;
                if (i3 == 1) {
                    ListenWidgetPresenter.this.listenWidget.getPauseOrResumeBtn().setImageResource(R.drawable.guild_listen_resume);
                    j.a().M0().S0();
                    return;
                }
                i16 = ListenWidgetPresenter.this.playState;
                if (i16 == 2) {
                    ListenWidgetPresenter.this.listenWidget.getPauseOrResumeBtn().setImageResource(R.drawable.guild_listen_pause);
                    ab.f1(j.a().M0(), false, 1, null);
                }
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ListenWidgetPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.v(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter$setUiClickListener$3$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                j.a().M0().T0();
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(final ListenWidgetPresenter this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        VideoReport.reportEvent("clck", view, this$0.listenWidget.i());
        this$0.v(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter$setUiClickListener$4$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                final ListenWidgetPresenter listenWidgetPresenter = ListenWidgetPresenter.this;
                listenWidgetPresenter.v(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.ListenWidgetPresenter$setUiClickListener$4$1.1
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
                        ListenWidgetPresenter.this.J();
                    }
                });
            }
        });
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J() {
        FragmentActivity fragmentActivity;
        QLog.i("QGMC.MediaListen.ListenWidgetPresenter", 1, "[showSongListDialog] start");
        A();
        if (x()) {
            return;
        }
        MediaListenOrderDialogFragment b16 = MediaListenOrderDialogFragment.INSTANCE.b();
        Fragment fragment = this.fragment;
        if (fragment != null) {
            fragmentActivity = fragment.requireActivity();
        } else {
            fragmentActivity = null;
        }
        Intrinsics.checkNotNull(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragment?.requireActivit\u2026!!.supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(b16, supportFragmentManager, "QGMC.MediaListen.MediaListenOrderDialogFragment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(Function0<Unit> onClick) {
        if (QQGuildUIUtil.v()) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(this.listenWidget.getContext(), "\u7f51\u7edc\u72b6\u6001\u5dee\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
        } else {
            onClick.invoke();
        }
    }

    private final int w(List<String> colorList, int index, String defaultColor) {
        int parseColor;
        boolean z16;
        try {
            if (colorList.size() > index) {
                if (colorList.get(index).length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    parseColor = Color.parseColor(colorList.get(index));
                    return parseColor;
                }
            }
            parseColor = Color.parseColor(defaultColor);
            return parseColor;
        } catch (Exception unused) {
            return Color.parseColor(defaultColor);
        }
    }

    private final boolean x() {
        FragmentActivity fragmentActivity;
        boolean z16;
        boolean z17;
        FragmentActivity activity;
        FragmentActivity activity2;
        Fragment fragment = this.fragment;
        if (fragment != null) {
            fragmentActivity = fragment.getActivity();
        } else {
            fragmentActivity = null;
        }
        if (fragmentActivity == null) {
            return true;
        }
        Fragment fragment2 = this.fragment;
        if (fragment2 != null && (activity2 = fragment2.getActivity()) != null && activity2.isFinishing()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        Fragment fragment3 = this.fragment;
        if (fragment3 != null && (activity = fragment3.getActivity()) != null && activity.isDestroyed()) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0058, code lost:
    
        if (r1 != 5) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x01e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K() {
        IGProPlayNodeExtInfo playNodeExInfo;
        IGProPlayInfo I = j.c().I();
        if (I != null && (playNodeExInfo = I.getPlayNodeExInfo()) != null) {
            int playState = playNodeExInfo.getPlayState();
            this.playState = playState;
            QLog.d("QGMC.MediaListen.ListenWidgetPresenter", 1, "updateUI " + playState);
            boolean z16 = this.needShow;
            if (!z16) {
                QLog.d("QGMC.MediaListen.ListenWidgetPresenter", 1, "updateUI needShow " + z16);
                return;
            }
            int i3 = this.playState;
            if (i3 != 0) {
                if (i3 == 1 || i3 == 2) {
                    this.listenWidget.setVisibility(0);
                    IGProPlayInfo I2 = j.c().I();
                    Intrinsics.checkNotNull(I2);
                    IGProSongInfo O = j.c().O();
                    Intrinsics.checkNotNull(O);
                    List<com.tencent.lyric.data.e> arrayList = new ArrayList<>();
                    if (!StringUtil.isEmpty(O.getLyrics()) && O.getIsEnable() && com.tencent.lyric.util.c.a(O.getLyrics(), false) != null) {
                        arrayList = com.tencent.lyric.util.c.a(O.getLyrics(), false).o();
                        Intrinsics.checkNotNullExpressionValue(arrayList, "parseTextToLyric(songInf\u2026rics, false).sentenceList");
                    }
                    List<com.tencent.lyric.data.e> list = arrayList;
                    if (I2.getPlayNodeInfo().getBackgroundColorList().size() > 1) {
                        String str = I2.getPlayNodeInfo().getPlaySourceName() + " - " + I2.getPlayNodeInfo().getSingerList();
                        String playSourcePic = I2.getPlayNodeInfo().getPlaySourcePic();
                        Intrinsics.checkNotNullExpressionValue(playSourcePic, "playInfo.playNodeInfo.playSourcePic");
                        int J = j.c().J();
                        ArrayList<String> backgroundColorList = I2.getPlayNodeInfo().getBackgroundColorList();
                        Intrinsics.checkNotNullExpressionValue(backgroundColorList, "playInfo.playNodeInfo.backgroundColorList");
                        int w3 = w(backgroundColorList, 0, "#DEC5FF");
                        ArrayList<String> backgroundColorList2 = I2.getPlayNodeInfo().getBackgroundColorList();
                        Intrinsics.checkNotNullExpressionValue(backgroundColorList2, "playInfo.playNodeInfo.backgroundColorList");
                        this.musicInfo = new MusicInfo(str, playSourcePic, list, J, w3, w(backgroundColorList2, 1, "#907DFF"));
                    } else {
                        String str2 = I2.getPlayNodeInfo().getPlaySourceName() + " - " + I2.getPlayNodeInfo().getSingerList();
                        String playSourcePic2 = I2.getPlayNodeInfo().getPlaySourcePic();
                        Intrinsics.checkNotNullExpressionValue(playSourcePic2, "playInfo.playNodeInfo.playSourcePic");
                        this.musicInfo = new MusicInfo(str2, playSourcePic2, list, j.c().J(), 0, 0, 48, null);
                    }
                    this.listenWidget.setExInfo(this.musicInfo);
                    if (this.playState == 1) {
                        this.listenWidget.getPauseOrResumeBtn().setImageResource(R.drawable.guild_listen_pause);
                        a();
                    } else {
                        if (I2.getPlayNodeExInfo().getPauseDuration() != 0) {
                            QLog.d("QGMC.MediaListen.ListenWidgetPresenter", 1, "pauseDuration " + I2.getPlayNodeExInfo().getPauseDuration());
                            g(((long) I2.getPlayNodeExInfo().getPauseDuration()) * 1000, ((long) I2.getPlayNodeInfo().getPlaySourceDuration()) * 1000);
                        }
                        this.listenWidget.getPauseOrResumeBtn().setImageResource(R.drawable.guild_listen_resume);
                        e();
                    }
                }
                if (this.listenWidget.getVisibility() != 8) {
                    return;
                }
                String str3 = j.c().getSelfUserInfo().f228093a;
                IGProPlayInfo I3 = j.c().I();
                Intrinsics.checkNotNull(I3);
                if (Intrinsics.areEqual(str3, String.valueOf(I3.getPlayNodeExInfo().getCompereTinyid()))) {
                    this.listenWidget.setMusicActionView(0);
                } else {
                    this.listenWidget.setMusicActionView(8);
                }
                if (j.a().M0().getMusicVolume() == 0) {
                    this.listenWidget.getQuietMusic().setVisibility(0);
                    return;
                } else {
                    this.listenWidget.getQuietMusic().setVisibility(8);
                    return;
                }
            }
            this.listenWidget.setVisibility(8);
            j.a().M0().g1();
            if (this.listenWidget.getVisibility() != 8) {
            }
        }
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void a() {
        this.listenWidget.o(true);
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void b(int num) {
        this.listenWidget.setPlayNum(num);
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void c() {
        FragmentActivity activity;
        Fragment fragment = this.fragment;
        if (fragment != null && (activity = fragment.getActivity()) != null) {
            GuildMediaAioViewModel a16 = GuildMediaAioViewModel.INSTANCE.a(activity);
            Integer valueOf = Integer.valueOf(R.drawable.guild_media_tips_icon);
            String string = BaseApplication.context.getString(R.string.f1496512v);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.guild_media_mode_change)");
            a16.l2(new b.c(valueOf, string, null, null, 12, null));
        }
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void d(int from) {
        j.d().i(new ad(from));
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void e() {
        this.listenWidget.p(this.musicInfo.getMusicDisplayName());
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void f(final int isShow) {
        if (!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.f
                @Override // java.lang.Runnable
                public final void run() {
                    ListenWidgetPresenter.C(ListenWidgetPresenter.this, isShow);
                }
            });
        } else {
            this.listenWidget.getQuietMusic().setVisibility(isShow);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void g(long curPtsMS, long durationMS) {
        this.listenWidget.setPlayTime(curPtsMS, durationMS);
        B(curPtsMS);
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void h(int operate) {
        if (operate != 1) {
            if (operate == 2) {
                this.listenWidget.getPauseOrResumeBtn().setImageResource(R.drawable.guild_listen_pause);
                return;
            }
            return;
        }
        this.listenWidget.getPauseOrResumeBtn().setImageResource(R.drawable.guild_listen_resume);
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void i(boolean _needShow) {
        this.needShow = _needShow;
        if (_needShow) {
            K();
        } else {
            this.listenWidget.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void j(int context, int btnStr) {
        DialogUtil.createCustomDialog(this.listenWidget.getContext(), 230, (String) null, HardCodeUtil.qqStr(context), "", HardCodeUtil.qqStr(btnStr), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.media.listen.presenter.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                ListenWidgetPresenter.I(dialogInterface, i3);
            }
        }, (DialogInterface.OnClickListener) null).show();
    }

    @Override // com.tencent.mobileqq.guild.media.listen.presenter.a
    public void showToast(int res) {
        QQToast.makeText(this.listenWidget.getContext(), BaseApplication.context.getString(res), 0).show();
    }

    public final void u() {
        if (this.listenWidget.getOrderLl().getVisibility() != 8) {
            this.listenWidget.getOrderLl().setVisibility(8);
        }
        if (this.listenWidget.getPauseOrResumeBtnLl().getVisibility() != 8) {
            this.listenWidget.getPauseOrResumeBtnLl().setVisibility(8);
        }
        if (this.listenWidget.getNextPlayBtnLl().getVisibility() != 8) {
            this.listenWidget.getNextPlayBtnLl().setVisibility(8);
        }
    }

    public final void y() {
        this.listenWidget.e();
    }

    public final void z() {
        ListenWidget listenWidget = this.listenWidget;
        boolean z16 = true;
        if (this.playState != 1) {
            z16 = false;
        }
        listenWidget.o(z16);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ListenWidgetPresenter(@NotNull ListenWidget listenWidget, @NotNull Fragment _fragment) {
        this(listenWidget);
        Intrinsics.checkNotNullParameter(listenWidget, "listenWidget");
        Intrinsics.checkNotNullParameter(_fragment, "_fragment");
        this.fragment = _fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I(DialogInterface dialogInterface, int i3) {
    }
}
