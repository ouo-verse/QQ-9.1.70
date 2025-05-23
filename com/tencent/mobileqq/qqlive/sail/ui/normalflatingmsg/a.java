package com.tencent.mobileqq.qqlive.sail.ui.normalflatingmsg;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.base.d;
import com.tencent.timi.game.liveroom.impl.room.message.stack.NormalFloatingBannerLogic;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0006R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/normalflatingmsg/a;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Landroid/content/Context;", "context", "Landroid/widget/FrameLayout;", ParseCommon.CONTAINER, "", "M1", "", MiniChatConstants.MINI_APP_LANDSCAPE, "P1", "", "roomId", "anchorId", "N1", "O1", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic;", "i", "Lcom/tencent/timi/game/liveroom/impl/room/message/stack/NormalFloatingBannerLogic;", "normalFloatingBannerLogic", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_floatingBannerLogicLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "L1", "()Landroidx/lifecycle/LiveData;", "floatingBannerLogicLiveData", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class a extends d {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<NormalFloatingBannerLogic> floatingBannerLogicLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NormalFloatingBannerLogic normalFloatingBannerLogic;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<NormalFloatingBannerLogic> _floatingBannerLogicLiveData;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.normalFloatingBannerLogic = new NormalFloatingBannerLogic();
        MutableLiveData<NormalFloatingBannerLogic> mutableLiveData = new MutableLiveData<>();
        this._floatingBannerLogicLiveData = mutableLiveData;
        this.floatingBannerLogicLiveData = mutableLiveData;
    }

    @NotNull
    public final LiveData<NormalFloatingBannerLogic> L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.floatingBannerLogicLiveData;
    }

    public final void M1(@NotNull Context context, @NotNull FrameLayout container) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) container);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(container, "container");
        this.normalFloatingBannerLogic.h(context, container);
    }

    public final void N1(long roomId, long anchorId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(roomId), Long.valueOf(anchorId));
        } else {
            this.normalFloatingBannerLogic.j(roomId, anchorId);
            this._floatingBannerLogicLiveData.setValue(this.normalFloatingBannerLogic);
        }
    }

    public final void O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.normalFloatingBannerLogic.k();
        }
    }

    public final void P1(boolean isLandscape) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, isLandscape);
        } else {
            this.normalFloatingBannerLogic.i(isLandscape);
        }
    }
}
