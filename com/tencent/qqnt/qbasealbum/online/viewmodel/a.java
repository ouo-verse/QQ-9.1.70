package com.tencent.qqnt.qbasealbum.online.viewmodel;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PageType;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b3\u00104J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\"\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0014J\"\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u00102\u0006\u0010\n\u001a\u00020\tH\u0016J\u0016\u0010\u0014\u001a\u00020\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\"\u0010\u0019\u001a\u0004\b#\u0010\u001bR\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010 R&\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\u00178\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001bR#\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\r0\u00108\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u001e\u001a\u0004\b,\u0010 R,\u00102\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f0\u000b8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/online/viewmodel/a;", "Lcom/tencent/qqnt/qbasealbum/base/viewmodel/PickerBaseViewModel;", "Landroid/view/View;", "anchorView", "", "i2", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "j2", "Lcom/tencent/qqnt/qbasealbum/model/PageType;", "pageType", "Landroidx/lifecycle/MediatorLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lcom/tencent/qqnt/qbasealbum/model/LocalMediaInfo;", "W1", "Landroidx/lifecycle/LiveData;", "U1", "", "selectedMedia", "onMediaInit", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "get_switchToOnlineAssetTitleTab", "()Landroidx/lifecycle/MutableLiveData;", "_switchToOnlineAssetTitleTab", "G", "Landroidx/lifecycle/LiveData;", SemanticAttributes.DbSystemValues.H2, "()Landroidx/lifecycle/LiveData;", "switchToOnlineAssetTitleTab", "H", "get_showEntranceTipMutableLiveData", "_showEntranceTipMutableLiveData", "I", "getShowEntranceTipMutableLiveData", "showEntranceTipMutableLiveData", "J", "get_albumListUpdateLiveData", "_albumListUpdateLiveData", "K", "getAlbumListUpdateLiveData", "albumListUpdateLiveData", "L", "Landroidx/lifecycle/MediatorLiveData;", "getMediaMediatorLiveData", "()Landroidx/lifecycle/MediatorLiveData;", "mediaMediatorLiveData", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public class a extends PickerBaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _switchToOnlineAssetTitleTab;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> switchToOnlineAssetTitleTab;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<View> _showEntranceTipMutableLiveData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final LiveData<View> showEntranceTipMutableLiveData;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<String>> _albumListUpdateLiveData;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<String>> albumListUpdateLiveData;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<UIStateData<List<LocalMediaInfo>>> mediaMediatorLiveData;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._switchToOnlineAssetTitleTab = mutableLiveData;
        this.switchToOnlineAssetTitleTab = mutableLiveData;
        MutableLiveData<View> mutableLiveData2 = new MutableLiveData<>();
        this._showEntranceTipMutableLiveData = mutableLiveData2;
        this.showEntranceTipMutableLiveData = mutableLiveData2;
        MutableLiveData<List<String>> mutableLiveData3 = new MutableLiveData<>();
        this._albumListUpdateLiveData = mutableLiveData3;
        this.albumListUpdateLiveData = mutableLiveData3;
        this.mediaMediatorLiveData = new MediatorLiveData<>();
    }

    @Override // com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel
    @NotNull
    public LiveData<UIStateData<List<LocalMediaInfo>>> U1(@NotNull PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (LiveData) iPatchRedirector.redirect((short) 13, (Object) this, (Object) pageType);
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        return W1(pageType);
    }

    @Override // com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel
    @NotNull
    protected MediatorLiveData<UIStateData<List<LocalMediaInfo>>> W1(@NotNull PageType pageType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (MediatorLiveData) iPatchRedirector.redirect((short) 12, (Object) this, (Object) pageType);
        }
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        return this.mediaMediatorLiveData;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "BaseOnlineMediaViewModel";
    }

    @NotNull
    public final LiveData<Boolean> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.switchToOnlineAssetTitleTab;
    }

    public void i2(@Nullable View anchorView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) anchorView);
        }
    }

    public void j2(boolean r46) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, r46);
        }
    }

    @Override // com.tencent.qqnt.qbasealbum.base.viewmodel.PickerBaseViewModel
    public void onMediaInit(@NotNull List<LocalMediaInfo> selectedMedia) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) selectedMedia);
        } else {
            Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        }
    }
}
