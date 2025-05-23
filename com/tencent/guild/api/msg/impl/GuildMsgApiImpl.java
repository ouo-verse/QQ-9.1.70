package com.tencent.guild.api.msg.impl;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.MsgExtKt;
import com.tencent.qqnt.msg.api.IMsgService;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import nq0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016Jo\u0010 \u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00042M\u0010\u001f\u001aI\u0012\u0013\u0012\u00110\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001d\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\r0\u0017H\u0016J\u001a\u0010\"\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/api/msg/impl/GuildMsgApiImpl;", "Lcom/tencent/guild/api/msg/IGuildMsgApi;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "isSendFail", "", "getMsgSendUid", "Landroid/content/Context;", "context", "Landroid/widget/TextView;", "createAIOMsgTextView", "tv", "", "fixTextViewANRForAnd10", "getNTKernelExtDataPath", "getNTKernelDBPath", "getNTKernelTempPath", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "msgSeq", QCircleDaTongConstant.ElementParamValue.PROFILE_GUEST_TYPE, "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "ret", NotificationCompat.CATEGORY_ERROR, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msg", "cb", "getAnnouncement", AppConstants.Key.COLUMN_MSG_SEQ, "locateToMessage", "<init>", "()V", "Companion", "a", "nt-guild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildMsgApiImpl implements IGuildMsgApi {
    public static final int OTHER_SPACE_WIDTH = 76;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAnnouncement$lambda$2(Function3 msgFilter, int i3, String err, ArrayList arrayList, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(msgFilter, "$msgFilter");
        Integer valueOf = Integer.valueOf(i3);
        Intrinsics.checkNotNullExpressionValue(err, "err");
        msgFilter.invoke(valueOf, err, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getAnnouncement$lambda$3(Function3 tmp0, int i3, String str, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(Integer.valueOf(i3), str, arrayList);
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    @NotNull
    public TextView createAIOMsgTextView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TextView textView = new TextView(context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        TextUtils.fixTextViewANRForAnd10(textView);
        textView.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        textView.setClickable(false);
        textView.setFocusable(false);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Intrinsics.checkNotNullExpressionValue(displayMetrics, "context.resources.displayMetrics");
        float f16 = displayMetrics.density;
        textView.setMaxWidth((((int) (Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) - (76 * f16))) - context.getResources().getDimensionPixelSize(R.dimen.f158955cc0)) - context.getResources().getDimensionPixelSize(R.dimen.cbz));
        textView.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.ayn));
        return textView;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    public void fixTextViewANRForAnd10(@NotNull TextView tv5) {
        Intrinsics.checkNotNullParameter(tv5, "tv");
        TextUtils.fixTextViewANRForAnd10(tv5);
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    public void getAnnouncement(@NotNull Contact peer, long msgSeq, boolean guest, @NotNull final Function3<? super Integer, ? super String, ? super MsgRecord, Unit> cb5) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        Intrinsics.checkNotNullParameter(cb5, "cb");
        QRouteApi api = QRoute.api(IMsgService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMsgService::class.java)");
        IMsgService iMsgService = (IMsgService) api;
        final Function3<Integer, String, List<? extends MsgRecord>, Unit> function3 = new Function3<Integer, String, List<? extends MsgRecord>, Unit>() { // from class: com.tencent.guild.api.msg.impl.GuildMsgApiImpl$getAnnouncement$msgFilter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, List<? extends MsgRecord> list) {
                invoke(num.intValue(), str, (List<MsgRecord>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final void invoke(int i3, @NotNull String err, @Nullable List<MsgRecord> list) {
                Intrinsics.checkNotNullParameter(err, "err");
                Function3<Integer, String, MsgRecord, Unit> function32 = cb5;
                Integer valueOf = Integer.valueOf(i3);
                MsgRecord msgRecord = null;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        MsgRecord msgRecord2 = (MsgRecord) next;
                        if (msgRecord2 != null && MsgExtKt.A(msgRecord2) && MsgExtKt.R(msgRecord2)) {
                            msgRecord = next;
                            break;
                        }
                    }
                    msgRecord = msgRecord;
                }
                function32.invoke(valueOf, err, msgRecord);
            }
        };
        if (guest) {
            iMsgService.getGuestMsgByRange(peer, msgSeq + 1, 1, true, new Random().nextInt(), new IGuestMsgOperateCallback() { // from class: com.tencent.guild.api.msg.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGuestMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList, HashMap hashMap) {
                    GuildMsgApiImpl.getAnnouncement$lambda$2(Function3.this, i3, str, arrayList, hashMap);
                }
            });
        } else {
            iMsgService.getMsgsBySeqRange(peer, msgSeq, msgSeq, new IMsgOperateCallback() { // from class: com.tencent.guild.api.msg.impl.b
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GuildMsgApiImpl.getAnnouncement$lambda$3(Function3.this, i3, str, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    @NotNull
    public String getMsgSendUid(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (msgItem instanceof GuildMsgItem) {
            String str = ((GuildMsgItem) msgItem).getMsgRecord().senderUid;
            Intrinsics.checkNotNullExpressionValue(str, "msgItem.msgRecord.senderUid");
            return str;
        }
        return "";
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    @NotNull
    public String getNTKernelDBPath() {
        int lastIndexOf$default;
        String it = BaseApplication.getContext().getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(it, "it");
        lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default((CharSequence) it, "/", 0, false, 6, (Object) null);
        String substring = it.substring(0, lastIndexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        return substring + "/databases/";
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    @NotNull
    public String getNTKernelExtDataPath() {
        String SDCARD_FILE_SAVE_PATH = AppConstants.SDCARD_FILE_SAVE_PATH;
        Intrinsics.checkNotNullExpressionValue(SDCARD_FILE_SAVE_PATH, "SDCARD_FILE_SAVE_PATH");
        return SDCARD_FILE_SAVE_PATH;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    @NotNull
    public String getNTKernelTempPath() {
        return AppConstants.SDCARD_FILE_SAVE_PATH + ".guildtmp/";
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    public boolean isSendFail(@NotNull com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof GuildMsgItem)) {
            return false;
        }
        int i3 = ((GuildMsgItem) msgItem).getMsgRecord().sendStatus;
        if (!msgItem.isSelf() || i3 != 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.msg.IGuildMsgApi
    public void locateToMessage(long msgseq, @Nullable Context context) {
        com.tencent.guild.aio.util.flowbus.a.INSTANCE.b(new d(msgseq, true));
    }
}
