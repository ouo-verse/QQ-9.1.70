package com.tencent.mobileqq.selectfriend.relationlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u00052\u00020\u0001:\u0001\rB/\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH&R\"\u0010\u0014\u001a\u00020\u000e8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList;", "Landroid/widget/FrameLayout;", "", "fromNet", "", "e", "c", "d", "targetMode", "needAnim", "setMultiSelectMode", "", "groupPos", "a", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "b", "()Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;", "setModel", "(Lcom/tencent/mobileqq/selectfriend/relationlist/model/a;)V", "model", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/selectfriend/relationlist/model/a;)V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public abstract class BaseRelationSectionedNodeList extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.selectfriend.relationlist.model.a model;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/selectfriend/relationlist/BaseRelationSectionedNodeList$a;", "", "", "ANIM_DURATION", "J", "<init>", "()V", "qq_selectfriend_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.selectfriend.relationlist.BaseRelationSectionedNodeList$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23686);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BaseRelationSectionedNodeList(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull com.tencent.mobileqq.selectfriend.relationlist.model.a model) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(model, "model");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3), model);
        } else {
            this.model = model;
        }
    }

    public abstract boolean a(int groupPos);

    @NotNull
    public com.tencent.mobileqq.selectfriend.relationlist.model.a b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.selectfriend.relationlist.model.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.model;
    }

    public abstract void c();

    public abstract void d();

    public abstract void e(boolean fromNet);

    public void setModel(@NotNull com.tencent.mobileqq.selectfriend.relationlist.model.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else {
            Intrinsics.checkNotNullParameter(aVar, "<set-?>");
            this.model = aVar;
        }
    }

    public abstract void setMultiSelectMode(boolean targetMode, boolean needAnim);
}
