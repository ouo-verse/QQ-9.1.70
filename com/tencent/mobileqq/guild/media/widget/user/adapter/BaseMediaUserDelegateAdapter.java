package com.tencent.mobileqq.guild.media.widget.user.adapter;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.w;
import com.tencent.mobileqq.guild.media.widget.GuildMediaFacesController;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.bv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GProAudioLiveRobotStatusRspInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rt1.MediaPlayerRobotUserItem;
import rt1.MediaViewerRobotItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b?\u0010@J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0006\u0010\u000f\u001a\u00020\u0006J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\u0006\u0010\u0019\u001a\u00020\u0011R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR*\u0010\"\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\"\u0010+\u001a\u0010\u0012\f\u0012\n (*\u0004\u0018\u00010\u00110\u00110'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\u0010\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010\u001bR\u001b\u00109\u001a\u00020\u00118BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R0\u0010>\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110:j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/e;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/GProAudioLiveRobotStatusRspInfo;", "updateStatusList", "", "m0", "v0", "", "getTag", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "onAttachedToRecyclerView", "onDetachedFromRecyclerView", "n0", "Z", "", "column", "u0", "r0", "", "botId", "o0", "v", "l0", "Landroidx/fragment/app/Fragment;", "I", "Landroidx/fragment/app/Fragment;", "fragment", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "J", "Ljava/util/ArrayList;", "mBotStatusInfos", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaFacesController;", "K", "Lcom/tencent/mobileqq/guild/media/widget/GuildMediaFacesController;", "mController", "Le12/e;", "kotlin.jvm.PlatformType", "L", "Le12/e;", "mPlayerColumn", "", "M", "q0", "()Z", "t0", "(Z)V", "needIgnoreSelf", "N", "containerWidth", "P", "Lkotlin/Lazy;", "p0", "()I", "mOffset", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/util/HashMap;", "mItemViewHeightMap", "<init>", "(Landroidx/fragment/app/Fragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public abstract class BaseMediaUserDelegateAdapter extends e implements d {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Fragment fragment;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private volatile ArrayList<GProAudioLiveRobotStatusRspInfo> mBotStatusInfos;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GuildMediaFacesController mController;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> mPlayerColumn;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean needIgnoreSelf;

    /* renamed from: N, reason: from kotlin metadata */
    private int containerWidth;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final Lazy mOffset;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final HashMap<Integer, Integer> mItemViewHeightMap;

    public BaseMediaUserDelegateAdapter(@NotNull Fragment fragment) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.fragment = fragment;
        this.mPlayerColumn = new e12.e<>(1);
        this.containerWidth = x.f(BaseApplication.getContext()).b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter$mOffset$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(com.tencent.mobileqq.guild.media.widget.adapter.c.f229813a * 2);
            }
        });
        this.mOffset = lazy;
        this.mItemViewHeightMap = new HashMap<>();
        v0();
    }

    private final void m0(List<GProAudioLiveRobotStatusRspInfo> updateStatusList) {
        Boolean bool;
        int i3;
        for (GProAudioLiveRobotStatusRspInfo gProAudioLiveRobotStatusRspInfo : updateStatusList) {
            GuildMediaFacesController guildMediaFacesController = this.mController;
            if (guildMediaFacesController != null) {
                bool = Boolean.valueOf(guildMediaFacesController.h(gProAudioLiveRobotStatusRspInfo));
            } else {
                bool = null;
            }
            QLog.d(getTag(), 4, "diffPrevStatus " + bool);
            if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                String valueOf = String.valueOf(gProAudioLiveRobotStatusRspInfo.botId);
                Iterator it = getItems().iterator();
                while (true) {
                    if (it.hasNext()) {
                        rt1.a aVar = (rt1.a) it.next();
                        if ((aVar instanceof MediaPlayerRobotUserItem) && (aVar instanceof MediaViewerRobotItem) && Intrinsics.areEqual(((MediaPlayerRobotUserItem) aVar).getUserInfo().f228093a, valueOf)) {
                            i3 = getItems().indexOf(aVar);
                            break;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 >= 0 && i3 < getItems().size()) {
                    QLog.d(getTag(), 4, "notifyItemChanged " + i3);
                    notifyItemChanged(i3, gProAudioLiveRobotStatusRspInfo);
                }
            }
        }
        ArrayList<GProAudioLiveRobotStatusRspInfo> arrayList = this.mBotStatusInfos;
        if (arrayList != null) {
            arrayList.addAll(updateStatusList);
        }
    }

    private final int p0() {
        return ((Number) this.mOffset.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s0(BaseMediaUserDelegateAdapter this$0, List updateStatusList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(updateStatusList, "$updateStatusList");
        this$0.m0(updateStatusList);
    }

    private final void v0() {
        if (AppSetting.t(this.fragment.getContext()) && com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT) {
            this.containerWidth = GuildSplitViewUtils.f235370a.i(true, this.fragment.getContext());
        }
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.adapter.d
    public void Z(@NotNull final List<GProAudioLiveRobotStatusRspInfo> updateStatusList) {
        Intrinsics.checkNotNullParameter(updateStatusList, "updateStatusList");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.media.widget.user.adapter.a
            @Override // java.lang.Runnable
            public final void run() {
                BaseMediaUserDelegateAdapter.s0(BaseMediaUserDelegateAdapter.this, updateStatusList);
            }
        });
    }

    @NotNull
    public abstract String getTag();

    public final int l0() {
        int p06;
        w.c("calculateHeight");
        int r06 = r0();
        if (this.mItemViewHeightMap.containsKey(Integer.valueOf(r06))) {
            Integer num = this.mItemViewHeightMap.get(Integer.valueOf(r06));
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            w.d();
            return intValue;
        }
        if (r06 == 1) {
            p06 = this.containerWidth - p0();
        } else {
            p06 = (((this.containerWidth - p0()) - (com.tencent.mobileqq.guild.media.widget.adapter.c.f229814b * (r06 - 1))) / r06) + 2;
        }
        this.mItemViewHeightMap.put(Integer.valueOf(r06), Integer.valueOf(p06));
        w.d();
        return p06;
    }

    public final void n0() {
        GuildMediaFacesController guildMediaFacesController;
        IGProGuildInfo guildInfo = j.a().getGuildInfo();
        IGProChannelInfo channelInfo = j.a().getChannelInfo();
        if (this.mBotStatusInfos != null) {
            ArrayList<GProAudioLiveRobotStatusRspInfo> arrayList = this.mBotStatusInfos;
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.isEmpty()) {
                return;
            }
        }
        if (guildInfo != null && channelInfo != null && (guildMediaFacesController = this.mController) != null) {
            guildMediaFacesController.i(MobileQQ.sMobileQQ.peekAppRuntime(), bv.b(guildInfo.getGuildID(), 0L), bv.b(channelInfo.getChannelUin(), 0L));
        }
    }

    @Nullable
    public final GProAudioLiveRobotStatusRspInfo o0(long botId) {
        boolean z16;
        ArrayList<GProAudioLiveRobotStatusRspInfo> arrayList = this.mBotStatusInfos;
        Object obj = null;
        if (arrayList == null) {
            return null;
        }
        Iterator<T> it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((GProAudioLiveRobotStatusRspInfo) next).botId == botId) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                obj = next;
                break;
            }
        }
        return (GProAudioLiveRobotStatusRspInfo) obj;
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.adapter.e, com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.mController = new GuildMediaFacesController(recyclerView, this);
    }

    @Override // com.tencent.mobileqq.guild.widget.adapterdelegates.d, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        GuildMediaFacesController guildMediaFacesController = this.mController;
        if (guildMediaFacesController != null) {
            guildMediaFacesController.g(true);
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    /* renamed from: q0, reason: from getter */
    public final boolean getNeedIgnoreSelf() {
        return this.needIgnoreSelf;
    }

    public final int r0() {
        Integer value = this.mPlayerColumn.getValue();
        if (value == null) {
            return 1;
        }
        return value.intValue();
    }

    public final void t0(boolean z16) {
        this.needIgnoreSelf = z16;
    }

    public final void u0(int column) {
        this.mPlayerColumn.setValue(Integer.valueOf(column));
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.adapter.d
    @NotNull
    public List<GProAudioLiveRobotStatusRspInfo> v() {
        List<GProAudioLiveRobotStatusRspInfo> emptyList;
        ArrayList<GProAudioLiveRobotStatusRspInfo> arrayList = this.mBotStatusInfos;
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList;
    }
}
