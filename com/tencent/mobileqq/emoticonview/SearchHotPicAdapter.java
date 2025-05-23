package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticonview.searchemo.IEmoticonEventCallback;
import com.tencent.mobileqq.emoticonview.searchemo.InfoAndActionCb;
import com.tencent.mobileqq.hotpic.api.IHotPicApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.emotion.pic.libra.QQEmoticonPicLoader;
import com.tencent.qqnt.kernel.nativeinterface.HotPicInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002 !B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0010\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0012H\u0002R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchHotPicAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/emoticonview/SearchHotPicAdapter$HotPicHolder;", "hotPicList", "", "Lcom/tencent/qqnt/kernel/nativeinterface/HotPicInfo;", "emoticonCallback", "Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "infoAndActionCb", "Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "(Ljava/util/List;Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;)V", "getEmoticonCallback", "()Lcom/tencent/mobileqq/emoticonview/searchemo/IEmoticonEventCallback;", "getHotPicList", "()Ljava/util/List;", "getInfoAndActionCb", "()Lcom/tencent/mobileqq/emoticonview/searchemo/InfoAndActionCb;", "getItemCount", "", "onBindViewHolder", "", "viewHolder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "sendHotPic", "index", "showSavePicPopupWindow", "imageView", "Landroid/view/View;", "Companion", "HotPicHolder", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class SearchHotPicAdapter extends RecyclerView.Adapter<HotPicHolder> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "SearchHotPicAdapter";

    @NotNull
    private static final List<Integer> idList;

    @Nullable
    private final IEmoticonEventCallback emoticonCallback;

    @NotNull
    private final List<HotPicInfo> hotPicList;

    @Nullable
    private final InfoAndActionCb infoAndActionCb;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchHotPicAdapter$Companion;", "", "()V", "TAG", "", "idList", "", "", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/emoticonview/SearchHotPicAdapter$HotPicHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivList", "", "Landroid/widget/ImageView;", "getIvList", "()Ljava/util/List;", "qqemoticonpanel-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class HotPicHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;

        @NotNull
        private final List<ImageView> ivList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HotPicHolder(@NotNull View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView);
            } else {
                this.ivList = new ArrayList();
            }
        }

        @NotNull
        public final List<ImageView> getIvList() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (List) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.ivList;
        }
    }

    static {
        List<Integer> listOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new Companion(null);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.y4d), Integer.valueOf(R.id.y4e), Integer.valueOf(R.id.y4f), Integer.valueOf(R.id.y4g), Integer.valueOf(R.id.y4h), Integer.valueOf(R.id.y4i), Integer.valueOf(R.id.y4j), Integer.valueOf(R.id.y4k)});
        idList = listOf;
    }

    public SearchHotPicAdapter(@NotNull List<HotPicInfo> hotPicList, @Nullable IEmoticonEventCallback iEmoticonEventCallback, @Nullable InfoAndActionCb infoAndActionCb) {
        Intrinsics.checkNotNullParameter(hotPicList, "hotPicList");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, hotPicList, iEmoticonEventCallback, infoAndActionCb);
            return;
        }
        this.hotPicList = hotPicList;
        this.emoticonCallback = iEmoticonEventCallback;
        this.infoAndActionCb = infoAndActionCb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$2(LoadState loadState, Option listenerOption) {
        r01.c cVar;
        Intrinsics.checkNotNullParameter(loadState, "loadState");
        Intrinsics.checkNotNullParameter(listenerOption, "listenerOption");
        if (loadState.isFinishSuccess()) {
            Animatable animatable = listenerOption.getAnimatable();
            if (animatable instanceof r01.c) {
                cVar = (r01.c) animatable;
            } else {
                cVar = null;
            }
            if (cVar != null) {
                cVar.start();
                return;
            }
            return;
        }
        if (loadState == LoadState.STATE_DOWNLOAD_FAILED || loadState == LoadState.STATE_DECODE_FAILED) {
            QLog.e(TAG, 1, "loadImage  state:" + loadState + ", listenerOption:" + listenerOption);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateViewHolder$lambda$0(SearchHotPicAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.sendHotPic(i3);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateViewHolder$lambda$1(SearchHotPicAdapter this$0, ImageView imageView, int i3, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
        this$0.showSavePicPopupWindow(imageView, i3);
        return true;
    }

    private final void sendHotPic(int index) {
        IEmoticonEventCallback iEmoticonEventCallback = this.emoticonCallback;
        if (iEmoticonEventCallback != null) {
            iEmoticonEventCallback.sendEmotion(index, this.hotPicList.get(index));
        }
        InfoAndActionCb infoAndActionCb = this.infoAndActionCb;
        if (infoAndActionCb != null) {
            infoAndActionCb.sendEmotionHappened();
        }
    }

    private final void showSavePicPopupWindow(View imageView, int index) {
        HotPicSearchEmoticonInfo hotPicSearchEmoticonInfo = new HotPicSearchEmoticonInfo(1, index + 1, null, com.tencent.mobileqq.util.an.f306578a.b(this.hotPicList.get(index)));
        InfoAndActionCb infoAndActionCb = this.infoAndActionCb;
        if (infoAndActionCb != null) {
            infoAndActionCb.showAddCustomPopup(imageView, hotPicSearchEmoticonInfo);
        }
    }

    @Nullable
    public final IEmoticonEventCallback getEmoticonCallback() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IEmoticonEventCallback) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.emoticonCallback;
    }

    @NotNull
    public final List<HotPicInfo> getHotPicList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.hotPicList;
    }

    @Nullable
    public final InfoAndActionCb getInfoAndActionCb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (InfoAndActionCb) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.infoAndActionCb;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NotNull HotPicHolder viewHolder, int position) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewHolder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int i3 = 0;
        for (ImageView imageView : viewHolder.getIvList()) {
            int i16 = i3 + 1;
            Option url = Option.obtain().setUrl(this.hotPicList.get(i3).thumbDownloadUrl);
            IHotPicApi iHotPicApi = (IHotPicApi) QRoute.api(IHotPicApi.class);
            String str = this.hotPicList.get(i3).thumbDownloadUrl;
            Intrinsics.checkNotNullExpressionValue(str, "hotPicList[index].thumbDownloadUrl");
            Option option = url.setLocalPath(iHotPicApi.getDiskFilePath(str)).setTargetView(imageView).setLoadingDrawable(HotPicSearchEmoticonInfo.sLoadingDrawable).setFailDrawable(HotPicSearchEmoticonInfo.sLoadingDrawable);
            com.tencent.libra.util.a aVar = com.tencent.libra.util.a.f118813a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            aVar.p(option, false);
            aVar.r(option, false);
            QQEmoticonPicLoader.f356316a.c(option, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.emoticonview.aq
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option2) {
                    SearchHotPicAdapter.onBindViewHolder$lambda$2(loadState, option2);
                }
            });
            i3 = i16;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public HotPicHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (HotPicHolder) iPatchRedirector.redirect((short) 5, (Object) this, (Object) viewGroup, viewType);
        }
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        final int i3 = 0;
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167933e72, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(viewGroup.context)\n\u2026ot_pic, viewGroup, false)");
        HotPicHolder hotPicHolder = new HotPicHolder(inflate);
        Iterator<Integer> it = idList.iterator();
        while (it.hasNext()) {
            int i16 = i3 + 1;
            final ImageView imageView = (ImageView) inflate.findViewById(it.next().intValue());
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.emoticonview.ao
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SearchHotPicAdapter.onCreateViewHolder$lambda$0(SearchHotPicAdapter.this, i3, view);
                }
            });
            imageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.emoticonview.ap
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    boolean onCreateViewHolder$lambda$1;
                    onCreateViewHolder$lambda$1 = SearchHotPicAdapter.onCreateViewHolder$lambda$1(SearchHotPicAdapter.this, imageView, i3, view);
                    return onCreateViewHolder$lambda$1;
                }
            });
            List<ImageView> ivList = hotPicHolder.getIvList();
            Intrinsics.checkNotNullExpressionValue(imageView, "imageView");
            ivList.add(imageView);
            i3 = i16;
        }
        return hotPicHolder;
    }
}
