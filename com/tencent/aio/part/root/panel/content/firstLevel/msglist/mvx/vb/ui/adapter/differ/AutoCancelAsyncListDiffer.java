package com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import com.tencent.aio.api.list.g;
import com.tencent.aio.exception.AIOCancelException;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 3*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u00014B\u001d\u0012\u0006\u0010+\u001a\u00020(\u0012\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000,\u00a2\u0006\u0004\b1\u00102J(\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J \u0010\f\u001a\u00020\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0016R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001d\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000,8\u0006\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b\u001a\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer;", "T", "Lcom/tencent/aio/api/list/g;", "", "newList", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "diffResult", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/e;", "commitCallback", "", h.F, "previousList", "j", "e", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "k", "Lcom/tencent/aio/api/list/g$b;", "action", DomainData.DOMAIN_NAME, "t", "d", "Ljava/util/List;", "mList", "mReadOnlyList", "", "f", "I", "g", "()I", "setMMaxScheduledGeneration", "(I)V", "mMaxScheduledGeneration", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/Deferred;", "executeJob", "", "i", "Z", "isFirstSubmit", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/b;", "mUpdateCallback", "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/a;", "()Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/a;", "mConfig", "<init>", "(Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/b;Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/a;)V", "D", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AutoCancelAsyncListDiffer<T> implements g<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final a<T> mConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private List<? extends T> mList;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private List<? extends T> mReadOnlyList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mMaxScheduledGeneration;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Deferred<?> executeJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstSubmit;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final b mUpdateCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/aio/part/root/panel/content/firstLevel/msglist/mvx/vb/ui/adapter/differ/AutoCancelAsyncListDiffer$a;", "", "", "TAG", "Ljava/lang/String;", "coroutineName", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.panel.content.firstLevel.msglist.mvx.vb.ui.adapter.differ.AutoCancelAsyncListDiffer$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52828);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AutoCancelAsyncListDiffer(@NotNull b mUpdateCallback, @NotNull a<T> mConfig) {
        List<? extends T> emptyList;
        Intrinsics.checkNotNullParameter(mUpdateCallback, "mUpdateCallback");
        Intrinsics.checkNotNullParameter(mConfig, "mConfig");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) mUpdateCallback, (Object) mConfig);
            return;
        }
        this.mUpdateCallback = mUpdateCallback;
        this.mConfig = mConfig;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.mReadOnlyList = emptyList;
    }

    private final void e(e commitCallback) {
        if (commitCallback != null) {
            commitCallback.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(List<? extends T> newList, DiffUtil.DiffResult diffResult, e commitCallback) {
        List<? extends T> list = this.mReadOnlyList;
        this.mList = newList;
        e(commitCallback);
        List<? extends T> unmodifiableList = Collections.unmodifiableList(newList);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(newList)");
        this.mReadOnlyList = unmodifiableList;
        diffResult.dispatchUpdatesTo(this.mUpdateCallback);
        j(list, commitCallback);
    }

    private final void j(List<? extends T> previousList, e commitCallback) {
        if (commitCallback != null) {
            commitCallback.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(String operation) {
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(operation);
            sb5.append(" on ");
            Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
            sb5.append(currentThread.getName());
            aVar.d("AutoCancelAsyncListDiffer", sb5.toString());
        }
    }

    @NotNull
    public final a<T> f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mConfig;
    }

    public final int g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return this.mMaxScheduledGeneration;
    }

    @Override // com.tencent.aio.api.list.g
    public void n(@NotNull g.b<T> action) {
        boolean z16;
        List<? extends T> emptyList;
        Integer num;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) action);
            return;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        List<T> b16 = action.b();
        CoroutineScope a16 = action.a();
        g.a c16 = action.c();
        if (!(c16 instanceof e)) {
            c16 = null;
        }
        e eVar = (e) c16;
        com.tencent.aio.base.a aVar = com.tencent.aio.base.a.f69150c;
        if (aVar.a()) {
            com.tencent.aio.base.log.a aVar2 = com.tencent.aio.base.log.a.f69187b;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("submitNewList ");
            if (b16 != null) {
                num = Integer.valueOf(b16.size());
            } else {
                num = null;
            }
            sb5.append(num);
            aVar2.d("AutoCancelAsyncListDiffer", sb5.toString());
        }
        int i3 = this.mMaxScheduledGeneration + 1;
        this.mMaxScheduledGeneration = i3;
        List<? extends T> list = this.mList;
        if (b16 == list) {
            if (eVar != null) {
                eVar.a();
            }
            if (aVar.a()) {
                com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", "submit action same complete");
                return;
            }
            return;
        }
        List<? extends T> list2 = this.mReadOnlyList;
        if (b16 == null) {
            Intrinsics.checkNotNull(list);
            list.size();
            this.mList = null;
            if (eVar != null) {
                eVar.c();
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            this.mReadOnlyList = emptyList;
            e(eVar);
            this.mUpdateCallback.notifyDataSetChanged();
            j(list2, eVar);
            if (eVar != null) {
                eVar.b(false);
            }
            com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", "submitfastRemove");
            this.isFirstSubmit = true;
            return;
        }
        List<? extends T> list3 = list;
        if (list3 != null && !list3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            if (this.isFirstSubmit) {
                this.isFirstSubmit = false;
                com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", "firstSubmit");
                com.tencent.aio.pref.a aVar3 = com.tencent.aio.pref.a.f69788j;
                if (!aVar3.g()) {
                    this.mList = b16;
                    if (eVar != null) {
                        eVar.c();
                    }
                    List<? extends T> unmodifiableList = Collections.unmodifiableList(b16);
                    Intrinsics.checkNotNullExpressionValue(unmodifiableList, "Collections.unmodifiableList(newList)");
                    this.mReadOnlyList = unmodifiableList;
                    e(eVar);
                    this.mUpdateCallback.notifyDataSetChanged();
                    j(list2, eVar);
                    if (eVar != null) {
                        eVar.b(true);
                        return;
                    }
                    return;
                }
                aVar3.b("firstSubmit");
                String str = "AIO#firstSubmit";
                if (!aVar3.h()) {
                    this.mList = b16;
                    if (eVar != null) {
                        eVar.c();
                    }
                    List<? extends T> unmodifiableList2 = Collections.unmodifiableList(b16);
                    Intrinsics.checkNotNullExpressionValue(unmodifiableList2, "Collections.unmodifiableList(newList)");
                    this.mReadOnlyList = unmodifiableList2;
                    e(eVar);
                    this.mUpdateCallback.notifyDataSetChanged();
                    j(list2, eVar);
                    if (eVar != null) {
                        eVar.b(true);
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.mList = b16;
                    if (eVar != null) {
                        eVar.c();
                    }
                    List<? extends T> unmodifiableList3 = Collections.unmodifiableList(b16);
                    Intrinsics.checkNotNullExpressionValue(unmodifiableList3, "Collections.unmodifiableList(newList)");
                    this.mReadOnlyList = unmodifiableList3;
                    e(eVar);
                    this.mUpdateCallback.notifyDataSetChanged();
                    j(list2, eVar);
                    if (eVar != null) {
                        eVar.b(true);
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis));
                }
                aVar3.e();
                return;
            }
            this.mList = b16;
            if (eVar != null) {
                eVar.c();
            }
            List<? extends T> unmodifiableList4 = Collections.unmodifiableList(b16);
            Intrinsics.checkNotNullExpressionValue(unmodifiableList4, "Collections.unmodifiableList(newList)");
            this.mReadOnlyList = unmodifiableList4;
            e(eVar);
            this.mUpdateCallback.notifyDataSetChanged();
            j(list2, eVar);
            if (eVar != null) {
                eVar.b(true);
            }
            com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", "fastSubmit");
            return;
        }
        if (eVar != null) {
            eVar.b(false);
        }
        List<? extends T> list4 = this.mList;
        Intrinsics.checkNotNull(list4);
        if (aVar.a() && this.executeJob != null) {
            com.tencent.aio.base.log.a.f69187b.d("AutoCancelAsyncListDiffer", "prepare cancel " + this.executeJob);
        }
        Deferred<?> deferred = this.executeJob;
        if (deferred != null) {
            deferred.cancel((CancellationException) new AIOCancelException("\u53d6\u6d88\u672a\u5b8c\u6210 \u7684job " + this.executeJob));
        }
        if (a16 != null) {
            BuildersKt__Builders_commonKt.launch$default(a16, null, null, new AutoCancelAsyncListDiffer$submitList$5(this, list4, b16, i3, eVar, null), 3, null);
        }
    }

    @Override // com.tencent.aio.api.list.g
    @NotNull
    public List<T> t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mReadOnlyList;
    }
}
