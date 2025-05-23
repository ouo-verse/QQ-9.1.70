package com.tencent.mobileqq.wink.picker.qcircle.viewmodel;

import android.os.CountDownTimer;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0002R$\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "T1", "S1", "", "getLogTag", "", "newState", "P1", "Q1", "", "<set-?>", "i", "Z", "N1", "()Z", "inspirationTipsBubbleHasEverShown", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isMediaListScrolled", "", BdhLogUtil.LogTag.Tag_Conn, "J", WadlProxyConsts.CREATE_TIME, "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "D", "Ljava/util/List;", "getSelectedMedia", "()Ljava/util/List;", "R1", "(Ljava/util/List;)V", "selectedMedia", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_showInspirationTipsBubbleLiveData", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "showInspirationTipsBubbleLiveData", "<init>", "()V", "G", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final long createTime = System.currentTimeMillis();

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private List<? extends LocalMediaInfo> selectedMedia;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _showInspirationTipsBubbleLiveData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> showInspirationTipsBubbleLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean inspirationTipsBubbleHasEverShown;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isMediaListScrolled;

    public a() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this._showInspirationTipsBubbleLiveData = mutableLiveData;
        this.showInspirationTipsBubbleLiveData = mutableLiveData;
        this.inspirationTipsBubbleHasEverShown = k.a().c("key_inspiration_tips_bubble_has_ever_shown", false);
        S1();
    }

    private final void S1() {
        new b().start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T1() {
        boolean z16;
        if (!this.inspirationTipsBubbleHasEverShown && System.currentTimeMillis() - this.createTime > 5000) {
            List<? extends LocalMediaInfo> list = this.selectedMedia;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                this.inspirationTipsBubbleHasEverShown = true;
                this._showInspirationTipsBubbleLiveData.postValue(Integer.valueOf(R.string.f241217r_));
            }
        }
    }

    /* renamed from: N1, reason: from getter */
    public final boolean getInspirationTipsBubbleHasEverShown() {
        return this.inspirationTipsBubbleHasEverShown;
    }

    @NotNull
    public final LiveData<Integer> O1() {
        return this.showInspirationTipsBubbleLiveData;
    }

    public final void P1(int newState) {
        if (newState == 1) {
            this.isMediaListScrolled = true;
            T1();
        }
    }

    public final void Q1() {
        k.a().j("key_inspiration_tips_bubble_has_ever_shown", true);
    }

    public final void R1(@Nullable List<? extends LocalMediaInfo> list) {
        this.selectedMedia = list;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "QCircleMediaPickerTipsViewModel";
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/viewmodel/a$b", "Landroid/os/CountDownTimer;", "", "l", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends CountDownTimer {
        b() {
            super(5000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (a.this.isMediaListScrolled) {
                a.this.T1();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long l3) {
        }
    }
}
