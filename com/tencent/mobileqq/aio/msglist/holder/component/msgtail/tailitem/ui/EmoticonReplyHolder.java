package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.EmojiUpdateTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0017\u0012\u0006\u0010\u0017\u001a\u00020\t\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R\u001c\u0010\u0012\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0016\u001a\n \u000f*\u0004\u0018\u00010\u00130\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/EmoticonReplyHolder;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/b;", "emojiItem", "", "t", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "o", "Landroid/view/View;", "v", "", NodeProps.ON_LONG_CLICK, NodeProps.ON_CLICK, "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "H", "Landroid/widget/ImageView;", "emojiImage", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/EmojiUpdateTextView;", "I", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/EmojiUpdateTextView;", "emojiCntView", "itemView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "J", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class EmoticonReplyHolder extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: H, reason: from kotlin metadata */
    private final ImageView emojiImage;

    /* renamed from: I, reason: from kotlin metadata */
    private final EmojiUpdateTextView emojiCntView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/EmoticonReplyHolder$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.EmoticonReplyHolder$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final View a(@NotNull Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            }
            Intrinsics.checkNotNullParameter(context, "context");
            ImageView imageView = new ImageView(context);
            imageView.setId(R.id.shc);
            imageView.setFocusable(true);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(x.a(20.0f), x.a(20.0f));
            layoutParams.leftMargin = x.a(6.0f);
            layoutParams.rightMargin = x.a(4.0f);
            layoutParams.gravity = 16;
            imageView.setLayoutParams(layoutParams);
            imageView.setImportantForAccessibility(2);
            EmojiUpdateTextView emojiUpdateTextView = new EmojiUpdateTextView(context);
            emojiUpdateTextView.setId(R.id.shb);
            emojiUpdateTextView.setClickable(false);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = x.a(7.0f);
            layoutParams2.gravity = 16;
            emojiUpdateTextView.setLayoutParams(layoutParams2);
            emojiUpdateTextView.setImportantForAccessibility(2);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(imageView);
            linearLayout.addView(emojiUpdateTextView);
            linearLayout.setFocusable(true);
            linearLayout.setImportantForAccessibility(1);
            return linearLayout;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62235);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmoticonReplyHolder(@NotNull View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
        } else {
            this.emojiImage = (ImageView) itemView.findViewById(R.id.shc);
            this.emojiCntView = (EmojiUpdateTextView) itemView.findViewById(R.id.shb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b emojiItem) {
        this.emojiCntView.setChecked(emojiItem.g());
        this.emojiCntView.setTextWithAnim(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.e(emojiItem.b()), emojiItem.g());
        ImageView imageView = this.emojiImage;
        imageView.startAnimation(AnimationUtils.loadAnimation(imageView.getContext(), R.anim.f154467ll));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (r1 != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x009e  */
    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item) {
        boolean z16;
        String str;
        Drawable drawable;
        URLDrawable uRLDrawable;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) item;
        this.emojiCntView.setText(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.e(bVar.b()));
        this.emojiCntView.setChecked(bVar.g());
        Drawable b16 = com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.b(bVar.c(), bVar.d());
        Drawable drawable2 = null;
        if (bVar.d() == 1) {
            if (b16 != null) {
                if (b16 instanceof URLDrawable) {
                    uRLDrawable = (URLDrawable) b16;
                } else {
                    uRLDrawable = null;
                }
                if (uRLDrawable != null && uRLDrawable.getStatus() == 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            }
            z16 = true;
            if (z16) {
                QLog.i("TailItemHolder-EmoticonReplyHolder", 1, "getEmojiDrawable failed localId=" + bVar.c() + ", emojiType: " + bVar.d() + ", try use local drawable");
                b16 = QQSysFaceUtil.getFaceDrawableFromLocal(bVar.c());
            }
            if (b16 == null) {
                this.emojiImage.setImageDrawable(b16);
            } else {
                QLog.i("TailItemHolder-EmoticonReplyHolder", 1, "use FaceDrawableFromLocal but still null");
                this.emojiImage.setImageDrawable(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.b(bVar.c(), bVar.d()));
            }
            if (!bVar.f()) {
                this.emojiImage.setVisibility(0);
            } else {
                this.emojiImage.setVisibility(4);
            }
            this.emojiCntView.setVisibility(0);
            String str2 = com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.f(bVar.c(), bVar.d()) + HardCodeUtil.qqStr(R.string.zui) + bVar.b();
            if (!this.emojiCntView.isChecked()) {
                str = str2 + ",\u5df2\u56de\u5e94";
            } else {
                str = str2 + ",\u672a\u56de\u5e94";
            }
            AccessibilityUtil.p(this.itemView, str);
            View view = this.itemView;
            drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.j7s);
            if (drawable != null) {
                drawable2 = drawable.mutate();
            }
            view.setBackground(drawable2);
        }
        z16 = false;
        if (z16) {
        }
        if (b16 == null) {
        }
        if (!bVar.f()) {
        }
        this.emojiCntView.setVisibility(0);
        String str22 = com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.f(bVar.c(), bVar.d()) + HardCodeUtil.qqStr(R.string.zui) + bVar.b();
        if (!this.emojiCntView.isChecked()) {
        }
        AccessibilityUtil.p(this.itemView, str);
        View view2 = this.itemView;
        drawable = ContextCompat.getDrawable(view2.getContext(), R.drawable.j7s);
        if (drawable != null) {
        }
        view2.setBackground(drawable2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        long j3;
        String str;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g q16 = q();
            Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.EmoReplyItem");
            final com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) q16;
            MsgRecord a16 = q().a();
            if (a16 != null) {
                Long groupMsgStorageTime = ((IMsgService) QRoute.api(IMsgService.class)).getGroupMsgStorageTime();
                if (groupMsgStorageTime != null) {
                    j3 = groupMsgStorageTime.longValue();
                } else {
                    j3 = 8640000;
                }
                long serverTimeMillis = (NetConnInfoCenter.getServerTimeMillis() / 1000) - j3;
                if (serverTimeMillis >= a16.msgTime) {
                    QLog.i("TailItemHolder-EmoticonReplyHolder", 1, serverTimeMillis + " > msgTime");
                    String toast = HardCodeUtil.qqStr(R.string.ypr);
                    Context context = this.itemView.getContext();
                    Intrinsics.checkNotNullExpressionValue(toast, "toast");
                    com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context, toast);
                } else {
                    HashMap hashMap = new HashMap();
                    hashMap.put("touin", String.valueOf(a16.senderUin));
                    if (bVar.g()) {
                        str = "1";
                    } else {
                        str = "2";
                    }
                    hashMap.put("click_pos", str);
                    hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, Integer.valueOf(((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(bVar.c(), bVar.d())));
                    com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_expression_responds_result_area", hashMap);
                    p().e0(bVar, new com.tencent.qqnt.aio.emoreply.h(new SystemAndEmojiEmotionInfo(bVar.d(), bVar.c(), ""), new int[]{0, 0}, new int[]{0, 0}, false, null, false, null, 0, 240, null), new Function0<Unit>(bVar) { // from class: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.EmoticonReplyHolder$onClick$1$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b $emojiItem;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$emojiItem = bVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) EmoticonReplyHolder.this, (Object) bVar);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                                EmoticonReplyHolder.this.t(this.$emojiItem);
                            } else {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c, android.view.View.OnLongClickListener
    public boolean onLongClick(@NotNull View v3) {
        String str;
        boolean z16;
        EventCollector.getInstance().onViewLongClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            z16 = ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3)).booleanValue();
        } else {
            Intrinsics.checkNotNullParameter(v3, "v");
            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g q16 = q();
            Intrinsics.checkNotNull(q16, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.EmoReplyItem");
            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b bVar = (com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.b) q16;
            MsgRecord e16 = bVar.e();
            ArrayList arrayList = new ArrayList();
            ArrayList<MsgEmojiLikes> arrayList2 = e16.emojiLikesList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "msgRecord.emojiLikesList");
            int i3 = 0;
            int i16 = 0;
            for (Object obj : arrayList2) {
                int i17 = i16 + 1;
                if (i16 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MsgEmojiLikes msgEmojiLikes = (MsgEmojiLikes) obj;
                Intrinsics.checkNotNullExpressionValue(msgEmojiLikes, "msgEmojiLikes");
                if (bVar.k(msgEmojiLikes)) {
                    i3 = i16;
                }
                arrayList.add(new com.tencent.qqnt.aio.emoreply.i(com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.d(msgEmojiLikes), (int) msgEmojiLikes.emojiType, (int) msgEmojiLikes.likesCnt));
                i16 = i17;
            }
            IAIOEmoReplyApi iAIOEmoReplyApi = (IAIOEmoReplyApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOEmoReplyApi.class);
            Context context = v3.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "v.context");
            String str2 = e16.peerUid;
            Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.peerUid");
            String str3 = e16.senderUid;
            Intrinsics.checkNotNullExpressionValue(str3, "msgRecord.senderUid");
            IAIOEmoReplyApi.a.a(iAIOEmoReplyApi, context, e16, new com.tencent.qqnt.aio.emoreply.f(str2, str3, i3, arrayList), null, 8, null);
            HashMap hashMap = new HashMap();
            hashMap.put("touin", String.valueOf(e16.senderUin));
            if (bVar.g()) {
                str = "1";
            } else {
                str = "2";
            }
            hashMap.put("click_pos", str);
            hashMap.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, Integer.valueOf(((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToServer(bVar.c(), bVar.d())));
            hashMap.put("qq_eid", "em_bas_aio_expression_responds_result_area");
            com.tencent.mobileqq.aio.utils.b.f194119a.n("ev_bas_expression_response_result", hashMap);
            z16 = true;
        }
        EventCollector.getInstance().onViewLongClicked(v3);
        return z16;
    }
}
