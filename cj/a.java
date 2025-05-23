package cj;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.qzone.reborn.groupalbum.selectmedia.util.c;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IRichMediaBrowserApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002JB\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fJ:\u0010\u0013\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0016"}, d2 = {"Lcj/a;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "d", "Landroid/os/Bundle;", "a", "Landroid/content/Context;", "context", "aioRichMediaList", "Landroid/view/View;", "anchorView", "", "source", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "", "b", "c", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f30979a = new a();

    a() {
    }

    private final Bundle a() {
        Bundle bundle = new Bundle();
        bundle.putString("Key_Browser_Bundle", "AIOService");
        return bundle;
    }

    private static final boolean e(Ref.IntRef intRef, Ref.IntRef intRef2, int i3) {
        return (intRef.element - intRef2.element) + 1 > i3;
    }

    private final List<MsgRecord> d(List<MsgRecord> list, MsgRecord msgRecord) {
        List<MsgRecord> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        int size = list.size();
        if (size <= 10) {
            return list;
        }
        int indexOf = list.indexOf(msgRecord);
        Ref.IntRef intRef = new Ref.IntRef();
        Ref.IntRef intRef2 = new Ref.IntRef();
        int i3 = size - 1;
        intRef2.element = i3;
        c.f56957a.a("AIOService", "originalSize " + size + "  curIndex " + indexOf + " leftIndex " + intRef.element + " rightIndex " + i3);
        while (true) {
            if (intRef.element < indexOf && e(intRef2, intRef, 10)) {
                intRef.element++;
                if (!e(intRef2, intRef, 10)) {
                    break;
                }
            }
            if (intRef2.element > indexOf && e(intRef2, intRef, 10)) {
                intRef2.element--;
                if (!e(intRef2, intRef, 10)) {
                    break;
                }
            }
        }
        List<MsgRecord> subList = list.subList(intRef.element, intRef2.element + 1);
        c.f56957a.a("AIOService", "fixResult " + subList.size() + " leftIndex " + intRef.element + "  rightIndex " + intRef2.element);
        return subList;
    }

    public final void c(Context context, MsgRecord msgRecord, List<MsgRecord> aioRichMediaList, View anchorView, int source) {
        ArrayList arrayList;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            c.f56957a.a("AIOService", "appRuntime null");
            return;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) QRoute.api(IRichMediaBrowserApi.class);
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        List<MsgRecord> d16 = d(aioRichMediaList, msgRecord);
        if (d16 != null) {
            List<MsgRecord> list = d16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new AIOMsgItem((MsgRecord) it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Bundle a16 = a();
        a16.putInt("key_source", source);
        a16.putBoolean("extra.IS_FROM_GROUP_ALBUM", true);
        iRichMediaBrowserApi.enterVideoPreview(peekAppRuntime, context, anchorView, aIOMsgItem, 0L, false, false, a16, arrayList);
    }

    public final void b(Context context, MsgRecord msgRecord, List<MsgRecord> aioRichMediaList, View anchorView, int source, MsgElement picElement) {
        ArrayList arrayList;
        List<MsgRecord> d16;
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(picElement, "picElement");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            c.f56957a.a("AIOService", "appRuntime null");
            return;
        }
        IRichMediaBrowserApi iRichMediaBrowserApi = (IRichMediaBrowserApi) QRoute.api(IRichMediaBrowserApi.class);
        AIOMsgItem aIOMsgItem = new AIOMsgItem(msgRecord);
        if (aioRichMediaList == null || (d16 = d(aioRichMediaList, msgRecord)) == null) {
            arrayList = null;
        } else {
            List<MsgRecord> list = d16;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(new AIOMsgItem((MsgRecord) it.next()));
            }
            arrayList = arrayList2;
        }
        Bundle a16 = a();
        a16.putInt("key_source", source);
        a16.putBoolean("extra.IS_FROM_GROUP_ALBUM", true);
        Intrinsics.checkNotNullExpressionValue(iRichMediaBrowserApi, "api<IRichMediaBrowserApi\u2026iaBrowserApi::class.java)");
        IRichMediaBrowserApi.a.a(iRichMediaBrowserApi, peekAppRuntime, context, anchorView, aIOMsgItem, picElement, false, a16, arrayList, false, 256, null);
    }
}
