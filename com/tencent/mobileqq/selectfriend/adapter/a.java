package com.tencent.mobileqq.selectfriend.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000 '*\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0019\u0010\u0018\u001a\u00020\u00112\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR&\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u000f0!j\b\u0012\u0004\u0012\u00020\u000f`\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/adapter/a;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "VH", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroid/view/View;", "v", "", "forwardRecentItemViewOnClick", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/selectfriend/callback/a;", "callback", "sendToNode", "", "supportMsgToNodeUinType", "", "isMultiSelect", "setMultiSelect", "isSupportShow", "getNodeType", "buildSupportForwardContentType", "forwardContentType", "isSupportCurrentForwardContentType", "(Ljava/lang/Integer;)Z", "mIsMultiSelect", "Z", "getMIsMultiSelect", "()Z", "setMIsMultiSelect", "(Z)V", ViewStickEventHelper.IS_SHOW, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mSupportForwardContentTypeSet", "Ljava/util/HashSet;", "<init>", "()V", "Companion", "a", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class a<VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final int SUPPORT_ALL_FORWARD_CONTENT_TYPE = Integer.MAX_VALUE;
    private boolean isShow;
    private boolean mIsMultiSelect;

    @NotNull
    private HashSet<Integer> mSupportForwardContentTypeSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/adapter/a$a;", "", "", "SUPPORT_ALL_FORWARD_CONTENT_TYPE", "I", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.adapter.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes18.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22534);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isShow = true;
            this.mSupportForwardContentTypeSet = new HashSet<>();
        }
    }

    public void buildSupportForwardContentType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mSupportForwardContentTypeSet.add(Integer.MAX_VALUE);
        }
    }

    public void forwardRecentItemViewOnClick(@Nullable View v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getMIsMultiSelect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mIsMultiSelect;
    }

    public int getNodeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return -1;
    }

    public boolean isSupportCurrentForwardContentType(@Nullable Integer forwardContentType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) forwardContentType)).booleanValue();
        }
        if (forwardContentType == null) {
            return false;
        }
        if (!this.mSupportForwardContentTypeSet.contains(forwardContentType) && !this.mSupportForwardContentTypeSet.contains(Integer.MAX_VALUE)) {
            return false;
        }
        return true;
    }

    public boolean isSupportShow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.isShow;
    }

    public void sendToNode(@Nullable Context context, @Nullable Bundle extraData, @Nullable com.tencent.mobileqq.selectfriend.callback.a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, context, extraData, callback);
        }
    }

    protected final void setMIsMultiSelect(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.mIsMultiSelect = z16;
        }
    }

    public final void setMultiSelect(boolean isMultiSelect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, isMultiSelect);
        } else {
            this.mIsMultiSelect = isMultiSelect;
        }
    }

    public int supportMsgToNodeUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return com.tencent.mobileqq.selectfriend.constant.a.INSTANCE.b();
    }
}
