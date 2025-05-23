package com.tencent.mobileqq.wink.editor.music.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicControlPanel;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel;
import com.tencent.mobileqq.wink.editor.music.ax;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$musicBroadcastReceiver$2;
import com.tencent.mobileqq.wink.editor.music.lyric.d;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.winkpublish.report.WinkDc5507ReportData;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 K2\u00020\u0001:\u0003LMNB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u001e\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\bJ\b\u0010\u001f\u001a\u00020\u0006H\u0016J\u000e\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 J\u000e\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#J\u000e\u0010(\u001a\u00020\u00062\u0006\u0010'\u001a\u00020&J\b\u0010*\u001a\u00020)H\u0016R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010;\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\"\u0010D\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010=\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010G\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicMenuBaseFragment;", "Lcom/tencent/mobileqq/wink/editor/music/vo/b;", "infoWrapper", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "Wh", "", "Kh", "Landroid/content/Intent;", "Fh", "Rh", "Landroid/view/View;", "v", "Dh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Qh", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "Ih", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Jh", "enable", "Sh", "onDestroyView", "", "progress", "Yh", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$c;", "callback", "Vh", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$b;", "delegate", "Uh", "", "getLogTag", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "Hh", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Landroid/content/BroadcastReceiver;", "G", "Gh", "()Landroid/content/BroadcastReceiver;", "musicBroadcastReceiver", "H", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$c;", "playerCallback", "I", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$b;", "menuInfoDelegate", "J", "Z", "mEnableMusicClear", "K", "Eh", "()Z", "Th", "(Z)V", "expand", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicControlPanel;", "L", "Lcom/tencent/mobileqq/wink/editor/music/WinkEditorMusicControlPanel;", "winkEditorMusicControlPanel", "<init>", "()V", "N", "a", "b", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class MusicSelectFragment extends MusicMenuBaseFragment {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Class<MusicSelectFragment> P = MusicSelectFragment.class;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicSourceViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy musicBroadcastReceiver;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private c playerCallback;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private b menuInfoDelegate;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean mEnableMusicClear;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean expand;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private WinkEditorMusicControlPanel winkEditorMusicControlPanel;

    @NotNull
    public Map<Integer, View> M = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$a;", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/Scene;", "scene", "Landroidx/lifecycle/ViewModelStoreOwner;", "storeOwner", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment;", "a", "", "KEY_SCENE", "Ljava/lang/String;", "Ljava/lang/Class;", "TAG", "Ljava/lang/Class;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final MusicSelectFragment a(@NotNull Scene scene, @Nullable ViewModelStoreOwner storeOwner) {
            Intrinsics.checkNotNullParameter(scene, "scene");
            MusicSelectFragment musicSelectFragment = new MusicSelectFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("scene", scene);
            musicSelectFragment.qh(storeOwner);
            musicSelectFragment.setArguments(bundle);
            return musicSelectFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$b;", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$c;", "", "", "pause", "play", "", "position", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface c {
        void pause();

        void play();

        void seek(int position);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$e", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel$c;", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements MusicSourceViewModel.c {
        e() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel.c
        public void a(@NotNull WinkEditorMusicInfo musicInfo) {
            Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
            Intent intent = new Intent();
            intent.setAction(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
            intent.putExtra("event", QQWinkConstants.JS_PLUGIN_EVENT_PLAY_MEDIA_CACHE_MUSIC_SUCCESS);
            intent.putExtra("cacheMusicMid", musicInfo.p());
            FragmentActivity activity = MusicSelectFragment.this.getActivity();
            if (activity != null) {
                activity.sendBroadcast(intent);
            }
        }
    }

    public MusicSelectFragment() {
        super(R.layout.hfq);
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MusicSourceViewModel>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$musicSourceViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MusicSourceViewModel invoke() {
                ViewModelStoreOwner mStoreOwner = MusicSelectFragment.this.getMStoreOwner();
                if (mStoreOwner == null) {
                    mStoreOwner = MusicSelectFragment.this.requireActivity();
                    Intrinsics.checkNotNullExpressionValue(mStoreOwner, "requireActivity()");
                }
                ViewModel viewModel = new ViewModelProvider(mStoreOwner).get(MusicSourceViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(mStore\u2026rceViewModel::class.java]");
                return (MusicSourceViewModel) viewModel;
            }
        });
        this.musicSourceViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<MusicSelectFragment$musicBroadcastReceiver$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$musicBroadcastReceiver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$musicBroadcastReceiver$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final MusicSelectFragment musicSelectFragment = MusicSelectFragment.this;
                return new BroadcastReceiver() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$musicBroadcastReceiver$2.1
                    @Override // android.content.BroadcastReceiver
                    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                        Intrinsics.checkNotNullParameter(context, "context");
                        Intrinsics.checkNotNullParameter(intent, "intent");
                        if (!MusicSelectFragment.this.getExpand()) {
                            return;
                        }
                        MusicSelectFragment.this.Hh().Q3(context, intent);
                    }
                };
            }
        });
        this.musicBroadcastReceiver = lazy2;
        this.mEnableMusicClear = true;
        this.expand = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Dh(View v3) {
        String str;
        WinkEditorMusicInfo currentMusic = Hh().getCurrentMusic();
        if (currentMusic != null) {
            Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(map, "map");
            map.put("xsj_music_id", currentMusic.p());
            map.put("xsj_music_name", currentMusic.q());
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, currentMusic.E);
            if (currentMusic.x()) {
                str = "0";
            } else {
                str = "1";
            }
            map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, str);
            map.put("xsj_eid", "em_xsj_collect_button");
            map.put("xsj_custom_pgid", WinkDatongCurrentParams.get("xsj_custom_pgid"));
            VideoReport.reportEvent("ev_xsj_abnormal_clck", map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent Fh() {
        Intent intent = new Intent();
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        QZoneHelper.addSource(intent);
        intent.putExtra("videoclipduration", (int) Hh().getVideoDurationMs());
        intent.putExtra("videofrom", "fromqqwink");
        if (Hh().getEditMode() == WinkEditorViewModel.EditMode.Image) {
            intent.putExtra("type", "photo");
        } else {
            intent.putExtra("type", "notphoto");
        }
        return intent;
    }

    private final BroadcastReceiver Gh() {
        return (BroadcastReceiver) this.musicBroadcastReceiver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MusicSourceViewModel Hh() {
        return (MusicSourceViewModel) this.musicSourceViewModel.getValue();
    }

    private final Scene Ih() {
        Object obj;
        Bundle arguments = getArguments();
        Scene scene = null;
        if (arguments != null) {
            obj = arguments.get("scene");
        } else {
            obj = null;
        }
        if (obj instanceof Scene) {
            scene = (Scene) obj;
        }
        if (scene == null) {
            return Scene.EDIT;
        }
        return scene;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Kh() {
        if (Hh().getEditMode() == WinkEditorViewModel.EditMode.Image) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Lh(MusicSelectFragment this$0, List list) {
        Object obj;
        WinkEditorViewModel.EditMode editMode;
        WinkEditorViewModel.EditMode editMode2;
        WinkEditorMusicControlPanel winkEditorMusicControlPanel;
        WinkEditorMusicControlPanel winkEditorMusicControlPanel2;
        WinkEditorMusicControlPanel winkEditorMusicControlPanel3;
        WinkEditorMusicControlPanel winkEditorMusicControlPanel4;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            w53.b.a(this$0.getLogTag(), "onViewCreated... musicSourceViewModel.musicList list size:" + list.size());
            Iterator it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (((WinkEditorMusicInfo) obj).f321259e) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) obj;
            if (winkEditorMusicInfo != null) {
                long o16 = winkEditorMusicInfo.o();
                Long l3 = WinkEditorMusicInfo.H;
                if (l3 == null || o16 != l3.longValue()) {
                    WinkEditorMusicControlPanel winkEditorMusicControlPanel5 = this$0.winkEditorMusicControlPanel;
                    if (winkEditorMusicControlPanel5 != null) {
                        winkEditorMusicControlPanel5.setOperatePanelVisible(true);
                    }
                    editMode = this$0.Hh().getEditMode();
                    editMode2 = WinkEditorViewModel.EditMode.Image;
                    if (editMode == editMode2) {
                        if (this$0.Ih() == Scene.CAMERA) {
                            WinkEditorMusicControlPanel winkEditorMusicControlPanel6 = this$0.winkEditorMusicControlPanel;
                            if (winkEditorMusicControlPanel6 != null) {
                                winkEditorMusicControlPanel6.setMusicLibrarySource(WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE);
                            }
                        } else {
                            WinkEditorMusicControlPanel winkEditorMusicControlPanel7 = this$0.winkEditorMusicControlPanel;
                            if (winkEditorMusicControlPanel7 != null) {
                                winkEditorMusicControlPanel7.setMusicLibrarySource(WinkDaTongReportConstant.PageId.PG_XSJ_EDIT_PAGE);
                            }
                        }
                    } else {
                        WinkEditorMusicControlPanel winkEditorMusicControlPanel8 = this$0.winkEditorMusicControlPanel;
                        if (winkEditorMusicControlPanel8 != null) {
                            winkEditorMusicControlPanel8.setMusicLibrarySource(WinkDaTongReportConstant.PageId.PG_XSJ_PIC_EDIT_PAGE);
                        }
                    }
                    winkEditorMusicControlPanel = this$0.winkEditorMusicControlPanel;
                    if (winkEditorMusicControlPanel != null) {
                        if (winkEditorMusicInfo != null && winkEditorMusicInfo.f321262i == 3) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        if (!z18 && this$0.Hh().getEditMode() != editMode2) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        winkEditorMusicControlPanel.setClipEntranceVisible(z19);
                    }
                    winkEditorMusicControlPanel2 = this$0.winkEditorMusicControlPanel;
                    if (winkEditorMusicControlPanel2 != null) {
                        if (winkEditorMusicInfo != null && winkEditorMusicInfo.f321262i == 3) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        winkEditorMusicControlPanel2.setCollectEntranceVisible(!z17);
                    }
                    if (winkEditorMusicInfo != null) {
                        this$0.Hh().J4(winkEditorMusicInfo);
                    }
                    winkEditorMusicControlPanel3 = this$0.winkEditorMusicControlPanel;
                    if (winkEditorMusicControlPanel3 != null) {
                        if (winkEditorMusicInfo != null) {
                            z16 = winkEditorMusicInfo.x();
                        } else {
                            z16 = false;
                        }
                        winkEditorMusicControlPanel3.setCollectEntrance(z16);
                    }
                    if (this$0.Hh().getEditMode() == editMode2) {
                        WinkEditorMusicControlPanel winkEditorMusicControlPanel9 = this$0.winkEditorMusicControlPanel;
                        if (winkEditorMusicControlPanel9 != null) {
                            winkEditorMusicControlPanel9.setMusicDisableEnable(true);
                        }
                    } else {
                        WinkEditorMusicControlPanel winkEditorMusicControlPanel10 = this$0.winkEditorMusicControlPanel;
                        if (winkEditorMusicControlPanel10 != null) {
                            winkEditorMusicControlPanel10.setMusicDisableEnable(false);
                        }
                    }
                    winkEditorMusicControlPanel4 = this$0.winkEditorMusicControlPanel;
                    if (winkEditorMusicControlPanel4 == null) {
                        winkEditorMusicControlPanel4.setMusicEnableClear(this$0.mEnableMusicClear);
                        return;
                    }
                    return;
                }
            }
            WinkEditorMusicControlPanel winkEditorMusicControlPanel11 = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel11 != null) {
                winkEditorMusicControlPanel11.setOperatePanelVisible(false);
            }
            editMode = this$0.Hh().getEditMode();
            editMode2 = WinkEditorViewModel.EditMode.Image;
            if (editMode == editMode2) {
            }
            winkEditorMusicControlPanel = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel != null) {
            }
            winkEditorMusicControlPanel2 = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel2 != null) {
            }
            if (winkEditorMusicInfo != null) {
            }
            winkEditorMusicControlPanel3 = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel3 != null) {
            }
            if (this$0.Hh().getEditMode() == editMode2) {
            }
            winkEditorMusicControlPanel4 = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel4 == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(MusicSelectFragment this$0, List list) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null) {
            w53.b.a(this$0.getLogTag(), "onViewCreated... musicSourceViewModel.curMusicList list size:" + list.size());
            WinkEditorMusicControlPanel winkEditorMusicControlPanel = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel != null) {
                if (list.isEmpty() && Intrinsics.areEqual(this$0.Hh().L2(), ax.f320779f)) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                winkEditorMusicControlPanel.c(z16);
            }
            WinkEditorMusicControlPanel winkEditorMusicControlPanel2 = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel2 != null) {
                winkEditorMusicControlPanel2.f(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(MusicSelectFragment this$0, List list) {
        WinkEditorMusicControlPanel winkEditorMusicControlPanel;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (list != null && (winkEditorMusicControlPanel = this$0.winkEditorMusicControlPanel) != null) {
            winkEditorMusicControlPanel.e(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(MusicSelectFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num != null) {
            int intValue = num.intValue();
            WinkEditorMusicControlPanel winkEditorMusicControlPanel = this$0.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel != null) {
                winkEditorMusicControlPanel.b(intValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(MusicSelectFragment this$0, MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.playerCallback;
        if (cVar != null) {
            cVar.play();
        }
        Xh(this$0, musicInfoWrapper, null, 2, null);
    }

    private final void Qh(View rootView) {
        if (rootView != null && Ih() == Scene.CAMERA) {
            VideoReport.setPageId(rootView, WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE);
            Map<String, Object> a16 = com.tencent.mobileqq.wink.report.f.f326266a.a(getActivity());
            if (a16 != null && (!a16.isEmpty())) {
                for (Map.Entry<String, Object> entry : a16.entrySet()) {
                    WinkDatongCurrentParams.put(entry.getKey(), entry.getValue());
                }
            }
            VideoReport.setPageParams(rootView, new WinkDTParamBuilder().buildPageParams(null, WinkContext.INSTANCE.d().getDtParams().c()));
        }
    }

    private final void Rh() {
        IntentFilter intentFilter = new IntentFilter(QQWinkConstants.QQWinkBroadcast.ACTION_DISPATCH_MUSIC_EVENT);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.registerReceiver(Gh(), intentFilter);
        }
        Hh().A4(new e());
    }

    private final void Wh(MusicInfoWrapper infoWrapper, WinkEditorViewModel.EditMode editMode) {
        ImageView imageView;
        WinkEditorMusicInfo winkEditorMusicInfo;
        WinkEditorMusicControlPanel winkEditorMusicControlPanel = this.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel != null && (imageView = (ImageView) winkEditorMusicControlPanel.findViewById(R.id.f122677el)) != null) {
            if (infoWrapper != null) {
                winkEditorMusicInfo = infoWrapper.getMusicInfo();
            } else {
                winkEditorMusicInfo = null;
            }
            if (winkEditorMusicInfo == null && editMode != WinkEditorViewModel.EditMode.Image) {
                imageView.setImageResource(R.drawable.owe);
            } else {
                imageView.setImageResource(R.drawable.owd);
            }
        }
    }

    static /* synthetic */ void Xh(MusicSelectFragment musicSelectFragment, MusicInfoWrapper musicInfoWrapper, WinkEditorViewModel.EditMode editMode, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            editMode = null;
        }
        musicSelectFragment.Wh(musicInfoWrapper, editMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Zh(MusicSelectFragment this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorMusicControlPanel winkEditorMusicControlPanel = this$0.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel != null) {
            winkEditorMusicControlPanel.g((int) (j3 / 1000), (int) this$0.Hh().getVideoDurationMs());
        }
    }

    /* renamed from: Eh, reason: from getter */
    public final boolean getExpand() {
        return this.expand;
    }

    public final void Jh(@Nullable WinkEditorViewModel.EditMode editMode) {
        if (editMode != WinkEditorViewModel.EditMode.Video) {
            WinkEditorMusicControlPanel winkEditorMusicControlPanel = this.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel != null) {
                winkEditorMusicControlPanel.setMusicDisableEnable(false);
            }
            WinkEditorMusicControlPanel winkEditorMusicControlPanel2 = this.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel2 != null) {
                winkEditorMusicControlPanel2.setClipEntranceVisible(false);
                return;
            }
            return;
        }
        WinkEditorMusicControlPanel winkEditorMusicControlPanel3 = this.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel3 != null) {
            winkEditorMusicControlPanel3.setMusicDisableEnable(true);
        }
        WinkEditorMusicControlPanel winkEditorMusicControlPanel4 = this.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel4 != null) {
            winkEditorMusicControlPanel4.setClipEntranceVisible(true);
        }
        Wh(null, editMode);
    }

    public final void Sh(boolean enable) {
        this.mEnableMusicClear = enable;
    }

    public final void Th(boolean z16) {
        this.expand = z16;
    }

    public final void Uh(@NotNull b delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.menuInfoDelegate = delegate;
    }

    public final void Vh(@NotNull c callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.playerCallback = callback;
    }

    public final void Yh(final long progress) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.f
                @Override // java.lang.Runnable
                public final void run() {
                    MusicSelectFragment.Zh(MusicSelectFragment.this, progress);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicMenuBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.M.clear();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    @NotNull
    public String getLogTag() {
        String simpleName = P.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "TAG.simpleName");
        return simpleName;
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        WinkEditorMusicControlPanel winkEditorMusicControlPanel = this.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel != null) {
            winkEditorMusicControlPanel.a();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicMenuBaseFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.unregisterReceiver(Gh());
        }
        Hh().A4(null);
        ax.f320779f.d();
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicMenuBaseFragment, com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Wh(Hh().D2().getValue(), Hh().getEditMode());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intent intent;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.winkEditorMusicControlPanel = (WinkEditorMusicControlPanel) view.findViewById(R.id.f122387dt);
        Hh().j3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSelectFragment.Lh(MusicSelectFragment.this, (List) obj);
            }
        });
        Hh().N2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSelectFragment.Mh(MusicSelectFragment.this, (List) obj);
            }
        });
        Hh().E2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSelectFragment.Nh(MusicSelectFragment.this, (List) obj);
            }
        });
        Hh().l3().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSelectFragment.Oh(MusicSelectFragment.this, (Integer) obj);
            }
        });
        Hh().D2().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MusicSelectFragment.Ph(MusicSelectFragment.this, (MusicInfoWrapper) obj);
            }
        });
        WinkEditorMusicControlPanel winkEditorMusicControlPanel = this.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel != null) {
            winkEditorMusicControlPanel.setMusicListOperationCallback(new WinkEditorMusicPanel.c() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$onViewCreated$6
                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                @NotNull
                public WinkEditorViewModel.EditMode A() {
                    return MusicSelectFragment.this.Hh().getEditMode();
                }

                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                public void J0(@Nullable WinkEditorMusicInfo selectedMusicInfo, int position) {
                    Intent intent2;
                    if (selectedMusicInfo != null && !selectedMusicInfo.y()) {
                        MusicSelectFragment.this.Hh().M3(selectedMusicInfo, position);
                        FragmentActivity activity = MusicSelectFragment.this.getActivity();
                        if (activity != null) {
                            intent2 = activity.getIntent();
                        } else {
                            intent2 = null;
                        }
                        String p16 = selectedMusicInfo.p();
                        Intrinsics.checkNotNullExpressionValue(p16, "selectedMusicInfo.songMid");
                        t53.a.a(intent2, "music", p16, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$onViewCreated$6$onMusicSelected$1
                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                                invoke2(aVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                                dc5507Report.b(1008);
                                dc5507Report.j(2);
                            }
                        });
                        HashMap<String, Object> params = WinkDatongCurrentParams.params;
                        Intrinsics.checkNotNullExpressionValue(params, "params");
                        params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_IS_DEFAULT, 0);
                    }
                }

                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                public void M(boolean enableMusicCut) {
                    MusicSelectFragment musicSelectFragment;
                    WinkEditorMusicControlPanel winkEditorMusicControlPanel2;
                    WinkEditorMusicInfo currentMusic = MusicSelectFragment.this.Hh().getCurrentMusic();
                    if (currentMusic != null && (winkEditorMusicControlPanel2 = (musicSelectFragment = MusicSelectFragment.this).winkEditorMusicControlPanel) != null) {
                        MusicSourceViewModel Hh = musicSelectFragment.Hh();
                        String p16 = currentMusic.p();
                        Intrinsics.checkNotNullExpressionValue(p16, "it.getSongMid()");
                        winkEditorMusicControlPanel2.d(currentMusic, Hh.m3(p16), musicSelectFragment.Hh().getVideoDurationMs(), true);
                    }
                }

                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                public void a() {
                    Intent Fh;
                    boolean Kh;
                    Fh = MusicSelectFragment.this.Fh();
                    FragmentActivity activity = MusicSelectFragment.this.getActivity();
                    if (activity != null) {
                        Kh = MusicSelectFragment.this.Kh();
                        WinkEditorMusicHelper.J(activity, Fh, Boolean.valueOf(Kh));
                    }
                    MusicSelectFragment.c cVar = MusicSelectFragment.this.playerCallback;
                    if (cVar != null) {
                        cVar.pause();
                    }
                    MusicSelectFragment.c cVar2 = MusicSelectFragment.this.playerCallback;
                    if (cVar2 != null) {
                        cVar2.seek(0);
                    }
                }

                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                public void b(@NotNull ax categoryInfo) {
                    Intrinsics.checkNotNullParameter(categoryInfo, "categoryInfo");
                    MusicSelectFragment.this.Hh().G3(categoryInfo);
                }

                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                public void c(@Nullable View v3) {
                    MusicSelectFragment.this.Dh(v3);
                    MusicSelectFragment.this.Hh().I3();
                }

                @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicPanel.c
                public void d(boolean isEnabled) {
                    if (!isEnabled && MusicSelectFragment.this.Hh().getEditMode() != WinkEditorViewModel.EditMode.Image) {
                        MusicSelectFragment.this.Hh().y2();
                    }
                }
            });
        }
        WinkEditorMusicControlPanel winkEditorMusicControlPanel2 = this.winkEditorMusicControlPanel;
        if (winkEditorMusicControlPanel2 != null) {
            winkEditorMusicControlPanel2.setMusicLyricOperationCallback(new d());
        }
        Rh();
        Qh(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            intent = activity.getIntent();
        } else {
            intent = null;
        }
        t53.a.c(intent, new Function1<WinkDc5507ReportData.a, Unit>() { // from class: com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment$onViewCreated$8
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WinkDc5507ReportData.a aVar) {
                invoke2(aVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull WinkDc5507ReportData.a dc5507Report) {
                Intrinsics.checkNotNullParameter(dc5507Report, "$this$dc5507Report");
                dc5507Report.b(1008);
                dc5507Report.j(1);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\bH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$d", "Lcom/tencent/mobileqq/wink/editor/music/lyric/d$d;", "", "onMusicWaveMoveStart", "", "startTimeInMs", "endTimeInMs", "onMusicWaveMoving", "", "isDragging", "onMusicWaveMoveEnd", "videoClipPosition", "onIndicatorDragged", "isFromDetachWindow", "onClickCancelBtn", "onClickConfirmBtn", "onResetMusicRangeToRecommend", "show", "positon", "onLyricClick", "onBlankClick", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements d.InterfaceC9031d {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onClickCancelBtn(boolean isFromDetachWindow) {
            MusicSelectFragment.this.Hh().X3();
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onClickConfirmBtn() {
            MusicSelectFragment.this.Hh().Z3();
            MusicSelectFragment.this.Hh().L4();
            MusicSelectFragment.this.Hh().t4(null, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onIndicatorDragged(int videoClipPosition) {
            c cVar = MusicSelectFragment.this.playerCallback;
            if (cVar != null) {
                cVar.seek(videoClipPosition);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoveEnd(boolean isDragging) {
            if (!isDragging) {
                c cVar = MusicSelectFragment.this.playerCallback;
                if (cVar != null) {
                    cVar.play();
                    return;
                }
                return;
            }
            MusicSelectFragment.this.Hh().I4();
            c cVar2 = MusicSelectFragment.this.playerCallback;
            if (cVar2 != null) {
                cVar2.play();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoveStart() {
            c cVar = MusicSelectFragment.this.playerCallback;
            if (cVar != null) {
                cVar.pause();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onMusicWaveMoving(int startTimeInMs, int endTimeInMs) {
            WinkEditorMusicControlPanel winkEditorMusicControlPanel = MusicSelectFragment.this.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel != null) {
                winkEditorMusicControlPanel.h(startTimeInMs, endTimeInMs);
            }
            MusicSelectFragment.this.Hh().t4(Integer.valueOf(startTimeInMs), Integer.valueOf(endTimeInMs));
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onResetMusicRangeToRecommend(int startTimeInMs) {
            MusicSelectFragment.this.Hh().W3();
            int videoDurationMs = (int) (startTimeInMs + MusicSelectFragment.this.Hh().getVideoDurationMs());
            WinkEditorMusicControlPanel winkEditorMusicControlPanel = MusicSelectFragment.this.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel != null) {
                winkEditorMusicControlPanel.i(startTimeInMs);
            }
            WinkEditorMusicControlPanel winkEditorMusicControlPanel2 = MusicSelectFragment.this.winkEditorMusicControlPanel;
            if (winkEditorMusicControlPanel2 != null) {
                winkEditorMusicControlPanel2.h(startTimeInMs, videoDurationMs);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void show(boolean show) {
            if (MusicSelectFragment.this.Hh() != null) {
                MusicSelectFragment.this.Hh().B4(show);
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onBlankClick() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.lyric.d.InterfaceC9031d
        public void onLyricClick(int positon) {
        }
    }
}
