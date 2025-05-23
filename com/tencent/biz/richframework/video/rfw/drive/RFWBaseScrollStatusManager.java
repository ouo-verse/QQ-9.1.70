package com.tencent.biz.richframework.video.rfw.drive;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.view.RFWVideoView;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class RFWBaseScrollStatusManager extends RecyclerView.OnScrollListener implements IRFWLayerScrollerStatus {
    protected final IRFWViewPager2AdapterDrive mAdapter;
    protected RFWFeedSelectInfo mFeedSelectInfo;
    protected RFWFeedSelectInfo mFeedUnSelectInfo;
    private LifecycleObserver mLifecycleObserver;
    protected final String mPageId;
    protected HashSet<RecyclerView.ViewHolder> mHolderSet = new HashSet<>();
    protected ArrayList<RFWLayerBaseScroller> mScrollerList = new ArrayList<>();
    protected int mCurrentFeedPos = -1;
    private String mLastPrintMsg = "";

    /* compiled from: P */
    /* renamed from: com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager$2, reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$lifecycle$Lifecycle$Event;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            $SwitchMap$androidx$lifecycle$Lifecycle$Event = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$androidx$lifecycle$Lifecycle$Event[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public RFWBaseScrollStatusManager(String str, IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive) {
        this.mPageId = str;
        this.mAdapter = iRFWViewPager2AdapterDrive;
        initLifecycle();
    }

    private boolean businessNotNeedRelease(RFWPlayerOptions rFWPlayerOptions) {
        if (rFWPlayerOptions != null && rFWPlayerOptions.getIOC() != null && rFWPlayerOptions.getIOC().getUpperData() != null) {
            Object value = rFWPlayerOptions.getIOC().getUpperData().getValue("KEY_NOT_NEED_RELEASE_PLAYER");
            if (value instanceof Boolean) {
                return ((Boolean) value).booleanValue();
            }
        }
        return false;
    }

    private void checkFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        if (!uq3.c.j()) {
            RFWLog.d("RFWBaseScrollStatusManager" + this.mPageId, 1, "checkFeedUnSelected() close");
            return;
        }
        RFWFeedSelectInfo rFWFeedSelectInfo2 = this.mFeedSelectInfo;
        if (rFWFeedSelectInfo2 == null) {
            RFWLog.d("RFWBaseScrollStatusManager" + this.mPageId, 1, "feed selected is empty return");
            return;
        }
        Object obj5 = "";
        if (this.mFeedUnSelectInfo == null) {
            if (rFWFeedSelectInfo2.getSelectedTag().equals(rFWFeedSelectInfo.getSelectedTag())) {
                RFWLog.d("RFWBaseScrollStatusManager" + this.mPageId, 1, "checkFeedUnSelected() equal tag return: | selectInfo = " + getSelectInfoString(this.mFeedSelectInfo) + " | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
                return;
            }
            RecyclerView.ViewHolder selectedHolder = this.mFeedSelectInfo.getSelectedHolder();
            String str = "RFWBaseScrollStatusManager" + this.mPageId;
            Object[] objArr = new Object[1];
            StringBuilder sb5 = new StringBuilder();
            sb5.append("checkFeedUnSelected() try to dispatch1 | selectInfo = ");
            sb5.append(getSelectInfoString(this.mFeedSelectInfo));
            sb5.append(" | holderHashcode:");
            if (selectedHolder == null) {
                obj4 = "";
            } else {
                obj4 = Integer.valueOf(selectedHolder.hashCode());
            }
            sb5.append(obj4);
            sb5.append(" | holder = ");
            if (selectedHolder != null) {
                obj5 = selectedHolder;
            }
            sb5.append(obj5);
            objArr[0] = sb5.toString();
            RFWLog.d(str, 1, objArr);
            notifyItemViewOnFeedUnSelected(this.mFeedSelectInfo.getSelectedHolder(), this.mFeedSelectInfo, "TYPE_UNSELECTED_CHECK");
            return;
        }
        if (!rFWFeedSelectInfo2.getSelectedTag().equals(this.mFeedUnSelectInfo.getUnSelectedTag())) {
            RecyclerView.ViewHolder selectedHolder2 = this.mFeedSelectInfo.getSelectedHolder();
            String str2 = "RFWBaseScrollStatusManager" + this.mPageId;
            Object[] objArr2 = new Object[1];
            StringBuilder sb6 = new StringBuilder();
            sb6.append("checkFeedUnSelected() try to dispatch2 | selectInfo = ");
            sb6.append(getSelectInfoString(this.mFeedSelectInfo));
            sb6.append(" | holderHashcode:");
            if (selectedHolder2 == null) {
                obj3 = "";
            } else {
                obj3 = Integer.valueOf(selectedHolder2.hashCode());
            }
            sb6.append(obj3);
            sb6.append(" | holder = ");
            if (selectedHolder2 != null) {
                obj5 = selectedHolder2;
            }
            sb6.append(obj5);
            objArr2[0] = sb6.toString();
            RFWLog.d(str2, 1, objArr2);
            notifyItemViewOnFeedUnSelected(this.mFeedSelectInfo.getSelectedHolder(), this.mFeedSelectInfo, "TYPE_UNSELECTED_CHECK");
            return;
        }
        RecyclerView.ViewHolder selectedHolder3 = this.mFeedSelectInfo.getSelectedHolder();
        if (uq3.c.O5() && !checkModifyDataHolderEquals(getInfoTag(selectedHolder3))) {
            String str3 = "RFWBaseScrollStatusManager" + this.mPageId;
            Object[] objArr3 = new Object[1];
            StringBuilder sb7 = new StringBuilder();
            sb7.append("checkFeedUnSelected() try to dispatch3 | selectInfo = ");
            sb7.append(getSelectInfoString(this.mFeedSelectInfo));
            sb7.append(" | holderHashcode:");
            if (selectedHolder3 == null) {
                obj2 = "";
            } else {
                obj2 = Integer.valueOf(selectedHolder3.hashCode());
            }
            sb7.append(obj2);
            sb7.append(" | holder = ");
            if (selectedHolder3 != null) {
                obj5 = selectedHolder3;
            }
            sb7.append(obj5);
            objArr3[0] = sb7.toString();
            RFWLog.d(str3, 1, objArr3);
            notifyItemViewOnFeedUnSelected(this.mFeedSelectInfo.getSelectedHolder(), this.mFeedSelectInfo, "TYPE_UNSELECTED_CHECK");
            return;
        }
        String str4 = "RFWBaseScrollStatusManager" + this.mPageId;
        Object[] objArr4 = new Object[1];
        StringBuilder sb8 = new StringBuilder();
        sb8.append("checkFeedUnSelected() not need dispatch | selectInfo = ");
        sb8.append(getSelectInfoString(this.mFeedSelectInfo));
        sb8.append(" | holderHashcode:");
        if (selectedHolder3 == null) {
            obj = "";
        } else {
            obj = Integer.valueOf(selectedHolder3.hashCode());
        }
        sb8.append(obj);
        sb8.append(" | holder = ");
        if (selectedHolder3 != null) {
            obj5 = selectedHolder3;
        }
        sb8.append(obj5);
        objArr4[0] = sb8.toString();
        RFWLog.d(str4, 1, objArr4);
    }

    private boolean checkModifyDataHolderEquals(String str) {
        if (!uq3.c.O5() || this.mFeedSelectInfo == null || TextUtils.isEmpty(str) || !TextUtils.equals(getInfoTag(this.mFeedSelectInfo.getSelectedHolder()), str) || this.mFeedSelectInfo.getSelectedTag().contains(getShareFake())) {
            return false;
        }
        QLog.e("RFWBaseScrollStatusManager", 1, "[checkModifyDataHolderEquals] tag: " + str + " | mFeedSelectInfo#tag: " + this.mFeedSelectInfo.getSelectedTag() + ", use new tag equals.");
        return true;
    }

    private void clearUnSelectedTag() {
        if (!uq3.c.k()) {
            return;
        }
        RFWFeedSelectInfo rFWFeedSelectInfo = this.mFeedSelectInfo;
        if (rFWFeedSelectInfo != null) {
            rFWFeedSelectInfo.updateUnSelectedTag("");
        }
        RFWFeedSelectInfo rFWFeedSelectInfo2 = this.mFeedUnSelectInfo;
        if (rFWFeedSelectInfo2 != null) {
            rFWFeedSelectInfo2.updateUnSelectedTag("");
        }
        QLog.e("RFWBaseScrollStatusManager", 1, "clearUnSelectedTag: " + getSelectInfoString(this.mFeedSelectInfo));
    }

    private String correctedUnSelectedTag(RecyclerView.ViewHolder viewHolder, String str) {
        RFWFeedSelectInfo rFWFeedSelectInfo = this.mFeedSelectInfo;
        String str2 = "";
        if (rFWFeedSelectInfo != null && rFWFeedSelectInfo.getSelectedHolder() != null && viewHolder != null) {
            if (rFWFeedSelectInfo.getSelectedHolder().hashCode() == viewHolder.hashCode()) {
                String str3 = "RFWBaseScrollStatusManager" + this.mPageId;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fs_lifecycle correctedUnSelectedTag return selected tag:");
                sb5.append(rFWFeedSelectInfo.getSelectedTag());
                sb5.append(" | old tag-1:");
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                sb5.append(str);
                QLog.i(str3, 1, sb5.toString());
                return rFWFeedSelectInfo.getSelectedTag();
            }
            String str4 = "RFWBaseScrollStatusManager" + this.mPageId;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("fs_lifecycle correctedUnSelectedTag return old tag-2:");
            if (!TextUtils.isEmpty(str)) {
                str2 = str;
            }
            sb6.append(str2);
            QLog.i(str4, 1, sb6.toString());
            return str;
        }
        String str5 = "RFWBaseScrollStatusManager" + this.mPageId;
        StringBuilder sb7 = new StringBuilder();
        sb7.append("fs_lifecycle correctedUnSelectedTag return old tag:");
        if (!TextUtils.isEmpty(str)) {
            str2 = str;
        }
        sb7.append(str2);
        QLog.i(str5, 1, sb7.toString());
        return str;
    }

    @NotNull
    private String getInfoTag(@NonNull RecyclerView.ViewHolder viewHolder) {
        int adapterPosition = viewHolder.getAdapterPosition();
        return adapterPosition + "_" + viewHolder.hashCode() + "_" + this.mAdapter.getDataSingleKey(adapterPosition);
    }

    private LifecycleEventObserver getLifecycleCallBack() {
        return new LifecycleEventObserver() { // from class: com.tencent.biz.richframework.video.rfw.drive.RFWBaseScrollStatusManager.1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                String str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("fs_lifecycle onStateChanged:");
                sb5.append(event);
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
                if (RFWBaseScrollStatusManager.this.mAdapter.getUniquePageId() != null) {
                    str = RFWBaseScrollStatusManager.this.mAdapter.getUniquePageId();
                } else {
                    str = "";
                }
                sb5.append(str);
                sb5.append(APLogFileUtil.SEPARATOR_LOG);
                sb5.append(hashCode());
                QLog.d("RFWBaseScrollStatusManager", 1, sb5.toString());
                RFWFeedSelectInfo selectedType = new RFWFeedSelectInfo(RFWBaseScrollStatusManager.this.mCurrentFeedPos).setSelectedType(event.name());
                int i3 = AnonymousClass2.$SwitchMap$androidx$lifecycle$Lifecycle$Event[event.ordinal()];
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 6) {
                                    RFWBaseScrollStatusManager.this.onDestroy();
                                    return;
                                }
                                return;
                            }
                            RFWBaseScrollStatusManager.this.onStop(selectedType);
                            return;
                        }
                        RFWBaseScrollStatusManager.this.onPaused(selectedType);
                        return;
                    }
                    RFWBaseScrollStatusManager.this.onResumed(selectedType);
                    return;
                }
                RFWBaseScrollStatusManager.this.onStart(selectedType);
            }
        };
    }

    private void initLifecycle() {
        if (this.mAdapter.getHostFragment() == null) {
            if (!RFWApplication.isDebug()) {
                QLog.d("RFWBaseScrollStatusManager", 1, "fs_lifecycle initLifecycle empty fragment");
                return;
            }
            throw new RuntimeException("please invoke setHostFragment method");
        }
        if (!uq3.c.U()) {
            QLog.d("RFWBaseScrollStatusManager", 1, "fs_lifecycle initLifecycle WNS close");
        } else {
            this.mLifecycleObserver = getLifecycleCallBack();
            this.mAdapter.getHostFragment().getLifecycle().addObserver(this.mLifecycleObserver);
        }
    }

    private boolean isReselected(@NonNull RFWFeedSelectInfo rFWFeedSelectInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        if (this.mFeedSelectInfo == null) {
            return false;
        }
        if (TextUtils.equals(rFWFeedSelectInfo.getSelectedType(), "TYPE_SELECT_TRIGGER_FEED_REPLACE")) {
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "getSelectedType is TYPE_SELECT_TRIGGER_FEED_REPLACE");
            return false;
        }
        String infoTag = getInfoTag(viewHolder);
        rFWFeedSelectInfo.updateSelectedTag(infoTag);
        RFWFeedSelectInfo rFWFeedSelectInfo2 = this.mFeedUnSelectInfo;
        if (rFWFeedSelectInfo2 != null && rFWFeedSelectInfo2.getUnSelectedTag().equals(infoTag)) {
            QLog.e("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle notifyItemViewOnFeedSelected judge not reselected ,  | mFeedUnSelectInfo = " + getSelectInfoString(this.mFeedUnSelectInfo) + " | mNewSelectedInfo = " + getSelectInfoString(rFWFeedSelectInfo) + " | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
            return false;
        }
        return infoTag.equals(this.mFeedSelectInfo.getSelectedTag());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyAdapterOnSelected$1(int i3, String str, boolean z16) {
        onFeedSelected(new RFWFeedSelectInfo(i3).setSelectedType(str).setIsScrollToNext(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$notifyAdapterOnUnselected$0(int i3, int i16) {
        onFeedUnSelected(new RFWFeedSelectInfo(i3).setNextPosition(i16).setUnSelectedType("TYPE_UNSELECTED_NORMAL"));
    }

    private void notifyFeedUnSelectedByDataRefresh() {
        RFWFeedSelectInfo rFWFeedSelectInfo = this.mFeedSelectInfo;
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RecyclerView.ViewHolder selectedHolder = rFWFeedSelectInfo.getSelectedHolder();
        if (!this.mAdapter.getDataSingleKey(this.mFeedSelectInfo.getPosition()).startsWith(getShareFake())) {
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle notifyFeedUnSelectedByDataRefresh | selectInfo = " + getSelectInfoString(this.mFeedSelectInfo) + " | holderHashcode:" + selectedHolder.hashCode() + " | holder = " + selectedHolder);
            notifyItemViewOnFeedUnSelected(this.mFeedSelectInfo.getSelectedHolder(), this.mFeedSelectInfo, "TYPE_UNSELECTED_DATA_REFRESH");
        }
    }

    private void notifyScrollsSelected(@NonNull RFWFeedSelectInfo rFWFeedSelectInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        Iterator<RFWLayerBaseScroller> it = this.mScrollerList.iterator();
        while (it.hasNext()) {
            RFWLayerBaseScroller next = it.next();
            if (rFWFeedSelectInfo.isIsReselected()) {
                if (next.needReceiveSelectedAnyWay()) {
                    next.onSelected(rFWFeedSelectInfo, viewHolder);
                }
            } else {
                next.onSelected(rFWFeedSelectInfo, viewHolder);
            }
        }
    }

    private void notifyTargetHolderSelected(@NonNull RFWFeedSelectInfo rFWFeedSelectInfo, @NonNull RecyclerView.ViewHolder viewHolder) {
        checkFeedUnSelected(rFWFeedSelectInfo, viewHolder);
        if (this.mFeedSelectInfo == null) {
            this.mFeedSelectInfo = new RFWFeedSelectInfo(viewHolder.getAdapterPosition());
            rFWFeedSelectInfo.updateSelectedTag(getInfoTag(viewHolder));
        }
        this.mFeedSelectInfo.copy(rFWFeedSelectInfo);
        if (TextUtils.isEmpty(this.mFeedSelectInfo.getSelectedTag())) {
            this.mFeedSelectInfo.updateSelectedTag(getInfoTag(viewHolder));
        }
        this.mFeedSelectInfo.setSelectedHolder(viewHolder);
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle notifyItemViewOnFeedSelected , really dispatch  | selectInfo = " + getSelectInfoString(this.mFeedSelectInfo) + " | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
        if (viewHolder.itemView instanceof IRFWLayerScrollerStatus) {
            clearUnSelectedTag();
            this.mCurrentFeedPos = viewHolder.getAdapterPosition();
            ((IRFWLayerScrollerStatus) viewHolder.itemView).onFeedSelected(rFWFeedSelectInfo);
        } else {
            QLog.e("RFWBaseScrollStatusManager", 1, "SFV-[notifyTargetHolderSelected] item view: " + viewHolder.itemView + " not is IQFSLayerScrollerStatus, not call selected.");
        }
    }

    private void notifyTargetHolderUnSelected(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RFWFeedSelectInfo rFWFeedSelectInfo, @NotNull String str, @NotNull String str2) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enabel_correct_un_selected_info_tag", true)) {
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle notifyTargetHolderUnSelected , really dispatch can correct unSelected info");
            str2 = correctedUnSelectedTag(viewHolder, str2);
        }
        this.mFeedUnSelectInfo.copy(rFWFeedSelectInfo);
        this.mFeedUnSelectInfo.updateUnSelectedTag(str2);
        this.mFeedUnSelectInfo.setUnSelectedType(str);
        this.mFeedUnSelectInfo.setSelectedHolder(viewHolder);
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle notifyTargetHolderUnSelected , really dispatch  | unselectInfo = " + getSelectInfoString(this.mFeedUnSelectInfo) + " | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
        tryReleasePlayer(viewHolder);
        ((IRFWLayerItemViewScrollerStatus) viewHolder.itemView).onFeedUnSelected(this.mFeedUnSelectInfo);
    }

    private boolean shouldNotifyReselected(@NonNull RecyclerView.ViewHolder viewHolder) {
        return this.mAdapter.showReNotify(viewHolder);
    }

    private void tryReleasePlayer(RecyclerView.ViewHolder viewHolder) {
        View view;
        RFWVideoView rFWVideoView;
        if (viewHolder != null && (view = viewHolder.itemView) != null) {
            View findViewById = view.findViewById(R.id.f74163vi);
            if (findViewById instanceof RFWVideoView) {
                rFWVideoView = (RFWVideoView) findViewById;
            } else {
                KeyEvent.Callback callback = viewHolder.itemView;
                if (callback instanceof IRFWLayerItemViewScrollerStatus) {
                    rFWVideoView = ((IRFWLayerItemViewScrollerStatus) callback).getVideoView();
                } else {
                    rFWVideoView = null;
                }
            }
            if (rFWVideoView == null || rFWVideoView.getQCirclePlayer() == null || businessNotNeedRelease(rFWVideoView.getQCirclePlayer().getRFWPlayerOptions())) {
                return;
            }
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle release player  | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
            rFWVideoView.release();
        }
    }

    public void addScroller(RFWLayerBaseScroller rFWLayerBaseScroller) {
        ArrayList<RFWLayerBaseScroller> arrayList = this.mScrollerList;
        if (arrayList != null && rFWLayerBaseScroller != null) {
            if (arrayList.contains(rFWLayerBaseScroller)) {
                QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle repeat addScroller :" + rFWLayerBaseScroller);
                return;
            }
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle addScroller :" + rFWLayerBaseScroller + ",all size:" + this.mScrollerList.size());
            this.mScrollerList.add(rFWLayerBaseScroller);
        }
    }

    public void addViewHolder(RecyclerView.ViewHolder viewHolder) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && viewHolder != null) {
            if (!hashSet.contains(viewHolder)) {
                this.mHolderSet.add(viewHolder);
                notifyScrollerChangeHolder();
            }
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle addViewHolder  holderNum = " + this.mHolderSet.size() + " | holder.getAdapterPosition() = " + viewHolder.getAdapterPosition() + " | mFeedSelectInfo = " + getSelectInfoString(this.mFeedSelectInfo) + " | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
            KeyEvent.Callback callback = viewHolder.itemView;
            if (callback instanceof IRFWLayerItemViewScrollerStatus) {
                ((IRFWLayerItemViewScrollerStatus) callback).onViewHolderAttachedToWindow(viewHolder);
            }
        }
    }

    public void bindViewHolder(RecyclerView.ViewHolder viewHolder) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && viewHolder != null) {
            if (!hashSet.contains(viewHolder)) {
                this.mHolderSet.add(viewHolder);
                notifyScrollerChangeHolder();
            }
            QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle bindViewHolder  holderNum = " + this.mHolderSet.size() + " | holder.getAdapterPosition() = " + viewHolder.getAdapterPosition() + " | holderHashCode: " + viewHolder.hashCode() + " | mFeedSelectInfo = " + getSelectInfoString(this.mFeedSelectInfo));
            if (getTargetItemPosition() == viewHolder.getAdapterPosition()) {
                QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle bindViewHolder hit target , try faster dispatch");
                notifyItemViewOnFeedSelected(new RFWFeedSelectInfo(viewHolder.getAdapterPosition()).setSelectedType("TYPE_SELECT_ADAPTER_BIND_HOLDER"), viewHolder);
            }
        }
    }

    protected String getSelectInfoString(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return "";
        }
        return rFWFeedSelectInfo.toString();
    }

    @NonNull
    protected String getShareFake() {
        return "share_fake_";
    }

    public abstract int getTargetItemPosition();

    /* JADX INFO: Access modifiers changed from: protected */
    public RecyclerView.ViewHolder getViewHolder(int i3) {
        IRFWViewPager2AdapterDrive iRFWViewPager2AdapterDrive = this.mAdapter;
        if (iRFWViewPager2AdapterDrive != null) {
            return iRFWViewPager2AdapterDrive.finViewHolderByPos(i3);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAdapterOnSelected(final int i3, final String str, final boolean z16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.drive.d
            @Override // java.lang.Runnable
            public final void run() {
                RFWBaseScrollStatusManager.this.lambda$notifyAdapterOnSelected$1(i3, str, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyAdapterOnUnselected(final int i3, final int i16) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.drive.e
            @Override // java.lang.Runnable
            public final void run() {
                RFWBaseScrollStatusManager.this.lambda$notifyAdapterOnUnselected$0(i3, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyItemViewOnFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo, RecyclerView.ViewHolder viewHolder) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && hashSet.size() != 0 && this.mScrollerList != null) {
            if (viewHolder == null) {
                viewHolder = getViewHolder(rFWFeedSelectInfo.getPosition());
            }
            Iterator<RecyclerView.ViewHolder> it = this.mHolderSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.getAdapterPosition() == -1) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle notifyItemViewOnFeedSelected, holder.position == -1  | selectInfo = " + getSelectInfoString(rFWFeedSelectInfo) + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                } else if (next.getAdapterPosition() != rFWFeedSelectInfo.getPosition()) {
                    continue;
                } else if (viewHolder != null && next != viewHolder) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle notifyItemViewOnFeedSelected ,filter holder hashCode not equal target  | holderPos =" + next.getAdapterPosition() + " | selectInfo = " + getSelectInfoString(rFWFeedSelectInfo) + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                } else {
                    notifyScrollsSelected(rFWFeedSelectInfo, next);
                    if (isReselected(rFWFeedSelectInfo, next)) {
                        if (!shouldNotifyReselected(next)) {
                            String str = "fs_lifecycle notifyItemViewOnFeedSelected reselected ,  | selectInfo = " + getSelectInfoString(rFWFeedSelectInfo) + " | holderHashcode:" + next.hashCode() + " | holder = " + next;
                            if (TextUtils.equals(str, this.mLastPrintMsg)) {
                                return;
                            }
                            this.mLastPrintMsg = str;
                            QLog.e("RFWBaseScrollStatusManager" + this.mPageId, 1, str);
                        } else {
                            rFWFeedSelectInfo.setIsReselected(true);
                        }
                    } else {
                        rFWFeedSelectInfo.setIsReselected(false);
                    }
                    notifyTargetHolderSelected(rFWFeedSelectInfo, next);
                }
            }
            return;
        }
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle notifyItemViewOnFeedSelected mHolderSet == null or mScrollerList == null");
    }

    protected void notifyItemViewOnFeedUnSelected(@NotNull RecyclerView.ViewHolder viewHolder, @NotNull RFWFeedSelectInfo rFWFeedSelectInfo, String str) {
        if (!(viewHolder.itemView instanceof IRFWLayerScrollerStatus)) {
            return;
        }
        if (this.mFeedSelectInfo == null) {
            QLog.e("RFWBaseScrollStatusManager" + this.mPageId, 1, "notifyTargetHolderUnSelected\uff1a no selected info | holder:" + viewHolder);
            return;
        }
        String infoTag = getInfoTag(viewHolder);
        if (!infoTag.equals(this.mFeedSelectInfo.getSelectedTag()) && !checkModifyDataHolderEquals(infoTag)) {
            return;
        }
        RFWFeedSelectInfo rFWFeedSelectInfo2 = this.mFeedUnSelectInfo;
        if (rFWFeedSelectInfo2 == null) {
            this.mFeedUnSelectInfo = new RFWFeedSelectInfo(rFWFeedSelectInfo.getPosition());
            notifyTargetHolderUnSelected(viewHolder, rFWFeedSelectInfo, str, infoTag);
            return;
        }
        if (infoTag.equals(rFWFeedSelectInfo2.getUnSelectedTag())) {
            QLog.e("RFWBaseScrollStatusManager" + this.mPageId, 1, "notifyTargetHolderUnSelected reUnSelected," + getSelectInfoString(rFWFeedSelectInfo) + " | holder:" + viewHolder);
            return;
        }
        notifyTargetHolderUnSelected(viewHolder, rFWFeedSelectInfo, str, infoTag);
    }

    protected void notifyScrollerChangeHolder() {
        ArrayList<RFWLayerBaseScroller> arrayList = this.mScrollerList;
        if (arrayList == null) {
            return;
        }
        Iterator<RFWLayerBaseScroller> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().setHolderSet(this.mHolderSet);
        }
    }

    public void onDataRefresh() {
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onDataRefresh");
        ArrayList<RFWLayerBaseScroller> arrayList = this.mScrollerList;
        if (arrayList == null) {
            return;
        }
        Iterator<RFWLayerBaseScroller> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().onDataRefresh();
        }
        notifyFeedUnSelectedByDataRefresh();
        notifyItemViewOnFeedSelected(new RFWFeedSelectInfo(0).setSelectedType("TYPE_UNSELECTED_DATA_REFRESH"), getViewHolder(0));
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onDestroy() {
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onDestroy");
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.itemView instanceof IRFWLayerScrollerStatus) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onDestroy  | holderHashcode:" + next.hashCode() + " | holder = " + next);
                    tryReleasePlayer(next);
                    ((IRFWLayerScrollerStatus) next.itemView).onDestroy();
                }
            }
            Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
            while (it5.hasNext()) {
                it5.next().onDestroy();
            }
            this.mHolderSet = null;
            this.mScrollerList = null;
            LifecycleObserver lifecycleObserver = this.mLifecycleObserver;
            Fragment hostFragment = this.mAdapter.getHostFragment();
            if (lifecycleObserver != null && hostFragment != null) {
                hostFragment.getLifecycle().removeObserver(lifecycleObserver);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onFeedPageScrolled(int i3, float f16, int i16) {
        b.b(this, i3, f16, i16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        if (rFWFeedSelectInfo == null) {
            return;
        }
        RFWFeedSelectInfo rFWFeedSelectInfo2 = this.mFeedSelectInfo;
        if (rFWFeedSelectInfo2 != null && rFWFeedSelectInfo2.getPosition() == rFWFeedSelectInfo.getPosition()) {
            rFWFeedSelectInfo.setIsReselected(true);
        } else {
            rFWFeedSelectInfo.setIsReselected(false);
        }
        notifyItemViewOnFeedSelected(rFWFeedSelectInfo, null);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onFeedUnSelected(RFWFeedSelectInfo rFWFeedSelectInfo) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null && rFWFeedSelectInfo != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.getAdapterPosition() != rFWFeedSelectInfo.getPosition()) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onFeedUnSelected  holder.getAdapterPosition() != selectInfo.getPosition() | selectInfo = " + rFWFeedSelectInfo + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                } else {
                    notifyItemViewOnFeedUnSelected(next, rFWFeedSelectInfo, rFWFeedSelectInfo.getUnSelectedType());
                    Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
                    while (it5.hasNext()) {
                        it5.next().onUnSelected(rFWFeedSelectInfo, next);
                    }
                }
            }
            return;
        }
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onFeedUnSelected mHolderSet == null or mScrollerList == null. mHolderSet =" + this.mHolderSet + ", mScrollerList =" + this.mScrollerList + ", selectInfo =" + rFWFeedSelectInfo);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onLoadFeedExport(int i3, int i16) {
        b.c(this, i3, i16);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPageScrolledIdle(int i3) {
        b.d(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onPaused(RFWFeedSelectInfo rFWFeedSelectInfo) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.itemView instanceof IRFWLayerScrollerStatus) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onPaused  | selectInfo = " + rFWFeedSelectInfo + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                    ((IRFWLayerScrollerStatus) next.itemView).onPaused(rFWFeedSelectInfo);
                }
            }
            Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
            while (it5.hasNext()) {
                it5.next().onPaused(rFWFeedSelectInfo);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public /* synthetic */ void onPosUpdate(int i3) {
        b.f(this, i3);
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onResumed(RFWFeedSelectInfo rFWFeedSelectInfo) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.itemView instanceof IRFWLayerScrollerStatus) {
                    if (next.getAdapterPosition() == -1) {
                        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onResumed , holder.position == -1  | selectInfo = " + rFWFeedSelectInfo + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                    } else {
                        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_update_holder_poi_when_resume", true);
                        if (isSwitchOn) {
                            ((IRFWLayerScrollerStatus) next.itemView).onPosUpdate(next.getAdapterPosition());
                        }
                        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onResumed  | selectInfo = " + rFWFeedSelectInfo + " | holderHashcode:" + next.hashCode() + " | holder = " + next + " | updatePoi:" + isSwitchOn);
                        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_only_on_screen_holder_resume", true) && rFWFeedSelectInfo.getPosition() == 0 && getViewHolder(rFWFeedSelectInfo.getPosition()) == next) {
                            ((IRFWLayerScrollerStatus) next.itemView).onResumed(rFWFeedSelectInfo);
                        } else {
                            ((IRFWLayerScrollerStatus) next.itemView).onResumed(rFWFeedSelectInfo);
                        }
                    }
                }
            }
            Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
            while (it5.hasNext()) {
                RFWLayerBaseScroller next2 = it5.next();
                RFWFeedSelectInfo rFWFeedSelectInfo2 = this.mFeedSelectInfo;
                if (rFWFeedSelectInfo2 == null) {
                    rFWFeedSelectInfo2 = rFWFeedSelectInfo;
                }
                next2.onResumed(rFWFeedSelectInfo2);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStart(RFWFeedSelectInfo rFWFeedSelectInfo) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.itemView instanceof IRFWLayerScrollerStatus) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onStart  | selectInfo = " + rFWFeedSelectInfo + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                    ((IRFWLayerScrollerStatus) next.itemView).onStart(rFWFeedSelectInfo);
                }
            }
            Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
            while (it5.hasNext()) {
                it5.next().onStart(rFWFeedSelectInfo);
            }
        }
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.IRFWLayerScrollerStatus
    public void onStop(RFWFeedSelectInfo rFWFeedSelectInfo) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet != null && this.mScrollerList != null) {
            Iterator<RecyclerView.ViewHolder> it = hashSet.iterator();
            while (it.hasNext()) {
                RecyclerView.ViewHolder next = it.next();
                if (next.itemView instanceof IRFWLayerScrollerStatus) {
                    QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 1, "fs_lifecycle onStop  | selectInfo = " + rFWFeedSelectInfo + " | holderHashcode:" + next.hashCode() + " | holder = " + next);
                    ((IRFWLayerScrollerStatus) next.itemView).onStop(rFWFeedSelectInfo);
                }
            }
            Iterator<RFWLayerBaseScroller> it5 = this.mScrollerList.iterator();
            while (it5.hasNext()) {
                it5.next().onStop(rFWFeedSelectInfo);
            }
        }
    }

    public void removeViewHolder(RecyclerView.ViewHolder viewHolder) {
        HashSet<RecyclerView.ViewHolder> hashSet = this.mHolderSet;
        if (hashSet == null || viewHolder == null || !hashSet.remove(viewHolder)) {
            return;
        }
        QLog.i("RFWBaseScrollStatusManager" + this.mPageId, 2, "fs_lifecycle removeViewHolder  holderNum = " + this.mHolderSet.size() + " | holder.getAdapterPosition() = " + viewHolder.getAdapterPosition() + " | mFeedSelectInfo = " + getSelectInfoString(this.mFeedSelectInfo) + " | holderHashcode:" + viewHolder.hashCode() + " | holder = " + viewHolder);
        KeyEvent.Callback callback = viewHolder.itemView;
        if (callback instanceof IRFWLayerItemViewScrollerStatus) {
            ((IRFWLayerItemViewScrollerStatus) callback).onViewHolderDetachedFromWindow(viewHolder);
            notifyItemViewOnFeedUnSelected(viewHolder, this.mFeedSelectInfo, "TYPE_UNSELECTED_REMOVE_HOLDER");
        }
    }
}
