package com.tencent.av.ui.chatroom;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ChatRoomAdapter extends BaseAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final LayoutInflater f75458d;

    /* renamed from: e, reason: collision with root package name */
    private final Context f75459e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.tencent.av.ui.chatroom.b> f75460f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a extends AccessibilityDelegateCompat {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.av.ui.chatroom.b f75465e;

        a(com.tencent.av.ui.chatroom.b bVar) {
            this.f75465e = bVar;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            SessionInfo f16;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (this.f75465e.a() != null) {
                String b16 = this.f75465e.b();
                VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
                if (videoAppInterface != null && !TextUtils.isEmpty(b16)) {
                    if (b16.equals(videoAppInterface.getCurrentAccountUin())) {
                        str = "\u6211";
                    } else if (r.h0() != null && (f16 = n.e().f()) != null) {
                        str = r.h0().U(b16, String.valueOf(f16.P0), f16.S0);
                    }
                    String emoticonToTextForTalkBack = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.f75465e.a().toString());
                    accessibilityNodeInfoCompat.setText(emoticonToTextForTalkBack);
                    accessibilityNodeInfoCompat.setContentDescription(str + "\u53d1\u9001\u6d88\u606f " + emoticonToTextForTalkBack);
                }
                str = null;
                String emoticonToTextForTalkBack2 = com.tencent.mobileqq.text.TextUtils.emoticonToTextForTalkBack(this.f75465e.a().toString());
                accessibilityNodeInfoCompat.setText(emoticonToTextForTalkBack2);
                accessibilityNodeInfoCompat.setContentDescription(str + "\u53d1\u9001\u6d88\u606f " + emoticonToTextForTalkBack2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private View f75467a;

        /* renamed from: b, reason: collision with root package name */
        private TextView f75468b;

        b() {
        }
    }

    public ChatRoomAdapter(Context context) {
        this.f75459e = context;
        this.f75458d = LayoutInflater.from(context);
    }

    private View d(LayoutInflater layoutInflater, int i3, View view, ViewGroup viewGroup, int i16) {
        final b bVar;
        if (view == null) {
            view = layoutInflater.inflate(i16, viewGroup, false);
            if (view != null) {
                bVar = new b();
                bVar.f75467a = view.findViewById(R.id.head);
                bVar.f75468b = (TextView) view.findViewById(R.id.jfb);
                view.setTag(bVar);
            } else {
                bVar = null;
            }
        } else {
            bVar = (b) view.getTag();
        }
        com.tencent.av.ui.chatroom.b item = getItem(i3);
        final String b16 = item.b();
        if (bVar != null) {
            bVar.f75467a.setVisibility(0);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.chatroom.ChatRoomAdapter.1
                @Override // java.lang.Runnable
                public void run() {
                    final BitmapDrawable e16 = ChatRoomAdapter.this.e(b16);
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.av.ui.chatroom.ChatRoomAdapter.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b bVar2 = bVar;
                            if (bVar2 != null && bVar2.f75467a != null) {
                                bVar.f75467a.setBackgroundDrawable(e16);
                            }
                        }
                    });
                }
            }, 16, null, false);
            bVar.f75467a.setBackgroundDrawable(e(item.b()));
            bVar.f75468b.setPadding(BaseAIOUtils.f(10.0f, this.f75459e.getResources()), BaseAIOUtils.f(8.0f, this.f75459e.getResources()), BaseAIOUtils.f(10.0f, this.f75459e.getResources()), BaseAIOUtils.f(8.0f, this.f75459e.getResources()));
            bVar.f75468b.setText(item.a());
            bVar.f75468b.setTextColor(-1);
            bVar.f75468b.setSpannableFactory(QQText.SPANNABLE_FACTORY);
        }
        ViewCompat.setAccessibilityDelegate(view, new a(item));
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public BitmapDrawable e(String str) {
        SessionInfo f16 = n.e().f();
        int i3 = f16.f73035i;
        boolean z16 = true;
        if (i3 != 1 && i3 != 2) {
            z16 = false;
        }
        if (z16) {
            VideoAppInterface videoAppInterface = (VideoAppInterface) BaseApplicationImpl.getApplication().getRuntime();
            if (videoAppInterface != null) {
                return new BitmapDrawable(this.f75459e.getResources(), videoAppInterface.J(0, str, null, true, true));
            }
            return null;
        }
        return new BitmapDrawable(this.f75459e.getResources(), r.h0().S(String.valueOf(str), String.valueOf(f16.P0), f16.S0, true, true));
    }

    public void b(com.tencent.av.ui.chatroom.b bVar) {
        this.f75460f.add(bVar);
        notifyDataSetChanged();
    }

    public void c(List<com.tencent.av.ui.chatroom.b> list, boolean z16) {
        if (z16) {
            com.tencent.av.ui.chatroom.b.f(this.f75460f);
        }
        this.f75460f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public com.tencent.av.ui.chatroom.b getItem(int i3) {
        return this.f75460f.get(i3);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f75460f.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        View d16 = d(this.f75458d, i3, view, viewGroup, R.layout.a5q);
        EventCollector.getInstance().onListGetView(i3, view, viewGroup, getItemId(i3));
        return d16;
    }
}
