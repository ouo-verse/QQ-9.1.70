package com.tencent.mobileqq.app.fms;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FullMessageSearchResult {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public List<SearchResultItem> f195605a;

    /* renamed from: b, reason: collision with root package name */
    public int f195606b;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class SearchResultItem implements Serializable {
        static IPatchRedirector $redirector_;
        public Message lastMessage;
        public List<MessageRecord> secondPageList;
        public List<Long> secondPageMessageUniseq;
        public RecentUser user;

        public SearchResultItem() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public FullMessageSearchResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f195606b = 0;
        }
    }

    public String toString() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("FullMessageSearchResult:");
        List<SearchResultItem> list = this.f195605a;
        if (list == null) {
            sb5.append("null");
            return sb5.toString();
        }
        for (SearchResultItem searchResultItem : list) {
            sb5.append("(");
            sb5.append(searchResultItem.user.uin);
            sb5.append(",");
            List<MessageRecord> list2 = searchResultItem.secondPageList;
            int i3 = 0;
            if (list2 == null) {
                size = 0;
            } else {
                size = list2.size();
            }
            sb5.append(size);
            sb5.append(",");
            List<Long> list3 = searchResultItem.secondPageMessageUniseq;
            if (list3 != null) {
                i3 = list3.size();
            }
            sb5.append(i3);
            sb5.append(")");
        }
        sb5.append(" searchFinFlag=" + this.f195606b);
        return sb5.toString();
    }
}
