package com.tencent.mobileqq.troop.selecttroopmember;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.widget.search.ext.ChatUserListExt;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends ChatUserListExt.BaseChatExtAdapter<ResultRecord> {
    static IPatchRedirector $redirector_;

    /* renamed from: m, reason: collision with root package name */
    private InterfaceViewOnClickListenerC8768a f298433m;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.selecttroopmember.a$a, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceViewOnClickListenerC8768a extends View.OnClickListener {
        void Mf(ResultRecord resultRecord);
    }

    public a(InterfaceViewOnClickListenerC8768a interfaceViewOnClickListenerC8768a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceViewOnClickListenerC8768a);
        } else {
            this.f298433m = interfaceViewOnClickListenerC8768a;
        }
    }

    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    protected View createIconView(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        return new QQProAvatarView(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void bindViewHolder(ChatUserListExt.ViewHolder viewHolder, int i3, ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, viewHolder, Integer.valueOf(i3), resultRecord);
            return;
        }
        viewHolder.tvName.setVisibility(8);
        ((QQProAvatarView) viewHolder.ivIcon).x(1, resultRecord.uin, null);
        viewHolder.itemView.setTag(resultRecord);
        viewHolder.itemView.setOnClickListener(this.f298433m);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public String getDesc(ResultRecord resultRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resultRecord);
        }
        return resultRecord.name;
    }

    @Override // com.tencent.mobileqq.widget.search.ext.ChatUserListExt.BaseChatExtAdapter
    public boolean tryGrayItemOrDelete() {
        ResultRecord resultRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        int num_backgournd_icon = getNUM_BACKGOURND_ICON() - 1;
        if (num_backgournd_icon >= 0) {
            resultRecord = getItem(num_backgournd_icon);
        } else {
            resultRecord = null;
        }
        boolean z16 = this.mIsInDel;
        boolean tryGrayItemOrDelete = super.tryGrayItemOrDelete();
        if (resultRecord != null && tryGrayItemOrDelete && z16) {
            this.f298433m.Mf(resultRecord);
        }
        return tryGrayItemOrDelete;
    }
}
