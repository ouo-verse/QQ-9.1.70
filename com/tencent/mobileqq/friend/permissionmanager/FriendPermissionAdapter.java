package com.tencent.mobileqq.friend.permissionmanager;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter;
import com.tencent.mobileqq.adapter.j;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.group.GroupListFriend;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.api.IFriendsInfoService;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.d;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes33.dex */
public class FriendPermissionAdapter extends j implements View.OnClickListener {
    private final Context F;
    private final QQAppInterface G;
    private final HashSet<String> H;
    private final ConcurrentHashMap<String, Integer> I;
    private final List<d> J;
    private final c K;
    private final IFriendHandlerService L;
    private boolean M;
    com.tencent.mobileqq.friend.observer.a N;

    /* loaded from: classes33.dex */
    public static class b extends k {
        public ImageView C;
        public ImageView D;
        public CheckBox E;

        /* renamed from: i, reason: collision with root package name */
        public TextView f211697i;

        /* renamed from: m, reason: collision with root package name */
        public ImageView f211698m;
    }

    /* loaded from: classes33.dex */
    interface c {
        void a();
    }

    public FriendPermissionAdapter(Context context, QQAppInterface qQAppInterface, XListView xListView, int i3, c cVar, IFriendHandlerService iFriendHandlerService) {
        super(context, qQAppInterface, xListView, 1, true);
        this.H = new HashSet<>();
        this.I = new ConcurrentHashMap<>();
        this.J = new ArrayList();
        this.M = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106085", true);
        this.N = new a();
        this.G = qQAppInterface;
        this.F = context;
        this.K = cVar;
        xListView.setAdapter((ListAdapter) this);
        qQAppInterface.addObserver(this.N);
        this.L = iFriendHandlerService;
        s(i3);
    }

    private int r(int i3) {
        List<d> list = this.J;
        if (list != null && i3 < list.size() && this.I != null) {
            Integer num = this.I.get(this.J.get(i3).x());
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    private void s(final int i3) {
        ((IFriendsInfoService) QRoute.api(IFriendsInfoService.class)).getCategoryInfoWithCategoryId(i3, "FriendPermissionAdapter", new hx3.b<com.tencent.qqnt.ntrelation.friendsinfo.bean.b>() { // from class: com.tencent.mobileqq.friend.permissionmanager.FriendPermissionAdapter.2
            @Override // hx3.b
            public void onQueryResult(e<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> eVar) {
                ArrayList<com.tencent.qqnt.ntrelation.friendsinfo.bean.b> b16;
                if (eVar.a() != 0 || (b16 = eVar.b()) == null || b16.size() == 0) {
                    return;
                }
                ArrayList<String> c16 = b16.get(0).c();
                ArrayList<com.tencent.mobileqq.activity.contacts.base.c> arrayList = new ArrayList(c16.size());
                if (i3 == 1004) {
                    Iterator<String> it = c16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.tencent.mobileqq.activity.contacts.base.b.a(4, FriendPermissionAdapter.this.F, it.next()));
                    }
                } else {
                    Iterator<String> it5 = c16.iterator();
                    while (it5.hasNext()) {
                        arrayList.add(com.tencent.mobileqq.activity.contacts.base.b.a(0, FriendPermissionAdapter.this.F, it5.next()));
                    }
                }
                FriendPermissionAdapter.this.u(arrayList);
                ArrayList arrayList2 = new ArrayList();
                for (com.tencent.mobileqq.activity.contacts.base.c cVar : arrayList) {
                    if (!(cVar instanceof GroupListFriend)) {
                        return;
                    }
                    d x16 = ((GroupListFriend) cVar).x();
                    String x17 = x16.x();
                    if (!FriendPermissionAdapter.this.t(x17)) {
                        arrayList2.add(x17);
                        FriendPermissionAdapter.this.J.add(x16);
                        FriendPermissionAdapter.this.I.put(x17, -1);
                        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.friend.permissionmanager.FriendPermissionAdapter.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                FriendPermissionAdapter.this.notifyDataSetChanged();
                            }
                        });
                        if (QLog.isColorLevel()) {
                            QLog.d("FriendPermissionAdapter", 2, "mShelfInitPermissionSwitch = " + FriendPermissionAdapter.this.M);
                        }
                        if (FriendPermissionAdapter.this.M) {
                            if (QLog.isColorLevel()) {
                                QLog.d("FriendPermissionAdapter", 2, "shelf getPermissionSelectFriend");
                            }
                        } else {
                            FriendPermissionAdapter.this.L.getPermissionSelectFriend(arrayList2, 0, arrayList2.size());
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t(String str) {
        return TextUtils.isEmpty(str) || Utils.G(str) || Utils.I(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(List<com.tencent.mobileqq.activity.contacts.base.c> list) {
        try {
            Collections.sort(list, BuddyListAdapter.Z);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FriendPermissionAdapter", 2, "", e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.adapter.j
    public void destroy() {
        super.destroy();
        this.G.removeObserver(this.N);
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public int getCount() {
        return this.J.size();
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() instanceof b) {
            b bVar = (b) view.getTag();
            String str = bVar.f187210d;
            boolean isChecked = bVar.E.isChecked();
            if (!isChecked && this.H.size() >= 9) {
                QQToastUtil.showQQToast(-1, R.string.f225516lu);
                return;
            }
            bVar.E.setChecked(!isChecked);
            if (!isChecked) {
                this.H.add(str);
            } else {
                this.H.remove(str);
            }
            this.K.a();
        }
    }

    public ConcurrentHashMap<String, Integer> p() {
        return this.I;
    }

    public HashSet<String> q() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public d getItem(int i3) {
        if (i3 < 0 || i3 >= this.J.size()) {
            return null;
        }
        return this.J.get(i3);
    }

    /* loaded from: classes33.dex */
    class a extends com.tencent.mobileqq.friend.observer.a {
        a() {
        }

        @Override // com.tencent.mobileqq.friend.observer.a
        protected void onUpdateFetchFriendPermission(boolean z16, HashMap<String, Integer> hashMap) {
            if (z16 && hashMap != null && hashMap.size() != 0) {
                for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
                    FriendPermissionAdapter.this.I.put(entry.getKey(), entry.getValue());
                }
                FriendPermissionAdapter.this.notifyDataSetChanged();
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("FriendPermissionAdapter", 2, "onUpdateFetchFriendPermission | get friend permission is fail!");
            }
        }
    }

    @Override // com.tencent.mobileqq.adapter.j, android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        String r16;
        if (view == null) {
            b bVar2 = new b();
            View inflate = LayoutInflater.from(this.F).inflate(R.layout.f167804e41, (ViewGroup) null);
            bVar2.f187212f = (ImageView) inflate.findViewById(R.id.f163821d);
            bVar2.f211697i = (TextView) inflate.findViewById(R.id.f97);
            bVar2.E = (CheckBox) inflate.findViewById(R.id.axa);
            bVar2.f211698m = (ImageView) inflate.findViewById(R.id.vfi);
            bVar2.D = (ImageView) inflate.findViewById(R.id.f68883h9);
            bVar2.C = (ImageView) inflate.findViewById(R.id.f68933hd);
            ImageView imageView = bVar2.f187212f;
            if (imageView instanceof ThemeImageView) {
                ((ThemeImageView) imageView).setSupportMaskView(false);
            }
            inflate.setTag(bVar2);
            bVar = bVar2;
            view = inflate;
        } else {
            bVar = (b) view.getTag();
        }
        d item = getItem(i3);
        if (item == null) {
            view.setVisibility(8);
        } else {
            if (TextUtils.isEmpty(item.r())) {
                r16 = item.p();
            } else {
                r16 = item.r();
            }
            bVar.f211697i.setText(r16);
            bVar.f211697i.setVisibility(TextUtils.isEmpty(r16) ? 8 : 0);
            bVar.f187210d = item.x();
            bVar.E.setChecked(this.H.contains(item.x()));
            bVar.f187212f.setImageBitmap(c(1, bVar.f187210d));
            w(view);
            view.setOnClickListener(this);
            v(bVar, r(i3));
            view.setVisibility(0);
        }
        return view;
    }

    private void v(b bVar, int i3) {
        if (i3 < 0) {
            bVar.f211698m.setVisibility(8);
            bVar.D.setVisibility(8);
            bVar.C.setVisibility(8);
            return;
        }
        boolean z16 = (i3 & 1) == 1;
        boolean z17 = ((i3 >> 1) & 1) == 1;
        boolean z18 = ((i3 >> 2) & 1) == 1;
        if (z16) {
            bVar.f211698m.setVisibility(0);
            bVar.D.setVisibility(8);
            bVar.C.setVisibility(8);
        } else {
            bVar.f211698m.setVisibility(8);
            bVar.D.setVisibility(z17 ? 0 : 8);
            bVar.C.setVisibility(z18 ? 0 : 8);
        }
    }

    public static void w(View view) {
        if (view == null || view.findViewById(R.id.icx) == null) {
            return;
        }
        view.findViewById(R.id.icx).setBackgroundResource(ThemeUtil.isDefaultTheme() ? R.drawable.f160540jm : R.drawable.common_list_item_background);
    }
}
