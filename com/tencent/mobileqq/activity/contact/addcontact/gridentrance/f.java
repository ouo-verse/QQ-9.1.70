package com.tencent.mobileqq.activity.contact.addcontact.gridentrance;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\b\u00a2\u0006\u0004\b'\u0010(J\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\bH\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010!R \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010%\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/f;", "Lcom/tencent/mobileqq/widget/gridpage/b;", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/g;", "", "", "idAry", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "b", "e", "a", "", "d", "c", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "viewType", "k", "holder", "position", "i", "I", "row", "column", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/i;", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/i;", "getCallback", "()Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/i;", "l", "(Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/i;)V", "callback", "", "Ljava/util/Set;", "items", "", "Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/d;", "Ljava/util/Map;", "entranceConfig", "<init>", "(II)V", "f", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class f extends com.tencent.mobileqq.widget.gridpage.b<g> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int row;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int column;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private i callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> items;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, d> entranceConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/activity/contact/addcontact/gridentrance/f$a;", "", "", "LOG_TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.activity.contact.addcontact.gridentrance.f$a, reason: from kotlin metadata */
    /* loaded from: classes10.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50389);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.row = i3;
        this.column = i16;
        this.items = new LinkedHashSet();
        this.entranceConfig = h.f181167a.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(f this$0, View itemView) {
        EventCollector.getInstance().onViewClickedBefore(itemView);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i iVar = this$0.callback;
        if (iVar != null) {
            Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
            iVar.a(itemView);
            VideoReport.reportEvent("dt_clck", itemView, null);
            QLog.i("AddContactsEntrance", 1, "click item view, [viewId:" + itemView.getId() + "]");
        }
        EventCollector.getInstance().onViewClicked(itemView);
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.column;
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.items.size();
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    public float c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return 80.0f;
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    public float d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this)).floatValue();
        }
        return 86.0f;
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.row;
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull g holder, int position) {
        Object elementAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) holder, position);
            return;
        }
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (position < this.items.size()) {
            elementAt = CollectionsKt___CollectionsKt.elementAt(this.items, position);
            String str = (String) elementAt;
            d dVar = this.entranceConfig.get(str);
            if (dVar != null) {
                holder.l(dVar);
                holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.activity.contact.addcontact.gridentrance.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        f.j(f.this, view);
                    }
                });
                return;
            }
            QLog.e("AddContactsEntrance", 1, "not exist the config, [key:" + str + "]");
            return;
        }
        QLog.e("AddContactsEntrance", 1, "invalid position index, [position:" + position + " itemCount:" + this.items.size() + "]");
    }

    @Override // com.tencent.mobileqq.widget.gridpage.b
    @NotNull
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public g g(@NotNull ViewGroup parent, int viewType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (g) iPatchRedirector.redirect((short) 10, (Object) this, (Object) parent, viewType);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drn, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new g(view);
    }

    public final void l(@Nullable i iVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iVar);
        } else {
            this.callback = iVar;
        }
    }

    public final void m(@NotNull List<String> idAry) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) idAry);
            return;
        }
        Intrinsics.checkNotNullParameter(idAry, "idAry");
        for (String str : idAry) {
            if (this.entranceConfig.containsKey(str)) {
                this.items.add(str);
            } else {
                QLog.e("AddContactsEntrance", 1, "set invalid entrance id, [id:" + str + "]");
            }
        }
        QLog.i("AddContactsEntrance", 1, "set entrance list, [item:" + this.items + "]");
    }
}
