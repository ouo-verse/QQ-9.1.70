package com.tencent.biz.qqcircle.comment.at.dialog;

import android.content.Context;
import android.text.TextUtils;
import android.util.Size;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qcircleshadow.lib.variation.HostSelectMemberUtils;
import com.tencent.biz.qqcircle.comment.at.QFSCommentAtHelper;
import com.tencent.biz.qqcircle.comment.at.bean.QFSCommentAtEntity;
import com.tencent.biz.qqcircle.immersive.utils.n;
import com.tencent.biz.qqcircle.utils.cu;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends BaseExpandableListAdapter {
    private static final Size C = n.a(RFWApplication.getApplication(), R.dimen.d0e);

    /* renamed from: d, reason: collision with root package name */
    private final Context f83517d;

    /* renamed from: e, reason: collision with root package name */
    private List<Groups> f83518e;

    /* renamed from: f, reason: collision with root package name */
    private SparseArray<List<QFSCommentAtEntity>> f83519f;

    /* renamed from: h, reason: collision with root package name */
    private final List<HostSelectMemberUtils.QCircleResultData> f83520h;

    /* renamed from: i, reason: collision with root package name */
    private int f83521i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f83522m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f83523a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f83524b;

        /* renamed from: c, reason: collision with root package name */
        public QCircleAvatarView f83525c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f83526d;

        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f83527a;

        /* renamed from: b, reason: collision with root package name */
        public LinearLayout f83528b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f83529c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f83530d;

        b() {
        }
    }

    public d(Context context, List<HostSelectMemberUtils.QCircleResultData> list) {
        this(context, list, 0);
    }

    private String b(QFSCommentAtEntity qFSCommentAtEntity) {
        Friends friendFromMemoryCache;
        if (qFSCommentAtEntity == null) {
            return "";
        }
        if (this.f83522m && qFSCommentAtEntity.f() == 0 && (friendFromMemoryCache = ((IFriendDataService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFriendDataService.class, "")).getFriendFromMemoryCache(qFSCommentAtEntity.e())) != null && !TextUtils.isEmpty(friendFromMemoryCache.name) && !TextUtils.equals(friendFromMemoryCache.name, qFSCommentAtEntity.b())) {
            return friendFromMemoryCache.name + "(" + qFSCommentAtEntity.b() + ")";
        }
        return qFSCommentAtEntity.b();
    }

    private void e(View view) {
        float f16;
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        if (this.f83521i == 1) {
            f16 = 48.0f;
        } else {
            f16 = 56.0f;
        }
        int dip2px = DisplayUtil.dip2px(context, f16);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = dip2px;
        view.setLayoutParams(layoutParams);
    }

    public boolean a(QFSCommentAtEntity qFSCommentAtEntity, List<HostSelectMemberUtils.QCircleResultData> list) {
        Iterator<HostSelectMemberUtils.QCircleResultData> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().uin, qFSCommentAtEntity.uin)) {
                return true;
            }
        }
        return false;
    }

    public void c(List<Groups> list, SparseArray<List<QFSCommentAtEntity>> sparseArray) {
        this.f83518e = list;
        this.f83519f = sparseArray;
    }

    public void d(boolean z16) {
        this.f83522m = z16;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i3, int i16) {
        return this.f83519f.get(this.f83518e.get(i3).group_id).get(i16);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i3, int i16) {
        return cu.d(this.f83519f.get(this.f83518e.get(i3).group_id).get(i16).uin, -1L);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i3, int i16, boolean z16, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f83517d).inflate(R.layout.f168662g92, viewGroup, false);
            aVar = new a();
            aVar.f83524b = (ImageView) view.findViewById(R.id.y1d);
            aVar.f83525c = (QCircleAvatarView) view.findViewById(R.id.a2o);
            aVar.f83526d = (TextView) view.findViewById(R.id.tv_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f83523a = (int) getGroupId(i3);
        QFSCommentAtEntity qFSCommentAtEntity = (QFSCommentAtEntity) getChild(i3, i16);
        aVar.f83524b.setSelected(a(qFSCommentAtEntity, this.f83520h));
        aVar.f83525c.i();
        int i17 = this.f83521i;
        if (i17 != 1 && i17 != 2) {
            aVar.f83525c.setAvatar(qFSCommentAtEntity.g(), qFSCommentAtEntity.e(), C);
        } else {
            QFSCommentAtHelper.t0(qFSCommentAtEntity.e(), qFSCommentAtEntity.f(), aVar.f83525c);
        }
        aVar.f83526d.setText(b(qFSCommentAtEntity));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i3) {
        return this.f83519f.get(this.f83518e.get(i3).group_id).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i3) {
        return this.f83518e.get(i3);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f83518e.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i3) {
        return this.f83518e.get(i3).group_id;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i3, boolean z16, View view, ViewGroup viewGroup) {
        b bVar;
        int i16;
        float f16;
        if (view == null) {
            view = LayoutInflater.from(this.f83517d).inflate(R.layout.f168663g93, viewGroup, false);
            bVar = new b();
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.vus);
            bVar.f83528b = linearLayout;
            e(linearLayout);
            bVar.f83529c = (ImageView) view.findViewById(R.id.dtx);
            TextView textView = (TextView) view.findViewById(R.id.k8i);
            bVar.f83530d = textView;
            if (this.f83521i == 1) {
                f16 = 14.0f;
            } else {
                f16 = 16.0f;
            }
            textView.setTextSize(1, f16);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        Groups groups = (Groups) getGroup(i3);
        bVar.f83527a = groups.group_id;
        bVar.f83530d.setText(groups.group_name);
        ImageView imageView = bVar.f83529c;
        if (z16) {
            i16 = R.drawable.f162056oq1;
        } else {
            i16 = R.drawable.f162057oq2;
        }
        imageView.setImageResource(i16);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i3, int i16) {
        return true;
    }

    public d(Context context, List<HostSelectMemberUtils.QCircleResultData> list, int i3) {
        this.f83518e = new ArrayList();
        this.f83519f = new SparseArray<>();
        this.f83522m = false;
        this.f83517d = context;
        this.f83520h = list;
        this.f83521i = i3;
    }
}
