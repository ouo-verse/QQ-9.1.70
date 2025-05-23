package com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.helper.LateInitHelper.CreateHelperIntent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyApi;
import com.tencent.qqnt.aio.adapter.api.IAIOEmoReplyMorePanel;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
import com.tencent.qqnt.aio.menu.MenuUtils;
import com.tencent.qqnt.emotion.api.IAIOEmoticonApi;
import com.tencent.qqnt.emotion.info.SystemAndEmojiEmotionInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.msg.api.IMsgService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000fB\u0017\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/a;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/c;", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "o", "Landroid/view/View;", "v", NodeProps.ON_CLICK, "itemView", "Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;", "adapter", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/ui/e;)V", "H", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a extends com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c {
    static IPatchRedirector $redirector_;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/a$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", "a", "", "DT_EMOTICON_PANEL_SOURCE_FROM_MENU", "Ljava/lang/String;", "", "HOLDER_HEIGHT", UserInfo.SEX_FEMALE, "HOLDER_WIDTH", "IMG_SIZE", "TAG", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.a$a, reason: collision with other inner class name and from kotlin metadata */
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
            imageView.setFocusable(true);
            imageView.setImageResource(R.drawable.j6b);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(x.a(34.0f), x.a(24.0f));
            layoutParams.gravity = 16;
            imageView.setLayoutParams(layoutParams);
            imageView.setPadding(x.a(7.0f), x.a(2.0f), x.a(7.0f), x.a(2.0f));
            imageView.setImportantForAccessibility(2);
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(0);
            linearLayout.addView(imageView);
            linearLayout.setFocusable(true);
            linearLayout.setImportantForAccessibility(1);
            AccessibilityUtil.p(linearLayout, HardCodeUtil.qqStr(R.string.zuh));
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/a$b", "Lcom/tencent/qqnt/aio/emoreply/j;", "", "emoticonType", EmojiManagerServiceConstant.PARAMS_EMOTICON_EID, "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class b implements com.tencent.qqnt.aio.emoreply.j {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MsgRecord f191271b;

        b(MsgRecord msgRecord) {
            this.f191271b = msgRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) msgRecord);
            }
        }

        @Override // com.tencent.qqnt.aio.emoreply.j
        public void a(int emoticonType, int emoticonId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(emoticonType), Integer.valueOf(emoticonId));
            } else {
                a.this.p().V(emoticonId, emoticonType, this.f191271b, new com.tencent.qqnt.aio.emoreply.h(new SystemAndEmojiEmotionInfo(emoticonType, emoticonId, ""), new int[]{0, 0}, new int[]{0, 0}, false, null, false, null, 0, 240, null));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/aio/msglist/holder/component/msgtail/tailitem/ui/a$c", "Lcom/tencent/qqnt/aio/emoreply/j;", "", "emoticonType", EmojiManagerServiceConstant.PARAMS_EMOTICON_EID, "", "a", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes11.dex */
    public static final class c implements com.tencent.qqnt.aio.emoreply.j {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MsgRecord f191273b;

        c(MsgRecord msgRecord) {
            this.f191273b = msgRecord;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) msgRecord);
            }
        }

        @Override // com.tencent.qqnt.aio.emoreply.j
        public void a(int emoticonType, int emoticonId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(emoticonType), Integer.valueOf(emoticonId));
            } else {
                a.this.p().V(((IAIOEmoticonApi) QRoute.api(IAIOEmoticonApi.class)).convertToLocal(emoticonId, emoticonType), emoticonType, this.f191273b, null);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62217);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull View itemView, @NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.ui.e adapter) {
        super(itemView, adapter);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) adapter);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.component.msgtail.tailitem.ui.c
    public void o(@NotNull com.tencent.mobileqq.aio.msglist.holder.component.msgtail.data.g item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) item);
        } else {
            Intrinsics.checkNotNullParameter(item, "item");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        long j3;
        EventCollector.getInstance().onViewClickedBefore(v3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) v3);
        } else {
            MsgRecord a16 = q().a();
            if (a16 != null) {
                a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
                ITroopApi iTroopApi = (ITroopApi) companion.a(ITroopApi.class);
                String str = a16.peerUid;
                Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
                if (!iTroopApi.isGagMode(str)) {
                    ITroopApi iTroopApi2 = (ITroopApi) companion.a(ITroopApi.class);
                    String str2 = a16.peerUid;
                    Intrinsics.checkNotNullExpressionValue(str2, "msgRecord.peerUid");
                    if (!iTroopApi2.isExitTroop(str2)) {
                        Long groupMsgStorageTime = ((IMsgService) QRoute.api(IMsgService.class)).getGroupMsgStorageTime();
                        if (groupMsgStorageTime != null) {
                            j3 = groupMsgStorageTime.longValue();
                        } else {
                            j3 = 8640000;
                        }
                        long serverTimeMillis = (NetConnInfoCenter.getServerTimeMillis() / 1000) - j3;
                        if (serverTimeMillis >= a16.msgTime) {
                            QLog.i("TailItemHolder-AddEmoReplyHolder", 1, serverTimeMillis + " > msgTime");
                            String toast = HardCodeUtil.qqStr(R.string.ypr);
                            Context context = this.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(toast, "toast");
                            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context, toast);
                        } else if (a16.emojiLikesList.size() >= 20) {
                            String toast2 = HardCodeUtil.qqStr(R.string.ypq);
                            Context context2 = this.itemView.getContext();
                            Intrinsics.checkNotNullExpressionValue(toast2, "toast");
                            com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context2, toast2);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("touin", String.valueOf(a16.senderUin));
                            hashMap.put("click_pos", "3");
                            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_expression_responds_result_area", hashMap);
                            if (MenuUtils.f351230a.l()) {
                                if (v3 != null) {
                                    Context context3 = this.itemView.getContext();
                                    if (context3 instanceof FragmentActivity) {
                                        com.tencent.qqnt.aio.utils.c.f352293a.a((FragmentActivity) context3, new CreateHelperIntent.CreateHelperRealIntent(4, new AIOMsgListEvent.ShowEmoReplyMoreMenuEvent(a16, v3, "2", IAIOEmoReplyMorePanel.Source.EMO_REPLY_ADD, null, new b(a16)), null, 4, null));
                                    }
                                }
                            } else {
                                IAIOEmoReplyApi iAIOEmoReplyApi = (IAIOEmoReplyApi) companion.a(IAIOEmoReplyApi.class);
                                Context context4 = this.itemView.getContext();
                                Intrinsics.checkNotNullExpressionValue(context4, "itemView.context");
                                iAIOEmoReplyApi.showAIOEmoReplyPanel(context4, a16, new c(a16), "2");
                            }
                        }
                    }
                }
                String toast3 = HardCodeUtil.qqStr(R.string.ypr);
                Context context5 = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(toast3, "toast");
                com.tencent.mobileqq.aio.msglist.holder.component.msgtail.utils.a.m(context5, toast3);
                QLog.d("TailItemHolder-AddEmoReplyHolder", 1, "isGagMode or isExitTroop");
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }
}
