package com.tencent.timi.game.test.impl.emo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonListProvider;
import com.tencent.mobileqq.emoticonview.EmoticonViewBinder;
import com.tencent.mobileqq.emoticonview.EmotionPanelInfo;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanelApp;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonInfoService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.timi.game.base.TimiGameBaseFragment;
import com.yolo.esports.download.common.DownloadInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import nr2.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001(\u0018\u0000 .2\u00020\u0001:\u0001/B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\n\u0010\u001c\u001a\u00020\u001b*\u00020\u001aR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010#\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u00060"}, d2 = {"Lcom/tencent/timi/game/test/impl/emo/EmoticonDataTestFragment;", "Lcom/tencent/timi/game/base/TimiGameBaseFragment;", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "Eh", "initData", "initViews", "Lmqq/app/AppRuntime;", "appRuntime", "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "Fh", "Landroid/view/ViewGroup;", "getRootView", "Landroid/view/LayoutInflater;", "inflater", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isWrapContent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "", "Oh", "Lnr2/t;", UserInfo.SEX_FEMALE, "Lnr2/t;", "binding", "G", "Lcom/tencent/mobileqq/emoticonview/api/IEmoticonMainPanelService$PanelBuilder;", "mPanelBuilder", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "H", "Lcom/tencent/mobileqq/emoticonview/IEmoticonMainPanelApp;", "mEmoApp", "com/tencent/timi/game/test/impl/emo/EmoticonDataTestFragment$d", "I", "Lcom/tencent/timi/game/test/impl/emo/EmoticonDataTestFragment$d;", "mImgDownloaderListener", "<init>", "()V", "J", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class EmoticonDataTestFragment extends TimiGameBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    private t binding;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private IEmoticonMainPanelService.PanelBuilder mPanelBuilder;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private IEmoticonMainPanelApp mEmoApp;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final d mImgDownloaderListener = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\u000e\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/timi/game/test/impl/emo/EmoticonDataTestFragment$b", "Lcom/tencent/mobileqq/emoticonview/EmoticonCallback;", "", "delete", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "info", "send", "", NodeProps.ON_LONG_CLICK, "oldInfo", "newInfo", "Landroid/graphics/drawable/Drawable;", "d", "onShowPopup", "onHidePopup", "setting", "emoticonMall", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements EmoticonCallback {
        b() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void emoticonMall() {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "emoticonMall");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onHidePopup(@Nullable EmoticonInfo info) {
            String str;
            if (info != null) {
                str = EmoticonDataTestFragment.this.Oh(info);
            } else {
                str = null;
            }
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "onHidePopup info:" + str + "}");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public boolean onLongClick(@Nullable EmoticonInfo info) {
            String str;
            if (info != null) {
                str = EmoticonDataTestFragment.this.Oh(info);
            } else {
                str = null;
            }
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "onLongClick " + str);
            return true;
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void onShowPopup(@Nullable EmoticonInfo oldInfo, @Nullable EmoticonInfo newInfo, @Nullable Drawable d16) {
            String str;
            String str2 = null;
            if (oldInfo != null) {
                str = EmoticonDataTestFragment.this.Oh(oldInfo);
            } else {
                str = null;
            }
            if (newInfo != null) {
                str2 = EmoticonDataTestFragment.this.Oh(newInfo);
            }
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "onShowPopup oldInfo:" + str + ", newInfo:" + str2);
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send(@Nullable EmoticonInfo info) {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "send " + (info != null ? EmoticonDataTestFragment.this.Oh(info) : null));
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void setting() {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "setting");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void send() {
            com.tencent.timi.game.utils.l.b("EmoticonTestFragment_", "send()}");
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonCallback
        public void delete() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/test/impl/emo/EmoticonDataTestFragment$c", "Lcom/tencent/mobileqq/emoticonview/EmoticonListProvider;", "", "hasBigEmotion", "onlySysAndEmoji", "", "Lcom/tencent/mobileqq/emoticonview/EmotionPanelInfo;", "getEmotionPanelInfo", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements EmoticonListProvider {
        c() {
        }

        @Override // com.tencent.mobileqq.emoticonview.EmoticonListProvider
        @NotNull
        public List<EmotionPanelInfo> getEmotionPanelInfo(boolean hasBigEmotion, boolean onlySysAndEmoji) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new EmotionPanelInfo(7, EmoticonViewBinder.COLUMNNUM_SYSTEM_AND_EMOJI, null));
            arrayList.add(new EmotionPanelInfo(4, 4, null));
            arrayList.add(new EmotionPanelInfo(11, 4, null));
            return arrayList;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/timi/game/test/impl/emo/EmoticonDataTestFragment$d", "Lcom/yolo/esports/download/cb/a;", "Lcom/yolo/esports/download/common/DownloadInfo;", "taskInfo", "", "a", "c", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d implements com.yolo.esports.download.cb.a {
        d() {
        }

        @Override // com.yolo.esports.download.cb.a
        public void a(@Nullable DownloadInfo taskInfo) {
            com.tencent.timi.game.utils.l.b("EmoticonDataTestFragment_", "onTaskStart taskInfo:" + taskInfo);
        }

        @Override // com.yolo.esports.download.cb.a
        public void b(@Nullable DownloadInfo taskInfo) {
            com.tencent.timi.game.utils.l.b("EmoticonDataTestFragment_", "onTaskProgressChanged taskInfo:" + taskInfo);
        }

        @Override // com.yolo.esports.download.cb.a
        public void c(@Nullable DownloadInfo taskInfo) {
            com.tencent.timi.game.utils.l.b("EmoticonDataTestFragment_", "onTaskStateChanged taskInfo:" + taskInfo);
            if (taskInfo != null && taskInfo.v()) {
                EmoticonDataTestFragment.this.Eh(taskInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Eh(DownloadInfo taskInfo) {
        ((IEmosmService) QRoute.api(IEmosmService.class)).addToCustomEmotionForPic(getContext(), taskInfo.f390014e, false, 0);
    }

    private final IEmoticonMainPanelService.PanelBuilder Fh(AppRuntime appRuntime) {
        IEmoticonMainPanelService.PanelBuilder panelBuilder = this.mPanelBuilder;
        if (panelBuilder != null) {
            Intrinsics.checkNotNull(panelBuilder);
            return panelBuilder;
        }
        IEmoticonMainPanelService.PanelBuilder newBuilder = ((IEmoticonMainPanelService) appRuntime.getRuntimeService(IEmoticonMainPanelService.class, "")).newBuilder(getContext(), 100004);
        this.mPanelBuilder = newBuilder;
        if (newBuilder != null) {
            newBuilder.setStyleChange(true);
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder2 = this.mPanelBuilder;
        if (panelBuilder2 != null) {
            panelBuilder2.setCallBack(new b());
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder3 = this.mPanelBuilder;
        if (panelBuilder3 != null) {
            panelBuilder3.setEmoticonListProvider(new c());
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder4 = this.mPanelBuilder;
        if (panelBuilder4 != null) {
            panelBuilder4.setDisableMoreEmotionButton(true);
        }
        IEmoticonMainPanelService.PanelBuilder panelBuilder5 = this.mPanelBuilder;
        Intrinsics.checkNotNull(panelBuilder5);
        return panelBuilder5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(EmoticonDataTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IEmoticonMainPanelApp iEmoticonMainPanelApp = this$0.mEmoApp;
        List emoticonList = ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getEmoticonList(iEmoticonMainPanelApp, 7, 5);
        Intrinsics.checkNotNullExpressionValue(emoticonList, "api(IEmoticonInfoService\u2026ts.BUSINESS_ID_TIMI_GAME)");
        com.tencent.timi.game.utils.l.i("EmoticonDataTestFragment_", "dataAllList size:" + emoticonList.size());
        List commonUsedSystemEmojiPanelData = ((IEmoticonInfoService) QRoute.api(IEmoticonInfoService.class)).getCommonUsedSystemEmojiPanelData(iEmoticonMainPanelApp, 7, false);
        Intrinsics.checkNotNullExpressionValue(commonUsedSystemEmojiPanelData, "api(IEmoticonInfoService\u2026iPanelData(app, 7, false)");
        com.tencent.timi.game.utils.l.i("EmoticonDataTestFragment_", "commonUseList size:" + commonUsedSystemEmojiPanelData.size());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(EmoticonDataTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IRuntimeService runtimeService = this$0.getQBaseActivity().getAppRuntime().getRuntimeService(IFavroamingDBManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "qBaseActivity.appRuntime\u2026nstant.MAIN\n            )");
        List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = ((IFavroamingDBManagerService) runtimeService).syncGetCustomEmotionInfoShowedInPanel();
        com.tencent.timi.game.utils.l.i("EmoticonDataTestFragment_", "dataList size:" + syncGetCustomEmotionInfoShowedInPanel.size());
        if (syncGetCustomEmotionInfoShowedInPanel.size() == 0) {
            IRuntimeService runtimeService2 = this$0.getQBaseActivity().getAppRuntime().getRuntimeService(IFavroamingManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService2, "qBaseActivity.appRuntime\u2026nt.MAIN\n                )");
            ((IFavroamingManagerService) runtimeService2).syncRoaming();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
        int i3 = emotionSearchResult.nResult;
        com.tencent.timi.game.utils.l.i("EmoticonDataTestFragment_", "onSearchResult r=" + i3 + ", " + i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(IEmotionSearchManagerService hotPicService, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hotPicService, "$hotPicService");
        hotPicService.pushEmotionSearchTask(new IEmotionSearchManagerService.EmotionSearchTask(0));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(IEmotionSearchManagerService hotPicService, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hotPicService, "$hotPicService");
        hotPicService.pushEmotionSearchTask(new IEmotionSearchManagerService.EmotionSearchTask(1, "\u54a9\u54a9"));
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(IEmotionSearchManagerService hotPicService, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(hotPicService, "$hotPicService");
        hotPicService.loadMore();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(EmoticonDataTestFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String filePath = AbsDownloader.getFilePath("https://wa.qq.com/hot-res/141bc358094903d780144b8910779042-t.gif");
        File file = new File(filePath);
        File parentFile = file.getParentFile();
        if (parentFile == null) {
            com.tencent.timi.game.utils.l.e("EmoticonDataTestFragment_", "bad parent file");
        } else {
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            DownloadInfo v06 = ((f05.a) mm4.b.b(f05.a.class)).v0("https://wa.qq.com/hot-res/141bc358094903d780144b8910779042-t.gif");
            if (v06 == null) {
                v06 = new DownloadInfo();
            }
            v06.f390014e = "https://wa.qq.com/hot-res/141bc358094903d780144b8910779042-t.gif";
            v06.f390016h = parentFile.getAbsolutePath();
            v06.f390015f = file.getName();
            v06.U = "";
            if (v06.v() && !v06.f390017i.equals(filePath)) {
                f05.a aVar = (f05.a) mm4.b.b(f05.a.class);
                String str = v06.f390014e;
                Intrinsics.checkNotNullExpressionValue(str, "info.downloadUrl");
                aVar.C3(str);
            }
            ((f05.a) mm4.b.b(f05.a.class)).J0(v06, this$0.mImgDownloaderListener);
            ((f05.a) mm4.b.b(f05.a.class)).A3(v06);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(IEmoticonManagerService emoManagerService, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(emoManagerService, "$emoManagerService");
        List<EmoticonPackage> syncGetTabEmoticonPackages = emoManagerService.syncGetTabEmoticonPackages();
        com.tencent.timi.game.utils.l.i("EmoticonDataTestFragment_", "pkgs :" + syncGetTabEmoticonPackages.size());
        if (syncGetTabEmoticonPackages.size() != 0) {
            com.tencent.timi.game.utils.l.i("EmoticonDataTestFragment_", "single ep  :" + syncGetTabEmoticonPackages.get(0));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void initData() {
        IEmoticonMainPanelApp iEmoticonMainPanelApp;
        AppRuntime appRuntime = getQBaseActivity().getAppRuntime();
        Intrinsics.checkNotNullExpressionValue(appRuntime, "qBaseActivity.appRuntime");
        Fh(appRuntime);
        IEmoticonMainPanelService.PanelBuilder panelBuilder = this.mPanelBuilder;
        if (panelBuilder != null) {
            iEmoticonMainPanelApp = panelBuilder.getEmoticonMainPanelApp();
        } else {
            iEmoticonMainPanelApp = null;
        }
        this.mEmoApp = iEmoticonMainPanelApp;
    }

    private final void initViews() {
        t tVar = this.binding;
        t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f421131h.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Gh(EmoticonDataTestFragment.this, view);
            }
        });
        t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar3 = null;
        }
        tVar3.f421127d.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Hh(EmoticonDataTestFragment.this, view);
            }
        });
        IRuntimeService runtimeService = getQBaseActivity().getAppRuntime().getRuntimeService(IEmotionSearchManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "qBaseActivity.appRuntime\u2026ssConstant.MAIN\n        )");
        final IEmotionSearchManagerService iEmotionSearchManagerService = (IEmotionSearchManagerService) runtimeService;
        iEmotionSearchManagerService.setSearchCallBack(new IEmotionSearchManagerService.a() { // from class: com.tencent.timi.game.test.impl.emo.c
            @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.a
            public final void onSearchCallBack(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
                EmoticonDataTestFragment.Ih(emotionSearchResult);
            }
        });
        t tVar4 = this.binding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar4 = null;
        }
        tVar4.f421128e.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Jh(IEmotionSearchManagerService.this, view);
            }
        });
        t tVar5 = this.binding;
        if (tVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar5 = null;
        }
        tVar5.f421130g.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Kh(IEmotionSearchManagerService.this, view);
            }
        });
        t tVar6 = this.binding;
        if (tVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar6 = null;
        }
        tVar6.f421129f.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Lh(IEmotionSearchManagerService.this, view);
            }
        });
        t tVar7 = this.binding;
        if (tVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar7 = null;
        }
        tVar7.f421125b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Mh(EmoticonDataTestFragment.this, view);
            }
        });
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 11; i3++) {
            arrayList.add(new xg4.a(1L, 1L, R.drawable.o79, null, 8, null));
        }
        t tVar8 = this.binding;
        if (tVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar8 = null;
        }
        tVar8.f421135l.setData(arrayList);
        t tVar9 = this.binding;
        if (tVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar9 = null;
        }
        URLImageView uRLImageView = tVar9.f421134k;
        Intrinsics.checkNotNullExpressionValue(uRLImageView, "binding.testIgv");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026GifImage = true\n        }");
        com.tencent.timi.game.utils.b.g(uRLImageView, "https://p.qpic.cn/qq_expression/285692817/285692817_0_0_0_F47EF47E3D66489EAFD3FC294EE0BD74_0_0/0", obtain);
        IRuntimeService runtimeService2 = getQBaseActivity().getAppRuntime().getRuntimeService(IEmoticonManagerService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService2, "qBaseActivity.appRuntime\u2026ssConstant.MAIN\n        )");
        final IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) runtimeService2;
        t tVar10 = this.binding;
        if (tVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar10;
        }
        tVar2.f421126c.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.test.impl.emo.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmoticonDataTestFragment.Nh(IEmoticonManagerService.this, view);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final String Oh(@NotNull EmoticonInfo emoticonInfo) {
        Intrinsics.checkNotNullParameter(emoticonInfo, "<this>");
        if (emoticonInfo instanceof SystemAndEmojiEmoticonInfo) {
            SystemAndEmojiEmoticonInfo systemAndEmojiEmoticonInfo = (SystemAndEmojiEmoticonInfo) emoticonInfo;
            return "code:" + systemAndEmojiEmoticonInfo.code + ", emotionType:" + systemAndEmojiEmoticonInfo.emotionType + ", title:" + systemAndEmojiEmoticonInfo.title + ", isCommonUsed:$" + systemAndEmojiEmoticonInfo.isCommonUsed;
        }
        if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
            IFavoriteEmoticonInfo iFavoriteEmoticonInfo = (IFavoriteEmoticonInfo) emoticonInfo;
            return " eId:" + iFavoriteEmoticonInfo.getEid() + ", path:" + iFavoriteEmoticonInfo.getPath() + ",url:" + iFavoriteEmoticonInfo.getUrl() + ",resID:" + iFavoriteEmoticonInfo.getResID();
        }
        if (emoticonInfo instanceof CameraEmoticonInfo) {
            CameraEmoticonInfo cameraEmoticonInfo = (CameraEmoticonInfo) emoticonInfo;
            return "contextKey:" + cameraEmoticonInfo.contextKey + ", thumbPath:" + cameraEmoticonInfo.thumbPath + ", templateId:" + cameraEmoticonInfo.templateId + ", eId:" + cameraEmoticonInfo.eId + ",path:" + cameraEmoticonInfo.path + ",url:" + cameraEmoticonInfo.url + ",resID:" + cameraEmoticonInfo.resID + ",roamingType:" + cameraEmoticonInfo.roamingType + ",";
        }
        return "";
    }

    @Override // com.tencent.timi.game.base.TimiGameBaseFragment
    @Nullable
    public ViewGroup getRootView() {
        t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        return tVar.f421133j;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        t g16 = t.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        ScrollView root = g16.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ((f05.a) mm4.b.b(f05.a.class)).f3(this.mImgDownloaderListener);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initData();
        initViews();
    }
}
