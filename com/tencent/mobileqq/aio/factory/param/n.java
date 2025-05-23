package com.tencent.mobileqq.aio.factory.param;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.aio.data.AIOParam;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.aio.factory.param.o;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.biz.lightbusiness.lightinteraction.bean.LIAActionItem;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessClearType;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.pluspanel.api.IPlusPanelApi;
import defpackage.MsgListUtil;
import java.lang.Character;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 O2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002&)B\u0017\u0012\u0006\u0010,\u001a\u00020*\u0012\u0006\u0010/\u001a\u00020-\u00a2\u0006\u0004\bM\u0010NJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002JL\u0010\u000f\u001a.\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f0\u000e2\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\fH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\f\u0010\u0013\u001a\u00020\u0012*\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0010H\u0002J\u0010\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\b\u0010)\u001a\u00020\u0004H\u0016R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010+R\u0014\u0010/\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010.R\u0016\u00101\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u00100R\u0018\u00103\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00102R\u001e\u00107\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u00106R\u0016\u00109\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00100R\u001c\u0010=\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010F\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u00100R\u0014\u0010J\u001a\u00020G8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010L\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u00100\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/n;", "Lts/b;", "Lcom/tencent/mobileqq/aio/factory/param/o;", "Lcom/tencent/qqnt/aio/activity/l;", "", "E", "v", "", "beginTime", "G", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "Lkotlin/Pair;", HippyTKDListViewAdapter.X, "", "D", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "msgRecord", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "isMixMsg", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "height", BdhLogUtil.LogTag.Tag_Conn, "", "str", "y", "u", "t", "c", "e", "Lcom/tencent/mobileqq/aio/factory/param/o$a;", "listener", "a", "onExitAIO", "d", "b", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/aio/data/AIOParam;", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "Z", "hasLoad", "Lcom/tencent/mobileqq/aio/factory/param/o$a;", "msgLoadListener", "Lcom/tencent/aio/msgservice/h;", "Lcom/tencent/aio/data/msglist/a;", "Lcom/tencent/aio/msgservice/h;", "msgServiceListRsp", "f", "needContinueGetRoamMsg", "", "g", "Ljava/util/List;", "remainMsgList", "Lcom/tencent/qqnt/biz/lightbusiness/a;", tl.h.F, "Lcom/tencent/qqnt/biz/lightbusiness/a;", "liteChangedListener", "i", "I", "enterCount", "j", "partialLoad", "Lcom/tencent/mobileqq/aio/factory/param/AIOInitPreloader;", "k", "Lcom/tencent/mobileqq/aio/factory/param/AIOInitPreloader;", "preloader", "l", "isMsgListShown", "<init>", "(Landroid/content/Context;Lcom/tencent/aio/data/AIOParam;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class n implements ts.b, o, com.tencent.qqnt.aio.activity.l {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOParam aioParam;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hasLoad;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile o.a msgLoadListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> msgServiceListRsp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private volatile boolean needContinueGetRoamMsg;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile List<MsgRecord> remainMsgList;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.biz.lightbusiness.a liteChangedListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int enterCount;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean partialLoad;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOInitPreloader preloader;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean isMsgListShown;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/n$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.factory.param.n$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0016R%\u0010\u0011\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/factory/param/n$b;", "Lcom/tencent/qqnt/biz/lightbusiness/a;", "", "uid", "", "Lcom/tencent/qqnt/kernel/nativeinterface/LiteBusinessType;", "", "data", "", "a", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/aio/factory/param/n;", "kotlin.jvm.PlatformType", "d", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "ref", "impl", "<init>", "(Lcom/tencent/mobileqq/aio/factory/param/n;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class b implements com.tencent.qqnt.biz.lightbusiness.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<n> ref;

        public b(@NotNull n impl) {
            Intrinsics.checkNotNullParameter(impl, "impl");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) impl);
            } else {
                this.ref = new WeakReference<>(impl);
            }
        }

        @Override // com.tencent.qqnt.biz.lightbusiness.a
        public void a(@Nullable String uid, @NotNull Map<LiteBusinessType, ? extends Object> data) {
            LIAActionItem lIAActionItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uid, (Object) data);
                return;
            }
            Intrinsics.checkNotNullParameter(data, "data");
            n nVar = this.ref.get();
            if (nVar == null || !Intrinsics.areEqual(nVar.aioParam.r().c().j(), uid)) {
                return;
            }
            LiteBusinessType liteBusinessType = LiteBusinessType.KLITEACTION;
            Object obj = data.get(liteBusinessType);
            if (obj instanceof LIAActionItem) {
                lIAActionItem = (LIAActionItem) obj;
            } else {
                lIAActionItem = null;
            }
            if (lIAActionItem != null) {
                QLog.d("FirstScreenHelperImpl", 1, "[preloadLiteAction] onChange success: item=" + lIAActionItem);
                nVar.aioParam.l().putParcelable("KEY_ACTION_ITEM", lIAActionItem);
                com.tencent.mobileqq.aio.helper.j.f189071a.a(liteBusinessType);
            }
            nVar.liteChangedListener = null;
            com.tencent.qqnt.biz.lightbusiness.d.f353112a.l(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/aio/factory/param/n$c", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetAioFirstViewLatestMsgCallback;", "", "result", "", "errMsg", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "needContinueGetMsg", "", "onResult", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes10.dex */
    public static final class c implements IGetAioFirstViewLatestMsgCallback {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f188816a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f188817b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Contact f188818c;

        c(long j3, n nVar, Contact contact) {
            this.f188816a = j3;
            this.f188817b = nVar;
            this.f188818c = contact;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), nVar, contact);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IGetAioFirstViewLatestMsgCallback
        public void onResult(int result, @Nullable String errMsg, @Nullable ArrayList<MsgRecord> msgList, boolean needContinueGetMsg) {
            Integer num;
            boolean z16;
            boolean z17;
            o.a aVar;
            boolean z18;
            boolean z19;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(result), errMsg, msgList, Boolean.valueOf(needContinueGetMsg));
                return;
            }
            if (msgList != null) {
                num = Integer.valueOf(msgList.size());
            } else {
                num = null;
            }
            QLog.i("FirstScreenHelperImpl", 1, "[getLatestDbMsgs] msgCount=" + num + " cost=" + (System.currentTimeMillis() - this.f188816a));
            if (msgList == null) {
                return;
            }
            Contact h16 = AIOUtil.f194084a.h(this.f188817b.aioParam.r());
            String str = this.f188818c.peerUid;
            if (str != null && !str.equals(h16.peerUid)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                Pair x16 = this.f188817b.x(msgList);
                ArrayList arrayList = (ArrayList) x16.getFirst();
                ArrayList arrayList2 = (ArrayList) x16.getSecond();
                com.tencent.qqnt.trace.a aVar2 = com.tencent.qqnt.trace.a.f362326a;
                aVar2.e("FETCH_DATA_END");
                if (result == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar = new com.tencent.aio.msgservice.h<>(z17, result, errMsg, MsgListUtil.q(MsgListUtil.f24918a, arrayList, this.f188817b.context, null, 4, null));
                aVar2.e("TRANSFORM_DATA");
                n nVar = this.f188817b;
                synchronized (this) {
                    nVar.msgServiceListRsp = hVar;
                    aVar = nVar.msgLoadListener;
                    nVar.msgLoadListener = null;
                    nVar.needContinueGetRoamMsg = needContinueGetMsg;
                    if (arrayList.size() < msgList.size()) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    nVar.partialLoad = z18;
                    nVar.remainMsgList = arrayList2;
                    Unit unit = Unit.INSTANCE;
                }
                boolean z26 = this.f188817b.partialLoad;
                int size = arrayList.size();
                int size2 = msgList.size();
                if (aVar != null) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                aVar2.c("preloadMsgs, partial=" + z26 + " needMore=" + needContinueGetMsg + " msgCount=" + size + "-" + size2 + " valid=" + z19);
                if (aVar != null) {
                    aVar.a(hVar, needContinueGetMsg, arrayList2);
                    this.f188817b.t();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45927);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public n(@NotNull Context context, @NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aioParam);
            return;
        }
        this.context = context;
        this.aioParam = aioParam;
        this.needContinueGetRoamMsg = true;
        this.remainMsgList = new ArrayList();
        this.preloader = new AIOInitPreloader();
        if (context instanceof Activity) {
        } else {
            throw new RuntimeException("context must be activity");
        }
    }

    private final float A(PicElement picElement, boolean isMixMsg) {
        return C(com.tencent.mobileqq.aio.msglist.holder.base.util.f.c(picElement, isMixMsg).getSecond().intValue());
    }

    private final float B(MsgRecord msgRecord) {
        return C(com.tencent.mobileqq.aio.msglist.holder.component.video.c.f192224a.k(msgRecord).getSecond().intValue());
    }

    private final float C(int height) {
        return height / 250.0f;
    }

    private final boolean D() {
        if (this.aioParam.r().c().e() == 2) {
            return true;
        }
        return false;
    }

    private final void E() {
        HashSet<LiteBusinessType> hashSetOf;
        if (this.aioParam.r().c().e() != 1) {
            return;
        }
        com.tencent.mobileqq.aio.helper.j jVar = com.tencent.mobileqq.aio.helper.j.f189071a;
        jVar.c();
        v();
        if (this.aioParam.l().containsKey("KEY_ACTION_ITEM")) {
            jVar.a(LiteBusinessType.KLITEACTION);
            return;
        }
        if (this.liteChangedListener == null) {
            b bVar = new b(this);
            this.liteChangedListener = bVar;
            com.tencent.qqnt.biz.lightbusiness.d.f353112a.b(bVar);
        }
        String j3 = this.aioParam.r().c().j();
        com.tencent.qqnt.biz.lightbusiness.d dVar = com.tencent.qqnt.biz.lightbusiness.d.f353112a;
        hashSetOf = SetsKt__SetsKt.hashSetOf(LiteBusinessType.KLITEACTION);
        dVar.f(j3, hashSetOf, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.factory.param.l
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                n.F(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(int i3, String str) {
        QLog.d("FirstScreenHelperImpl", 1, "[getLiteBusiness] err=" + i3 + ", msg=" + str);
    }

    private final void G(long beginTime) {
        int i3;
        com.tencent.aio.pref.a.f69788j.a("preLoadMsg");
        Bundle l3 = this.aioParam.l();
        long j3 = l3.getLong("key_navigate_msgid", -1L);
        long j16 = l3.getLong("key_navigate_msgseq", -1L);
        if (l3.getLong("key_navigate_time", -1L) <= 0 && j3 <= 0 && j16 <= 0) {
            com.tencent.qqnt.trace.a.f362326a.e("FETCH_DATA_START");
            this.hasLoad = true;
            Contact h16 = AIOUtil.f194084a.h(this.aioParam.r());
            if (l3.getBoolean("key_hide_history_msg")) {
                i3 = 0;
            } else {
                i3 = 15;
            }
            w e16 = com.tencent.qqnt.msg.f.e();
            if (e16 != null) {
                e16.getAioFirstViewLatestMsgs(h16, i3, new c(beginTime, this, h16));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        this.msgLoadListener = null;
        this.msgServiceListRsp = null;
        this.hasLoad = false;
        this.partialLoad = false;
    }

    private final int u(String str) {
        Character.UnicodeScript of5;
        Character.UnicodeScript unicodeScript;
        if (Build.VERSION.SDK_INT < 24) {
            return str.length();
        }
        int length = str.length();
        int i3 = 0;
        for (int i16 = 0; i16 < length; i16++) {
            of5 = Character.UnicodeScript.of(str.charAt(i16));
            unicodeScript = Character.UnicodeScript.HAN;
            if (of5 == unicodeScript) {
                i3 += 2;
            } else {
                i3++;
            }
            if (i3 > 500) {
                break;
            }
        }
        return i3;
    }

    private final void v() {
        HashSet<LiteBusinessClearType> hashSetOf;
        com.tencent.qqnt.biz.lightbusiness.d dVar = com.tencent.qqnt.biz.lightbusiness.d.f353112a;
        String j3 = this.aioParam.r().c().j();
        hashSetOf = SetsKt__SetsKt.hashSetOf(LiteBusinessClearType.KLITEACTIONMSGLIST);
        dVar.c(j3, hashSetOf, new IOperateCallback() { // from class: com.tencent.mobileqq.aio.factory.param.m
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                n.w(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("FirstScreenHelperImpl", 2, "[clearLiteAction] msgList err=" + i3 + ", msg=" + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[LOOP:0: B:5:0x0012->B:20:0x004e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052 A[EDGE_INSN: B:21:0x0052->B:22:0x0052 BREAK  A[LOOP:0: B:5:0x0012->B:20:0x004e], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<ArrayList<MsgRecord>, ArrayList<MsgRecord>> x(ArrayList<MsgRecord> msgList) {
        int i3;
        ArrayList arrayList;
        float z16;
        if (D()) {
            i3 = 11;
        } else {
            i3 = 15;
        }
        int size = msgList.size() - 1;
        float f16 = 0.0f;
        while (true) {
            if (-1 < size) {
                MsgRecord msgRecord = msgList.get(size);
                Intrinsics.checkNotNullExpressionValue(msgRecord, "msgList[i]");
                MsgRecord msgRecord2 = msgRecord;
                int i16 = msgRecord2.msgType;
                if (i16 != 2) {
                    if (i16 != 5) {
                        if (i16 != 7) {
                            if (i16 != 9) {
                                if (i16 != 31) {
                                    z16 = 1.0f;
                                }
                            } else {
                                z16 = 1.5f;
                            }
                        } else {
                            z16 = B(msgRecord2);
                        }
                    } else {
                        z16 = 0.5f;
                    }
                    f16 += z16;
                    if (f16 < i3) {
                        break;
                    }
                    size--;
                }
                z16 = z(msgRecord2);
                f16 += z16;
                if (f16 < i3) {
                }
            } else {
                size = 0;
                break;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(msgList.subList(size, msgList.size()));
        if (size > 0) {
            arrayList = new ArrayList();
            arrayList.addAll(msgList.subList(0, size));
        } else {
            arrayList = new ArrayList();
        }
        return new Pair<>(arrayList2, arrayList);
    }

    private final float y(String str) {
        boolean z16;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return 0.0f;
        }
        return ((u(str) / 40) * 0.2f) + 1;
    }

    private final float z(MsgRecord msgRecord) {
        float coerceAtLeast;
        PicElement picElement;
        if (com.tencent.mobileqq.aio.utils.d.r(msgRecord)) {
            return C(defpackage.a.f25157a.c());
        }
        if (MsgExtKt.M(msgRecord)) {
            MsgElement i3 = MsgExtKt.i(msgRecord, 2);
            if (i3 == null || (picElement = i3.picElement) == null) {
                return 1.0f;
            }
            return A(picElement, false);
        }
        StringBuilder sb5 = new StringBuilder();
        int size = msgRecord.elements.size();
        float f16 = 0.0f;
        for (int i16 = 0; i16 < size; i16++) {
            MsgElement msgElement = msgRecord.elements.get(i16);
            int i17 = msgElement.elementType;
            if (i17 == 2) {
                PicElement picElement2 = msgElement.picElement;
                Intrinsics.checkNotNullExpressionValue(picElement2, "element.picElement");
                f16 += A(picElement2, true);
            } else if (i17 == 1) {
                sb5.append(msgElement.textElement.content);
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "textContent.toString()");
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f16 + y(sb6), 1.0f);
        return coerceAtLeast;
    }

    @Override // com.tencent.mobileqq.aio.factory.param.o
    public void a(@NotNull o.a listener) {
        com.tencent.aio.msgservice.h<com.tencent.aio.data.msglist.a> hVar;
        List<MsgRecord> list;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        new ArrayList();
        synchronized (this) {
            this.msgLoadListener = listener;
            hVar = this.msgServiceListRsp;
            list = this.remainMsgList;
            Unit unit = Unit.INSTANCE;
        }
        com.tencent.qqnt.trace.a aVar = com.tencent.qqnt.trace.a.f362326a;
        if (hVar != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        aVar.c("getLastDbMsgs valid=" + z16);
        if (hVar != null) {
            QLog.i("FirstScreenHelperImpl", 1, "getLastDbMsgs OnLoad, data is ready");
            o.a aVar2 = this.msgLoadListener;
            if (aVar2 != null) {
                aVar2.a(hVar, this.needContinueGetRoamMsg, list);
            }
            t();
        }
    }

    @Override // com.tencent.qqnt.aio.activity.l
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.isMsgListShown = true;
        }
    }

    @Override // ts.b
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        com.tencent.aio.pref.a aVar = com.tencent.aio.pref.a.f69788j;
        if (!aVar.g()) {
            sb5.append("startAIO");
            t();
            long currentTimeMillis = System.currentTimeMillis();
            G(currentTimeMillis);
            sb5.append("startAIO call preload, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        } else {
            aVar.b("firstScreenHelperStart");
            String str = "AIO#firstScreenHelperStart";
            if (!aVar.h()) {
                sb5.append("startAIO");
                t();
                long currentTimeMillis2 = System.currentTimeMillis();
                G(currentTimeMillis2);
                sb5.append("startAIO call preload, cost=" + (System.currentTimeMillis() - currentTimeMillis2));
            } else {
                long currentTimeMillis3 = System.currentTimeMillis();
                sb5.append("startAIO");
                t();
                long currentTimeMillis4 = System.currentTimeMillis();
                G(currentTimeMillis4);
                sb5.append("startAIO call preload, cost=" + (System.currentTimeMillis() - currentTimeMillis4));
                Log.w("AIO#", str + " spend " + (System.currentTimeMillis() - currentTimeMillis3));
            }
            aVar.e();
        }
        this.enterCount++;
        this.preloader.a();
        E();
        ((IPlusPanelApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IPlusPanelApi.class)).loadAppInfoConfigAsync(this.aioParam.r().c().e());
        QLog.d("FirstScreenHelperImpl", 1, sb5.toString());
    }

    @Override // com.tencent.qqnt.aio.activity.k
    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.isMsgListShown;
    }

    @Override // com.tencent.mobileqq.aio.factory.param.o
    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return this.hasLoad;
    }

    @Override // ts.b
    public void onExitAIO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QLog.d("FirstScreenHelperImpl", 1, "onExitAIO");
        int i3 = this.enterCount - 1;
        this.enterCount = i3;
        if (i3 <= 0) {
            com.tencent.qqnt.biz.lightbusiness.a aVar = this.liteChangedListener;
            if (aVar != null) {
                com.tencent.qqnt.biz.lightbusiness.d.f353112a.l(aVar);
                this.liteChangedListener = null;
            }
            this.enterCount = 0;
        }
        t();
    }
}
