package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatHistoryStructMsgView;
import com.tencent.mobileqq.activity.ChatHistoryViewBase;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class g extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    View.OnClickListener f187173d;

    /* renamed from: e, reason: collision with root package name */
    View.OnClickListener f187174e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<Object> f187175f;

    /* renamed from: h, reason: collision with root package name */
    Context f187176h;

    /* renamed from: i, reason: collision with root package name */
    ChatHistoryViewBase f187177i;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RelativeLayout f187178a;

        /* renamed from: b, reason: collision with root package name */
        public CheckBox f187179b;

        /* renamed from: c, reason: collision with root package name */
        public URLImageView f187180c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f187181d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f187182e;

        /* renamed from: f, reason: collision with root package name */
        public Object f187183f;

        /* renamed from: g, reason: collision with root package name */
        public String f187184g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }
    }

    public g(Context context, ArrayList<Object> arrayList, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, ChatHistoryViewBase chatHistoryViewBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, arrayList, onClickListener, onClickListener2, chatHistoryViewBase);
            return;
        }
        this.f187176h = context;
        this.f187175f = arrayList;
        this.f187173d = onClickListener;
        this.f187174e = onClickListener2;
        this.f187177i = chatHistoryViewBase;
    }

    public static String a(AbsShareMsg absShareMsg, String str) {
        String str2;
        StructMsgForGeneralShare structMsgForGeneralShare;
        List<AbsStructMsgElement> list;
        if (str.equals("cover")) {
            str2 = absShareMsg.mContentCover;
        } else {
            str2 = absShareMsg.mContentTitle;
        }
        if (TextUtils.isEmpty(str2) && (absShareMsg instanceof StructMsgForGeneralShare) && (list = (structMsgForGeneralShare = (StructMsgForGeneralShare) absShareMsg).mStructMsgItemLists) != null && !list.isEmpty()) {
            for (AbsStructMsgElement absStructMsgElement : structMsgForGeneralShare.mStructMsgItemLists) {
                if (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a) {
                    com.tencent.mobileqq.structmsg.a aVar = (com.tencent.mobileqq.structmsg.a) absStructMsgElement;
                    ArrayList<AbsStructMsgElement> arrayList = aVar.U0;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        Iterator<AbsStructMsgElement> it = aVar.U0.iterator();
                        while (it.hasNext()) {
                            AbsStructMsgElement next = it.next();
                            if (str.equals("cover")) {
                                str2 = StructMsgForGeneralShare.getCoverForChatHistory(next);
                            } else {
                                str2 = StructMsgForGeneralShare.getTitleForChatHistory(next);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                break;
                            }
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            break;
                        }
                    }
                } else {
                    if (str.equals("cover")) {
                        str2 = StructMsgForGeneralShare.getCoverForChatHistory(absStructMsgElement);
                    } else {
                        str2 = StructMsgForGeneralShare.getTitleForChatHistory(absStructMsgElement);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        break;
                    }
                }
            }
        }
        return str2;
    }

    public static boolean b(MessageRecord messageRecord) {
        if (messageRecord instanceof MessageForStructing) {
            MessageForStructing messageForStructing = (MessageForStructing) messageRecord;
            AbsStructMsg absStructMsg = messageForStructing.structingMsg;
            if (absStructMsg == null) {
                messageForStructing.parse();
            }
            if (!com.tencent.biz.anonymous.a.m(messageRecord) && absStructMsg != null && absStructMsg.fwFlag != 1 && !absStructMsg.hasFlag(1)) {
                if (absStructMsg instanceof StructMsgForAudioShare) {
                    return true;
                }
                if (absStructMsg instanceof StructMsgForGeneralShare) {
                    StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) absStructMsg;
                    String a16 = a(structMsgForGeneralShare, "cover");
                    String a17 = a(structMsgForGeneralShare, "title");
                    if (!TextUtils.isEmpty(a16) && !TextUtils.isEmpty(a17)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void c(URLImageView uRLImageView, AbsShareMsg absShareMsg) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) uRLImageView, (Object) absShareMsg);
            return;
        }
        Resources resources = this.f187176h.getResources();
        String a16 = a(absShareMsg, "cover");
        if (absShareMsg instanceof StructMsgForAudioShare) {
            i3 = R.drawable.f162489h31;
        } else {
            i3 = R.drawable.h2r;
        }
        Drawable drawable = resources.getDrawable(i3);
        if (TextUtils.isEmpty(a16)) {
            uRLImageView.setImageDrawable(drawable);
            return;
        }
        if (!a16.startsWith("http://") && !a16.startsWith("https://")) {
            a16 = Uri.fromFile(new File(a16)).toString();
        }
        uRLImageView.setImageDrawable(URLDrawable.getDrawable(a16, drawable, drawable));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        ArrayList<Object> arrayList = this.f187175f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return this.f187175f.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        TextView textView;
        View view2;
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            view2 = view;
            view = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
        } else {
            Object item = getItem(i3);
            if (item instanceof MessageForStructing) {
                MessageForStructing messageForStructing = (MessageForStructing) item;
                if (view != null && (view.getTag() instanceof a)) {
                    aVar = (a) view.getTag();
                } else {
                    aVar = new a();
                    view = View.inflate(this.f187176h, R.layout.bzh, null);
                    aVar.f187178a = (RelativeLayout) view.findViewById(R.id.i0y);
                    aVar.f187179b = (CheckBox) view.findViewById(R.id.j4f);
                    aVar.f187180c = (URLImageView) view.findViewById(R.id.j4d);
                    aVar.f187181d = (TextView) view.findViewById(R.id.f164642ae0);
                    aVar.f187182e = (TextView) view.findViewById(R.id.f2a);
                    view.setTag(aVar);
                    aVar.f187178a.setTag(aVar);
                    aVar.f187178a.setOnClickListener(this.f187173d);
                }
                aVar.f187183f = messageForStructing;
                aVar.f187184g = ((ChatHistoryStructMsgView) this.f187177i).I;
                if (messageForStructing instanceof MessageForStructing) {
                    if (messageForStructing == null) {
                        messageForStructing.parse();
                    }
                    AbsStructMsg absStructMsg = messageForStructing.structingMsg;
                    if (absStructMsg != null && (absStructMsg instanceof AbsShareMsg)) {
                        AbsShareMsg absShareMsg = (AbsShareMsg) absStructMsg;
                        c(aVar.f187180c, absShareMsg);
                        aVar.f187181d.setText(a(absShareMsg, "title"));
                        aVar.f187182e.setText(absShareMsg.mSourceName);
                    }
                } else {
                    aVar.f187181d.setText("");
                    aVar.f187182e.setText("");
                }
                if (this.f187177i.g()) {
                    aVar.f187179b.setVisibility(0);
                    aVar.f187179b.setChecked(this.f187177i.f175325e.S2(messageForStructing));
                } else {
                    aVar.f187179b.setVisibility(8);
                }
            } else if (item instanceof String) {
                if (view != null && (view.getTag() instanceof TextView)) {
                    textView = (TextView) view.getTag();
                } else {
                    view = View.inflate(this.f187176h, R.layout.bzi, null);
                    textView = (TextView) view.findViewById(R.id.jfo);
                    view.setTag(textView);
                }
                textView.setText((String) item);
            }
            view2 = view;
        }
        EventCollector.getInstance().onListGetView(i3, view2, viewGroup, getItemId(i3));
        return view;
    }
}
