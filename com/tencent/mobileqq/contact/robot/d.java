package com.tencent.mobileqq.contact.robot;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.adapter.k;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contact.robot.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.ProfileSimpleInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 <2\u00020\u0001:\u0005=>?@AB3\u0012\u0006\u0010 \u001a\u00020\u001d\u0012\b\u00104\u001a\u0004\u0018\u000103\u0012\b\u00106\u001a\u0004\u0018\u000105\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u00109\u001a\u00020\u0015\u00a2\u0006\u0004\b:\u0010;J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0014\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\bH\u0016J\"\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\bH\u0016J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\bH\u0017J\u001a\u0010\u0019\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0014R\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR(\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0#0!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/d;", "Lcom/tencent/mobileqq/adapter/e;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "list", "", "j", "i", "", "getCount", "position", "", "getItem", "", "getItemId", "Landroid/view/View;", "convertView", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "getView", "getDividerLayout", "", "isDividerView", "view", "configDividerView", "needHideDivider", "Lcom/tencent/mobileqq/adapter/k;", "holder", "f", "Lcom/tencent/mobileqq/contact/robot/d$e;", "D", "Lcom/tencent/mobileqq/contact/robot/d$e;", "clickListener", "Ljava/util/LinkedHashMap;", "", "", "Lcom/tencent/mobileqq/contact/robot/d$d;", "E", "Ljava/util/LinkedHashMap;", "indexedFriends", "", UserInfo.SEX_FEMALE, "[I", "groupItemCount", "", "G", "[Ljava/lang/String;", "indexes", "H", "Z", "isConstruct", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/widget/XListView;", "attachedListView", "preloadFace", "<init>", "(Lcom/tencent/mobileqq/contact/robot/d$e;Landroid/content/Context;Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/widget/XListView;Z)V", "I", "a", "b", "c", "d", "e", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d extends com.tencent.mobileqq.adapter.e {

    /* renamed from: D, reason: from kotlin metadata */
    private final e clickListener;

    /* renamed from: E, reason: from kotlin metadata */
    private LinkedHashMap<String, List<C7478d>> indexedFriends;

    /* renamed from: F, reason: from kotlin metadata */
    private int[] groupItemCount;

    /* renamed from: G, reason: from kotlin metadata */
    private String[] indexes;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean isConstruct;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/d$b;", "Lcom/tencent/mobileqq/adapter/k;", "Landroid/widget/LinearLayout;", "i", "Landroid/widget/LinearLayout;", "a", "()Landroid/widget/LinearLayout;", "setLlItem", "(Landroid/widget/LinearLayout;)V", "llItem", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "c", "()Landroid/widget/TextView;", "setTvName", "(Landroid/widget/TextView;)V", "tvName", BdhLogUtil.LogTag.Tag_Conn, "b", "setTvIndex", "tvIndex", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    private static final class b extends k {

        /* renamed from: C, reason: from kotlin metadata */
        private TextView tvIndex;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        private LinearLayout llItem;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private TextView tvName;

        public b(View itemView) {
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f187213h = (QQProAvatarView) itemView.findViewById(R.id.f17620s);
            this.llItem = (LinearLayout) itemView.findViewById(R.id.f177717);
            this.tvName = (TextView) itemView.findViewById(R.id.f18262i);
            this.tvIndex = (TextView) itemView.findViewById(R.id.f18252h);
        }

        /* renamed from: a, reason: from getter */
        public final LinearLayout getLlItem() {
            return this.llItem;
        }

        /* renamed from: b, reason: from getter */
        public final TextView getTvIndex() {
            return this.tvIndex;
        }

        /* renamed from: c, reason: from getter */
        public final TextView getTvName() {
            return this.tvName;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/d$c;", "Ljava/util/Comparator;", "", "o1", "o2", "", "a", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class c implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String o16, String o26) {
            Intrinsics.checkNotNullParameter(o16, "o1");
            Intrinsics.checkNotNullParameter(o26, "o2");
            if (Intrinsics.areEqual(o16, o26)) {
                return 0;
            }
            if (Intrinsics.areEqual(o16, "#")) {
                return 1;
            }
            if (Intrinsics.areEqual(o26, "#")) {
                return -1;
            }
            return o16.compareTo(o26);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/d$d;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "c", "()Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "robotCoreInfo", "", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "name", "pinyinFirst", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.contact.robot.d$d, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    public static final class C7478d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final RobotCoreInfo robotCoreInfo;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final String name;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final String pinyinFirst;

        public C7478d() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* renamed from: a, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* renamed from: b, reason: from getter */
        public final String getPinyinFirst() {
            return this.pinyinFirst;
        }

        /* renamed from: c, reason: from getter */
        public final RobotCoreInfo getRobotCoreInfo() {
            return this.robotCoreInfo;
        }

        public C7478d(RobotCoreInfo robotCoreInfo) {
            ProfileSimpleInfo profileSimpleInfo;
            String nick;
            this.robotCoreInfo = robotCoreInfo;
            String name = robotCoreInfo != null ? robotCoreInfo.getName() : null;
            if (name == null || name.length() == 0) {
                if (robotCoreInfo != null && (profileSimpleInfo = robotCoreInfo.baseSimpleProfile) != null) {
                    nick = profileSimpleInfo.getNick();
                }
                nick = null;
            } else {
                if (robotCoreInfo != null) {
                    nick = robotCoreInfo.getName();
                }
                nick = null;
            }
            nick = nick == null ? "" : nick;
            this.name = nick;
            String d16 = robotCoreInfo != null ? ChnToSpell.d(nick, 2) : null;
            this.pinyinFirst = d16 != null ? d16 : "";
        }

        public /* synthetic */ C7478d(RobotCoreInfo robotCoreInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : robotCoreInfo);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/contact/robot/d$e;", "", "", "uin", "", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface e {
        void a(String uin);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes33.dex */
    public static final class f<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(((C7478d) t16).getName(), ((C7478d) t17).getName());
            return compareValues;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e clickListener, Context context, QQAppInterface qQAppInterface, XListView attachedListView, boolean z16) {
        super(context, qQAppInterface, attachedListView, z16);
        Intrinsics.checkNotNullParameter(clickListener, "clickListener");
        Intrinsics.checkNotNullParameter(attachedListView, "attachedListView");
        this.clickListener = clickListener;
        this.indexedFriends = new LinkedHashMap<>();
        this.groupItemCount = new int[0];
        this.indexes = new String[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(C7478d c7478d, d this$0, View view) {
        RobotCoreInfo robotCoreInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (c7478d == null || (robotCoreInfo = c7478d.getRobotCoreInfo()) == null) {
            return;
        }
        this$0.clickListener.a(String.valueOf(robotCoreInfo.robotUin));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        if (r2 != 0) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void j(List<RobotCoreInfo> list) {
        int i3;
        String substring;
        this.indexedFriends.clear();
        TreeMap treeMap = new TreeMap(new c());
        Iterator<RobotCoreInfo> it = list.iterator();
        while (true) {
            i3 = 0;
            if (!it.hasNext()) {
                break;
            }
            C7478d c7478d = new C7478d(it.next());
            String str = "#";
            if (c7478d.getPinyinFirst().length() == 0) {
                substring = "#";
            } else {
                substring = c7478d.getPinyinFirst().substring(0, 1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            }
            char charAt = substring.charAt(0);
            if (!('A' <= charAt && charAt < '[')) {
                if ('a' <= charAt && charAt < '{') {
                    i3 = 1;
                }
            }
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            str = substring.toUpperCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toUpperCase(locale)");
            if (treeMap.get(str) == null) {
                treeMap.put(str, new ArrayList());
            }
            List list2 = (List) treeMap.get(str);
            if (list2 != null) {
                list2.add(c7478d);
            }
        }
        for (Object obj : treeMap.keySet()) {
            Intrinsics.checkNotNullExpressionValue(obj, "iterator.next()");
            String str2 = (String) obj;
            List<C7478d> list3 = (List) treeMap.get(str2);
            if (list3 != null) {
                if (list3.size() > 1) {
                    CollectionsKt__MutableCollectionsJVMKt.sortWith(list3, new f());
                }
                this.indexedFriends.put(str2, list3);
            }
        }
        int[] iArr = new int[this.indexedFriends.keySet().size()];
        this.groupItemCount = iArr;
        this.indexes = new String[iArr.length];
        if (iArr.length == 0) {
            return;
        }
        Iterator<String> it5 = this.indexedFriends.keySet().iterator();
        int[] iArr2 = this.groupItemCount;
        iArr2[0] = 0;
        int length = iArr2.length;
        for (int i16 = 1; i16 < length; i16++) {
            List<C7478d> list4 = this.indexedFriends.get(it5.next());
            if (list4 != null) {
                int size = list4.size();
                int[] iArr3 = this.groupItemCount;
                iArr3[i16] = iArr3[i16] + iArr3[i16 - 1] + size + 1;
            }
        }
        Iterator<String> it6 = this.indexedFriends.keySet().iterator();
        while (it6.hasNext()) {
            this.indexes[i3] = it6.next();
            i3++;
        }
        this.isConstruct = true;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public void configDividerView(View view, int position) {
        int binarySearch = Arrays.binarySearch(this.groupItemCount, position);
        if (binarySearch < 0) {
            binarySearch = (-(binarySearch + 1)) - 1;
        }
        String[] strArr = this.indexes;
        if (binarySearch >= strArr.length || binarySearch < 0 || !(view instanceof TextView)) {
            return;
        }
        TextView textView = (TextView) view;
        textView.setText(strArr[binarySearch]);
        textView.setBackground(textView.getResources().getDrawable(R.drawable.qui_common_fill_light_primary_bg, null));
        ColorStateList colorStateList = textView.getResources().getColorStateList(R.color.qui_common_text_secondary);
        Intrinsics.checkNotNullExpressionValue(colorStateList, "view.getResources().getC\u2026t_secondary\n            )");
        textView.setTextColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.adapter.e
    public boolean f(k holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        return false;
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public int getCount() {
        if ((this.groupItemCount.length == 0) || !this.isConstruct) {
            return 0;
        }
        LinkedHashMap<String, List<C7478d>> linkedHashMap = this.indexedFriends;
        String[] strArr = this.indexes;
        List<C7478d> list = linkedHashMap.get(strArr[strArr.length - 1]);
        if (list == null) {
            return 0;
        }
        int[] iArr = this.groupItemCount;
        return iArr[iArr.length - 1] + list.size() + 1;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public int getDividerLayout() {
        return R.layout.fg8;
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public Object getItem(int position) {
        int binarySearch = Arrays.binarySearch(this.groupItemCount, position);
        if (binarySearch >= 0) {
            return null;
        }
        List<C7478d> list = this.indexedFriends.get(this.indexes[(-(binarySearch + 1)) - 1]);
        if (list != null) {
            return list.get((position - this.groupItemCount[r0]) - 1);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public long getItemId(int position) {
        return 0L;
    }

    @Override // com.tencent.mobileqq.adapter.e, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        b bVar;
        RobotCoreInfo robotCoreInfo;
        Intrinsics.checkNotNullParameter(parent, "parent");
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.f127290_, parent, false);
            Intrinsics.checkNotNullExpressionValue(convertView, "from(parent.context)\n   \u2026tact_item, parent, false)");
            bVar = new b(convertView);
            convertView.setTag(bVar);
        } else {
            Object tag = convertView.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.contact.robot.RobotContactListViewAdapter.ContactHolder");
            bVar = (b) tag;
        }
        int binarySearch = Arrays.binarySearch(this.groupItemCount, position);
        if (binarySearch < 0) {
            int i3 = (-(binarySearch + 1)) - 1;
            List<C7478d> list = this.indexedFriends.get(this.indexes[i3]);
            final C7478d c7478d = list != null ? list.get((position - this.groupItemCount[i3]) - 1) : null;
            LinearLayout llItem = bVar.getLlItem();
            if (llItem != null) {
                llItem.setVisibility(0);
                llItem.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.contact.robot.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        d.h(d.C7478d.this, this, view);
                    }
                });
            }
            TextView tvIndex = bVar.getTvIndex();
            if (tvIndex != null) {
                tvIndex.setVisibility(8);
            }
            QQProAvatarView qQProAvatarView = bVar.f187213h;
            if (qQProAvatarView != null) {
                qQProAvatarView.w(1, (c7478d == null || (robotCoreInfo = c7478d.getRobotCoreInfo()) == null) ? null : Long.valueOf(robotCoreInfo.robotUin).toString());
            }
            TextView tvName = bVar.getTvName();
            if (tvName != null) {
                tvName.setText(c7478d != null ? c7478d.getName() : null);
            }
        } else {
            LinearLayout llItem2 = bVar.getLlItem();
            if (llItem2 != null) {
                llItem2.setVisibility(8);
            }
            TextView tvIndex2 = bVar.getTvIndex();
            if (tvIndex2 != null) {
                tvIndex2.setVisibility(0);
            }
            TextView tvIndex3 = bVar.getTvIndex();
            if (tvIndex3 != null) {
                tvIndex3.setText(String.valueOf(this.indexes[binarySearch]));
            }
            AccessibilityUtil.s(bVar.getTvIndex(), this.indexes[binarySearch] + " \u5206\u7ec4");
            ViewCompat.setAccessibilityHeading(bVar.getTvIndex(), true);
        }
        return convertView;
    }

    public final void i(List<RobotCoreInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        QLog.i("RobotContactListViewAdapter", 1, "notifyDataSetChanged size :" + list.size());
        j(list);
        notifyDataSetChanged();
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean isDividerView(int position) {
        return Arrays.binarySearch(this.groupItemCount, position) >= 0;
    }

    @Override // com.tencent.mobileqq.widget.PinnedDividerListView.a
    public boolean needHideDivider(View view, int position) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return (ThemeUtil.isNowThemeDefaultCache || ThemeUtil.isNowThemeIsNight(peekAppRuntime, false, null) || ThemeUtil.isNowThemeIsSimple(peekAppRuntime, false, null)) ? false : true;
    }
}
