package com.tencent.mobileqq.vas.message.processor;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&Ja\u0010\u0015\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fH&J(\u0010\u0016\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&J\"\u0010\u001c\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0004H&J,\u0010%\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/vas/message/processor/a;", "", "", "uin", "Lcom/tencent/state/square/api/MessageRecordType;", "type", "", "isReceiveNotify", "Landroidx/fragment/app/Fragment;", "fragment", "", "scene", "Landroid/os/Bundle;", "bundle", "nickname", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "success", "", "callback", "a", "openSettingsPage", "limitNum", "", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "c", "includeUnNotifyMsg", "b", "messageRecordType", "getName", "", "msgId", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "errorCode", "errorMsg", "onSendMsgError", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    void a(Fragment fragment, int scene, String uin, MessageRecordType type, Bundle bundle, String nickname, Function1<? super Boolean, Unit> callback);

    SquareBaseMessageRecord b(String uin, boolean includeUnNotifyMsg, MessageRecordType type);

    List<SquareBaseMessageRecord> c(int limitNum, MessageRecordType type);

    String getName(String uin, MessageRecordType messageRecordType);

    boolean isReceiveNotify(String uin, MessageRecordType type);

    void onSendMsgError(long msgId, Contact peer, int errorCode, String errorMsg);

    void openSettingsPage(Fragment fragment, int scene, String uin, MessageRecordType type);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.vas.message.processor.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C8915a {
        public static void a(a aVar, long j3, Contact contact, int i3, String str) {
        }
    }
}
