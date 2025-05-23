package com.tencent.qqnt.mutualmark.processor;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsReportHelper;
import com.tencent.qqnt.chats.api.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.classadapter.SingleLineTextView;
import com.tencent.qqnt.ntrelation.api.IMutualMarkDrawableApi;
import com.tencent.qqnt.ntrelation.intimateinfo.bean.NTMutualMarkEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J(\u0010\u0007\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0004j\b\u0012\u0004\u0012\u00020\b`\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/mutualmark/processor/a;", "Lcom/tencent/qqnt/chats/inject/title/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Ljava/util/ArrayList;", "Landroid/graphics/drawable/Drawable;", "Lkotlin/collections/ArrayList;", "c", "Lcom/tencent/qqnt/ntrelation/intimateinfo/bean/NTMutualMarkEntity;", "infoList", "", "b", "Lcom/tencent/qqnt/classadapter/SingleLineTextView;", "view", "a", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends com.tencent.qqnt.chats.inject.title.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f359772b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/mutualmark/processor/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.mutualmark.processor.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64119);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
            f359772b = true;
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void b(g item, ArrayList<NTMutualMarkEntity> infoList) {
        b chatsListReport;
        int collectionSizeOrDefault;
        if (item.o() > 0 && !infoList.isEmpty() && (chatsListReport = ((IChatsReportHelper) QRoute.api(IChatsReportHelper.class)).getChatsListReport(item.o())) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(infoList, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (NTMutualMarkEntity nTMutualMarkEntity : infoList) {
                arrayList.add(new b.c(nTMutualMarkEntity.type, nTMutualMarkEntity.level, nTMutualMarkEntity.sub_level));
            }
            chatsListReport.n(item, arrayList);
        }
    }

    private final ArrayList<Drawable> c(g item) {
        Integer num;
        Pair<ArrayList<Drawable>, ArrayList<NTMutualMarkEntity>> mutualMarkDrawableAndData = ((IMutualMarkDrawableApi) QRoute.api(IMutualMarkDrawableApi.class)).getMutualMarkDrawableAndData(item.k(), "MutualMarkTitleProcessor");
        b(item, mutualMarkDrawableAndData.getSecond());
        if (f359772b) {
            f359772b = false;
        }
        if (QLog.isDebugVersion()) {
            long l3 = item.l();
            ArrayList<Drawable> first = mutualMarkDrawableAndData.getFirst();
            if (first != null) {
                num = Integer.valueOf(first.size());
            } else {
                num = null;
            }
            QLog.d("MutualMarkTitleProcessor", 4, "new [updateTitle] for mutual mark : chatUin=" + l3 + ",model.size=" + num + ", modelList=" + mutualMarkDrawableAndData.getSecond());
        }
        return mutualMarkDrawableAndData.getFirst();
    }

    @Override // com.tencent.qqnt.chats.inject.title.a
    public void a(@NotNull g item, @NotNull SingleLineTextView view) {
        Drawable[] drawableArr;
        int collectionSizeOrDefault;
        e eVar;
        URLDrawable uRLDrawable;
        Unit unit;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(view, "view");
        if (item.n() != 1) {
            return;
        }
        ArrayList<Drawable> c16 = c(item);
        view.setOverLengthCutDirection(!((IMutualMarkHelperApi) QRoute.api(IMutualMarkHelperApi.class)).isElegantVersion() ? 1 : 0);
        if (c16 != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(c16, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (Drawable drawable : c16) {
                if (drawable instanceof e) {
                    eVar = (e) drawable;
                } else {
                    eVar = null;
                }
                if (eVar != null) {
                    eVar.a(view);
                    if (QLog.isDebugVersion()) {
                        long l3 = item.l();
                        URLDrawable d16 = eVar.d();
                        if (d16 != null && d16.getStatus() == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        QLog.d("MutualMarkTitleProcessor", 4, "[updateTitle] for mutual mark : chatUin=" + l3 + ", success " + z17);
                    }
                }
                if (drawable instanceof URLDrawable) {
                    uRLDrawable = (URLDrawable) drawable;
                } else {
                    uRLDrawable = null;
                }
                if (uRLDrawable != null) {
                    if (QLog.isDebugVersion()) {
                        long l16 = item.l();
                        URLDrawable uRLDrawable2 = (URLDrawable) drawable;
                        if (uRLDrawable2.getStatus() == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QLog.d("MutualMarkTitleProcessor", 4, "[updateTitle] for mutual mark : chatUin=" + l16 + ", success " + z16 + " " + uRLDrawable2.getURL());
                    }
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                arrayList.add(unit);
            }
        }
        if (c16 != null) {
            Object[] array = c16.toArray(new Drawable[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            drawableArr = (Drawable[]) array;
        } else {
            drawableArr = null;
        }
        view.setIconDrawables(drawableArr, true);
        view.requestLayout();
    }
}
