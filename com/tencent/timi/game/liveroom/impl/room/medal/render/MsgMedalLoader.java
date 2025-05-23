package com.tencent.timi.game.liveroom.impl.room.medal.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.medal.c;
import com.tencent.timi.game.liveroom.impl.room.medal.commonrender.c;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001&B\u000f\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b1\u00102J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J \u0010\r\u001a\u0012\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J(\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002H\u0002J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u0019H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J(\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\"\u001a\u00020!R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'RD\u0010-\u001a2\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000b0)j\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\f0\u000b`*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010/\u00a8\u00063"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/medal/render/MsgMedalLoader;", "", "", "Lsr4/g;", "medalList", "l", "medalInfoList", "c", "d", "", "type", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c;", "", "e", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/f;", "msg", "list", "i", "Landroid/text/SpannableString;", "o", DomainData.DOMAIN_NAME, "", "k", "Lcom/tencent/mobileqq/qqlive/widget/chat/message/h;", "Landroid/graphics/Bitmap;", "f", "j", "", "g", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "userMedalInfo", "Lcom/tencent/timi/game/liveroom/impl/room/medal/commonrender/c$b;", "callback", "", tl.h.F, "", "a", "J", "roomId", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "renders", "Lcom/tencent/timi/game/liveroom/impl/room/medal/render/a;", "Lcom/tencent/timi/game/liveroom/impl/room/medal/render/a;", "defaultRender", "<init>", "(J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class MsgMedalLoader {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final HashMap<Integer, com.tencent.timi.game.liveroom.impl.room.medal.c<?, CharSequence>> renders;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a defaultRender;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u001c\u0010\b\u001a\u00020\u00072\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0006\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/medal/render/MsgMedalLoader$b", "Lcom/tencent/timi/game/liveroom/impl/room/medal/c$a;", "", "", "Lcom/tencent/timi/game/liveroom/impl/room/medal/g;", "data", "renderResult", "", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements c.a<Object, CharSequence> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f377996a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ HashMap<Integer, Integer> f377997b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<CharSequence> f377998c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f377999d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.widget.chat.data.b f378000e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ long f378001f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ c.b f378002g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ MsgMedalLoader f378003h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f378004i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqlive.widget.chat.message.f f378005j;

        b(Ref.IntRef intRef, HashMap<Integer, Integer> hashMap, List<CharSequence> list, int i3, com.tencent.mobileqq.qqlive.widget.chat.data.b bVar, long j3, c.b bVar2, MsgMedalLoader msgMedalLoader, Context context, com.tencent.mobileqq.qqlive.widget.chat.message.f fVar) {
            this.f377996a = intRef;
            this.f377997b = hashMap;
            this.f377998c = list;
            this.f377999d = i3;
            this.f378000e = bVar;
            this.f378001f = j3;
            this.f378002g = bVar2;
            this.f378003h = msgMedalLoader;
            this.f378004i = context;
            this.f378005j = fVar;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.medal.c.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull com.tencent.timi.game.liveroom.impl.room.medal.g<?> data, @NotNull CharSequence renderResult) {
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(renderResult, "renderResult");
            this.f377996a.element++;
            Integer num = this.f377997b.get(Integer.valueOf(data.b()));
            Intrinsics.checkNotNull(num);
            this.f377998c.add(num.intValue(), renderResult);
            if (this.f377996a.element == this.f377999d) {
                if (QLog.isColorLevel()) {
                    AegisLogger.INSTANCE.i("Chat_Message|MsgMedalRender", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, "render uid= " + this.f378000e.f273756a + " complete,cost " + (System.currentTimeMillis() - this.f378001f) + " ms");
                }
                this.f378002g.a(this.f378000e, this.f378003h.i(this.f378004i, this.f378005j, this.f377998c));
            }
        }
    }

    public MsgMedalLoader(long j3) {
        this.roomId = j3;
        HashMap<Integer, com.tencent.timi.game.liveroom.impl.room.medal.c<?, CharSequence>> hashMap = new HashMap<>();
        this.renders = hashMap;
        this.defaultRender = new a();
        hashMap.put(4, new com.tencent.timi.game.liveroom.impl.room.medal.render.b());
        hashMap.put(7, new f());
    }

    private final List<sr4.g> c(List<sr4.g> medalInfoList) {
        boolean z16;
        uj4.b bVar = uj4.b.f439096a;
        long j3 = this.roomId;
        if (bVar.d(j3, wj4.c.a(j3))) {
            return medalInfoList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : medalInfoList) {
            if (2 != ((sr4.g) obj).f434388d) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final List<sr4.g> d(List<sr4.g> medalInfoList) {
        boolean z16;
        if (jj4.d.g()) {
            return medalInfoList;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : medalInfoList) {
            if (4 != ((sr4.g) obj).f434388d) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final com.tencent.timi.game.liveroom.impl.room.medal.c<? extends Object, CharSequence> e(int type) {
        com.tencent.timi.game.liveroom.impl.room.medal.c<? extends Object, CharSequence> cVar = (com.tencent.timi.game.liveroom.impl.room.medal.c) this.renders.get(Integer.valueOf(type));
        if (cVar == null) {
            return this.defaultRender;
        }
        return cVar;
    }

    private final Bitmap f(Context context, com.tencent.mobileqq.qqlive.widget.chat.message.h msg2) {
        Drawable drawable;
        float f16;
        if (lk4.c.f414972a.j(msg2.b())) {
            drawable = context.getResources().getDrawable(R.drawable.nti);
            f16 = 31.0f;
        } else {
            drawable = context.getResources().getDrawable(R.drawable.nth);
            f16 = 16.0f;
        }
        if (drawable == null) {
            AegisLogger.INSTANCE.e("Chat_Message|MsgMedalRender", "getRoleSpeakDrawable", "msg=" + msg2);
            return null;
        }
        return com.tencent.mobileqq.qqlive.widget.util.b.f274062a.a(drawable, lk4.e.b(context, f16), lk4.e.b(context, 16.0f));
    }

    private final String g(com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        if (msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.h) {
            return com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.c(((com.tencent.mobileqq.qqlive.widget.chat.message.h) msg2).b());
        }
        if (!(msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.d)) {
            return "";
        }
        int e16 = com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.e(this.roomId, ((com.tencent.mobileqq.qqlive.widget.chat.message.d) msg2).b().sender);
        boolean z16 = false;
        if (1 <= e16 && e16 < 4) {
            z16 = true;
        }
        if (!z16) {
            return "";
        }
        return String.valueOf(e16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence i(Context context, com.tencent.mobileqq.qqlive.widget.chat.message.f msg2, List<? extends CharSequence> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        SpannableString o16 = o(context, msg2);
        if (o16 != null) {
            spannableStringBuilder.append((CharSequence) o16);
        }
        SpannableString n3 = n(context, msg2);
        if (n3 != null) {
            spannableStringBuilder.append((CharSequence) n3);
        }
        if (list != null) {
            for (CharSequence charSequence : list) {
                if (!TextUtils.isEmpty(charSequence)) {
                    spannableStringBuilder.append(charSequence);
                    spannableStringBuilder.append((CharSequence) " ");
                }
            }
        }
        return spannableStringBuilder;
    }

    private final boolean j(com.tencent.mobileqq.qqlive.widget.chat.message.h msg2) {
        lk4.c cVar = lk4.c.f414972a;
        if (!cVar.j(msg2.b()) && !cVar.i(msg2.b())) {
            return false;
        }
        return true;
    }

    private final boolean k(com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        if ((msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.h) && com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.f(((com.tencent.mobileqq.qqlive.widget.chat.message.h) msg2).b())) {
            return true;
        }
        if ((msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.d) && com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.g(this.roomId, ((com.tencent.mobileqq.qqlive.widget.chat.message.d) msg2).b().sender)) {
            return true;
        }
        return false;
    }

    private final List<sr4.g> l(List<sr4.g> medalList) {
        ArrayList arrayList = new ArrayList(medalList);
        final MsgMedalLoader$orderMedalList$1 msgMedalLoader$orderMedalList$1 = new Function2<sr4.g, sr4.g, Integer>() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.render.MsgMedalLoader$orderMedalList$1
            @Override // kotlin.jvm.functions.Function2
            @NotNull
            public final Integer invoke(sr4.g gVar, sr4.g gVar2) {
                int i3 = gVar.f434388d;
                int i16 = gVar2.f434388d;
                int i17 = 0;
                if (i3 != i16) {
                    if (i3 == 7) {
                        i17 = -1;
                    } else if (i16 == 7) {
                        i17 = 1;
                    }
                }
                return Integer.valueOf(i17);
            }
        };
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: com.tencent.timi.game.liveroom.impl.room.medal.render.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int m3;
                m3 = MsgMedalLoader.m(Function2.this, obj, obj2);
                return m3;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int m(Function2 tmp0, Object obj, Object obj2) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Number) tmp0.invoke(obj, obj2)).intValue();
    }

    private final SpannableString n(Context context, com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        if (!(msg2 instanceof com.tencent.mobileqq.qqlive.widget.chat.message.h)) {
            return null;
        }
        com.tencent.mobileqq.qqlive.widget.chat.message.h hVar = (com.tencent.mobileqq.qqlive.widget.chat.message.h) msg2;
        if (!j(hVar)) {
            return null;
        }
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Chat_Message|MsgMedalRender", "renderAdminOrAnchorIcon");
        SpannableString spannableString = new SpannableString(" ");
        Bitmap f16 = f(context, hVar);
        if (f16 == null) {
            companion.e("Chat_Message|MsgMedalRender", "renderAdminOrAnchorIcon", "bitmap=null");
            return null;
        }
        spannableString.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.a(f16, 0, wi2.c.b(4)), 0, 1, 33);
        return spannableString;
    }

    private final SpannableString o(Context context, com.tencent.mobileqq.qqlive.widget.chat.message.f msg2) {
        if (!k(msg2)) {
            return null;
        }
        String g16 = g(msg2);
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        companion.i("Chat_Message|MsgMedalRender", "renderTopThreeCrown");
        if (TextUtils.isEmpty(g16)) {
            companion.e("Chat_Message|MsgMedalRender", "renderTopThreeCrown", "renderTopThreeCrown value=" + g16);
            return null;
        }
        SpannableString spannableString = new SpannableString(" ");
        Drawable d16 = com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.d(context, g16);
        if (d16 == null) {
            companion.e("Chat_Message|MsgMedalRender", "renderTopThreeCrown", "renderTopThreeCrown drawable=null");
            return null;
        }
        Bitmap a16 = com.tencent.mobileqq.qqlive.widget.util.b.f274062a.a(d16, wi2.c.b(28), wi2.c.b(16));
        if (a16 == null) {
            companion.e("Chat_Message|MsgMedalRender", "renderTopThreeCrown", "renderTopThreeCrown bitmap=null");
            return null;
        }
        spannableString.setSpan(new com.tencent.mobileqq.qqlive.widget.chat.span.a(a16, 0, wi2.c.b(4)), 0, 1, 33);
        return spannableString;
    }

    public final void h(@NotNull Context context, @NotNull com.tencent.mobileqq.qqlive.widget.chat.message.f msg2, @Nullable com.tencent.mobileqq.qqlive.widget.chat.data.b userMedalInfo, @NotNull c.b callback) {
        sr4.g gVar;
        Integer num;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (userMedalInfo == null) {
            callback.a(null, i(context, msg2, null));
            return;
        }
        ArrayList<com.tencent.timi.game.liveroom.impl.room.medal.g<?>> arrayList = new ArrayList();
        List<sr4.g> list = userMedalInfo.f273762g;
        Intrinsics.checkNotNullExpressionValue(list, "userMedalInfo.medalInfoNewList");
        List<sr4.g> c16 = c(d(list));
        if (c16.isEmpty()) {
            callback.a(userMedalInfo, i(context, msg2, null));
            return;
        }
        Iterator<T> it = l(c16).iterator();
        while (it.hasNext()) {
            arrayList.add(new com.tencent.timi.game.liveroom.impl.room.medal.data.b((sr4.g) it.next()));
        }
        int size = arrayList.size();
        AegisLogger.Companion companion = AegisLogger.INSTANCE;
        String str = "render uid=" + userMedalInfo.f273756a + ",medal size=" + size;
        String str2 = "Chat_Message|MsgMedalRender";
        String str3 = ChildProcessServiceWrapper.PROCESS_TYPE_RENDER;
        companion.i("Chat_Message|MsgMedalRender", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, str);
        if (size == 0) {
            callback.a(userMedalInfo, i(context, msg2, null));
            return;
        }
        Ref.IntRef intRef = new Ref.IntRef();
        HashMap hashMap = new HashMap();
        ArrayList arrayList2 = new ArrayList(size);
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            arrayList2.add("");
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (com.tencent.timi.game.liveroom.impl.room.medal.g<?> gVar2 : arrayList) {
            int i17 = i3 + 1;
            AegisLogger.Companion companion2 = AegisLogger.INSTANCE;
            int c17 = gVar2.c();
            Object a16 = gVar2.a();
            if (a16 instanceof sr4.g) {
                gVar = (sr4.g) a16;
            } else {
                gVar = null;
            }
            if (gVar != null) {
                num = Integer.valueOf(gVar.f434397m);
            } else {
                num = null;
            }
            companion2.i(str2, str3, "render type:" + c17 + ", level:" + num);
            hashMap.put(Integer.valueOf(gVar2.b()), Integer.valueOf(i3));
            e(gVar2.c()).a(gVar2, new b(intRef, hashMap, arrayList2, size, userMedalInfo, currentTimeMillis, callback, this, context, msg2));
            i3 = i17;
            arrayList2 = arrayList2;
            hashMap = hashMap;
            str3 = str3;
            str2 = str2;
            size = size;
        }
    }
}
