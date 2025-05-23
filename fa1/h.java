package fa1;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StFeed;
import android.R;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h implements b {
    @Override // fa1.b
    public int getType() {
        return R.id.edit;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        SubscribeColorNoteReserveBean subscribeColorNoteReserveBean;
        try {
            byte[] reserve = colorNote.getReserve();
            if (reserve == null || (subscribeColorNoteReserveBean = (SubscribeColorNoteReserveBean) com.tencent.biz.subscribe.utils.h.a(reserve)) == null) {
                return;
            }
            CertifiedAccountMeta$StFeed certifiedAccountMeta$StFeed = new CertifiedAccountMeta$StFeed();
            certifiedAccountMeta$StFeed.mergeFrom(subscribeColorNoteReserveBean.feedData);
            QLog.d("SubscribeColorNoteLauncher", 2, "articleInfo From ColorNote :\n" + certifiedAccountMeta$StFeed.toString());
            com.tencent.biz.subscribe.d.s(context, "", certifiedAccountMeta$StFeed, new ExtraTypeInfo(subscribeColorNoteReserveBean.pageType, 9003), null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
    }
}
