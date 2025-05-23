package com.tencent.mobileqq.troop.livesync.view.trooplist;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopLiveSyncSvr$GroupInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bi\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010!\u001a\u00020\u001a\u0012\u0006\u0010$\u001a\u00020\u001a\u0012@\b\u0002\u00102\u001a:\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\f\u0018\u00010%j\u0004\u0018\u0001`+\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0014J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0014R\u0017\u0010\u0013\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\"\u0010!\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001eRZ\u00102\u001a:\u0012\u0013\u0012\u00110&\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\u0000\u00a2\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\f\u0018\u00010%j\u0004\u0018\u0001`+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/troop/livesync/view/trooplist/c;", "Lcom/tencent/mobileqq/widget/listitem/w;", "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncListItem;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "P", "view", "", "position", "", "", "payloads", "", "O", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GroupInfo;", "k", "Ltencent/trpcprotocol/TroopLiveSyncSvr$GroupInfo;", "M", "()Ltencent/trpcprotocol/TroopLiveSyncSvr$GroupInfo;", "rspInfo", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "l", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "N", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "J", "()Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Z)V", "bChoose", DomainData.DOMAIN_NAME, "K", "bEnable", "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "Lkotlin/ParameterName;", "name", "checkBox", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/troop/livesync/view/trooplist/TroopLiveSyncCheckedChangeCallback;", "o", "Lkotlin/jvm/functions/Function2;", "L", "()Lkotlin/jvm/functions/Function2;", IECSearchBar.METHOD_SET_CALLBACK, "(Lkotlin/jvm/functions/Function2;)V", "callback", "<init>", "(Ltencent/trpcprotocol/TroopLiveSyncSvr$GroupInfo;Lcom/tencent/mobileqq/data/troop/TroopInfo;ZZLkotlin/jvm/functions/Function2;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends w<TroopLiveSyncListItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopLiveSyncSvr$GroupInfo rspInfo;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TroopInfo troopInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean bChoose;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final boolean bEnable;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function2<? super CompoundButton, ? super c, Unit> callback;

    public /* synthetic */ c(TroopLiveSyncSvr$GroupInfo troopLiveSyncSvr$GroupInfo, TroopInfo troopInfo, boolean z16, boolean z17, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(troopLiveSyncSvr$GroupInfo, troopInfo, z16, z17, (i3 & 16) != 0 ? null : function2);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, troopLiveSyncSvr$GroupInfo, troopInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), function2, Integer.valueOf(i3), defaultConstructorMarker);
    }

    public final boolean J() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.bChoose;
    }

    public final boolean K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.bEnable;
    }

    @Nullable
    public final Function2<CompoundButton, c, Unit> L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Function2) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.callback;
    }

    @NotNull
    public final TroopLiveSyncSvr$GroupInfo M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopLiveSyncSvr$GroupInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.rspInfo;
    }

    @NotNull
    public final TroopInfo N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.troopInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public void F(@NotNull TroopLiveSyncListItem view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        view.d(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public TroopLiveSyncListItem H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (TroopLiveSyncListItem) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        TroopLiveSyncListItem troopLiveSyncListItem = new TroopLiveSyncListItem(context);
        troopLiveSyncListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return troopLiveSyncListItem;
    }

    public final void Q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.bChoose = z16;
        }
    }

    public c(@NotNull TroopLiveSyncSvr$GroupInfo rspInfo, @NotNull TroopInfo troopInfo, boolean z16, boolean z17, @Nullable Function2<? super CompoundButton, ? super c, Unit> function2) {
        Intrinsics.checkNotNullParameter(rspInfo, "rspInfo");
        Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, rspInfo, troopInfo, Boolean.valueOf(z16), Boolean.valueOf(z17), function2);
            return;
        }
        this.rspInfo = rspInfo;
        this.troopInfo = troopInfo;
        this.bChoose = z16;
        this.bEnable = z17;
        this.callback = function2;
    }
}
