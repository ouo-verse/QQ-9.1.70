package com.tencent.sqshow.zootopia.nativeui.data;

import android.app.Activity;
import android.os.CountDownTimer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.sqshow.zootopia.nativeui.data.sort.PanelSortData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelCategoryData;
import com.tencent.sqshow.zootopia.nativeui.data.title.PortalStorePanelSectionData;
import com.tencent.sqshow.zootopia.nativeui.ue.aa;
import com.tencent.sqshow.zootopia.nativeui.ue.ab;
import com.tencent.sqshow.zootopia.nativeui.ue.s;
import com.tencent.sqshow.zootopia.nativeui.ue.t;
import com.tencent.sqshow.zootopia.nativeui.view.common.AvatarGlobalLoadingView;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import m94.DressHistoryChangeInfo;
import org.json.JSONObject;
import uv4.az;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b2\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0006\b\u00e1\u0001\u0010\u00e2\u0001J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001f\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R#\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0(8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00103\u001a\b\u0012\u0004\u0012\u0002000(8\u0006\u00a2\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u0010.R\u001d\u00107\u001a\b\u0012\u0004\u0012\u0002040(8\u0006\u00a2\u0006\f\n\u0004\b5\u0010,\u001a\u0004\b6\u0010.R$\u0010>\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b!\u0010;\"\u0004\b<\u0010=R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020?0(8\u0006\u00a2\u0006\f\n\u0004\b@\u0010,\u001a\u0004\bA\u0010.R$\u0010I\u001a\u0004\u0018\u00010C8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\b+\u0010F\"\u0004\bG\u0010HR\"\u0010O\u001a\u00020J8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010K\u001a\u0004\b\u0019\u0010L\"\u0004\bM\u0010NR$\u0010V\u001a\u0004\u0018\u00010P8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010R\u001a\u0004\b\u000b\u0010S\"\u0004\bT\u0010UR\"\u0010]\u001a\u00020W8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R*\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010^0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010,\u001a\u0004\b9\u0010.\"\u0004\b_\u0010`R*\u0010d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010b0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010,\u001a\u0004\b@\u0010.\"\u0004\bc\u0010`R*\u0010g\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010e0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010,\u001a\u0004\b5\u0010.\"\u0004\bf\u0010`R*\u0010j\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010h0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010,\u001a\u0004\bD\u0010.\"\u0004\bi\u0010`R0\u0010n\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020h\u0018\u00010)0(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010,\u001a\u0004\bl\u0010.\"\u0004\bm\u0010`R2\u0010w\u001a\u0012\u0012\u0004\u0012\u00020p0oj\b\u0012\u0004\u0012\u00020p`q8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR+\u0010|\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020y\u0012\u0006\u0012\u0004\u0018\u00010z0x0(8\u0006\u00a2\u0006\f\n\u0004\b{\u0010,\u001a\u0004\b\u0011\u0010.R\u001a\u0010\u0082\u0001\u001a\u00020}8\u0006\u00a2\u0006\u000e\n\u0004\b~\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001c\u0010\u0087\u0001\u001a\u00030\u0083\u00018\u0006\u00a2\u0006\u000f\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0005\b1\u0010\u0086\u0001R\u001c\u0010\u008c\u0001\u001a\u00030\u0088\u00018\u0006\u00a2\u0006\u000f\n\u0005\b#\u0010\u0089\u0001\u001a\u0006\b\u008a\u0001\u0010\u008b\u0001R)\u0010\u0093\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001d\u0010\u0099\u0001\u001a\u00030\u0094\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0095\u0001\u0010\u0096\u0001\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R(\u0010\u009c\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bY\u0010\u008e\u0001\u001a\u0006\b\u009a\u0001\u0010\u0090\u0001\"\u0006\b\u009b\u0001\u0010\u0092\u0001R(\u0010\u00a2\u0001\u001a\u00030\u009d\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bl\u0010\u009e\u0001\u001a\u0005\bk\u0010\u009f\u0001\"\u0006\b\u00a0\u0001\u0010\u00a1\u0001R)\u0010\u00a7\u0001\u001a\u00030\u00a3\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0097\u0001\u0010%\u001a\u0006\b\u0084\u0001\u0010\u00a4\u0001\"\u0006\b\u00a5\u0001\u0010\u00a6\u0001R*\u0010\u00ae\u0001\u001a\u00030\u00a8\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a9\u0001\u0010\u00aa\u0001\u001a\u0006\b\u008d\u0001\u0010\u00ab\u0001\"\u0006\b\u00ac\u0001\u0010\u00ad\u0001R*\u0010\u00b5\u0001\u001a\u00030\u00af\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001\u001a\u0006\b\u0095\u0001\u0010\u00b2\u0001\"\u0006\b\u00b3\u0001\u0010\u00b4\u0001R+\u0010\u00bb\u0001\u001a\u0005\u0018\u00010\u00b6\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u008f\u0001\u0010\u00b7\u0001\u001a\u0005\b{\u0010\u00b8\u0001\"\u0006\b\u00b9\u0001\u0010\u00ba\u0001R)\u0010\u00bd\u0001\u001a\u0012\u0012\u0004\u0012\u00020*0oj\b\u0012\u0004\u0012\u00020*`q8\u0006\u00a2\u0006\r\n\u0005\b\u00bc\u0001\u0010r\u001a\u0004\b\u0005\u0010tR,\u0010\u00c3\u0001\u001a\u0005\u0018\u00010\u00be\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0080\u0001\u0010\u00bf\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00c0\u0001\"\u0006\b\u00c1\u0001\u0010\u00c2\u0001R+\u0010\u00c9\u0001\u001a\u0005\u0018\u00010\u00c4\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bs\u0010\u00c5\u0001\u001a\u0006\b\u00b0\u0001\u0010\u00c6\u0001\"\u0006\b\u00c7\u0001\u0010\u00c8\u0001R!\u0010\u00ca\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a3\u00010(8\u0006\u00a2\u0006\u000e\n\u0005\b\u008a\u0001\u0010,\u001a\u0005\b\u00bc\u0001\u0010.R+\u0010\u00d1\u0001\u001a\u0005\u0018\u00010\u00cb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u00cc\u0001\u0010\u00cd\u0001\u001a\u0005\b~\u0010\u00ce\u0001\"\u0006\b\u00cf\u0001\u0010\u00d0\u0001R'\u0010\u00d6\u0001\u001a\u00020y8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u00d2\u0001\u0010s\u001a\u0005\bQ\u0010\u00d3\u0001\"\u0006\b\u00d4\u0001\u0010\u00d5\u0001R)\u0010\u00d9\u0001\u001a\u00020*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u009a\u0001\u0010\u008e\u0001\u001a\u0006\b\u00d7\u0001\u0010\u0090\u0001\"\u0006\b\u00d8\u0001\u0010\u0092\u0001R*\u0010\u00de\u0001\u001a\u0010\u0012\u0005\u0012\u00030\u00db\u0001\u0012\u0004\u0012\u00020^0\u00da\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00d7\u0001\u0010\u00dc\u0001\u001a\u0006\b\u00cc\u0001\u0010\u00dd\u0001R9\u0010\u00e0\u0001\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0005\u0012\u00030\u00db\u0001\u0012\u0004\u0012\u00020^0\u00da\u00010(8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u0003\u0010,\u001a\u0005\b\u00d2\u0001\u0010.\"\u0005\b\u00df\u0001\u0010`\u00a8\u0006\u00e3\u0001"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/j;", "", "Lb94/e;", "O", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "a", "Lcom/tencent/qqnt/avatar/meta/refresh/c;", "getWeakPanelView", "()Lcom/tencent/qqnt/avatar/meta/refresh/c;", "weakPanelView", "Lga4/f;", "b", "Lga4/f;", "p", "()Lga4/f;", "dialogController", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/i;", "c", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/i;", DomainData.DOMAIN_NAME, "()Lcom/tencent/sqshow/zootopia/nativeui/data/repo/i;", "T", "(Lcom/tencent/sqshow/zootopia/nativeui/data/repo/i;)V", "dataController", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "d", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "o", "()Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;", "U", "(Lcom/tencent/sqshow/zootopia/nativeui/data/repo/p;)V", "dataControllerV1", "Landroidx/lifecycle/LifecycleOwner;", "e", "Landroidx/lifecycle/LifecycleOwner;", HippyTKDListViewAdapter.X, "()Landroidx/lifecycle/LifecycleOwner;", "Z", "(Landroidx/lifecycle/LifecycleOwner;)V", "lifecycleOwner", "Landroidx/lifecycle/MutableLiveData;", "", "", "f", "Landroidx/lifecycle/MutableLiveData;", "l", "()Landroidx/lifecycle/MutableLiveData;", "currentDressIdList", "Lm94/g;", "g", "r", "dressHistoryData", "Lm94/f;", tl.h.F, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "dressHistoryChangeInfo", "Lb94/d;", "i", "Lb94/d;", "()Lb94/d;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "(Lb94/d;)V", "avatarDressController", "Ls94/c;", "j", "t", "faceHistoryData", "Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "k", "Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", "()Lcom/tencent/sqshow/zootopia/nativeui/ue/t;", BdhLogUtil.LogTag.Tag_Req, "(Lcom/tencent/sqshow/zootopia/nativeui/ue/t;)V", "avatarFaceController", "Lcom/tencent/sqshow/zootopia/nativeui/ue/s;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/s;", "()Lcom/tencent/sqshow/zootopia/nativeui/ue/s;", "setAvatarColorController", "(Lcom/tencent/sqshow/zootopia/nativeui/ue/s;)V", "avatarColorController", "Landroid/app/Activity;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", "()Landroid/app/Activity;", "P", "(Landroid/app/Activity;)V", "attachedActivity", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;", "c0", "(Lcom/tencent/sqshow/zootopia/nativeui/data/sort/b;)V", "panelSortData", "Luv4/az;", "setCurrentActiveItem", "(Landroidx/lifecycle/MutableLiveData;)V", "currentActiveItem", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelSectionData;", "setCurrentActiveSectionData", "currentActiveSectionData", "Lcom/tencent/sqshow/zootopia/nativeui/data/title/PortalStorePanelCategoryData;", "setCurrentActiveCategoryData", "currentActiveCategoryData", "Luv4/bk;", "setCurrentClickedItem", "currentClickedItem", ReportConstant.COSTREPORT_PREFIX, "B", "setRecommendItemList", "recommendItemList", "Ljava/util/HashSet;", "Landroid/os/CountDownTimer;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "I", "()Ljava/util/HashSet;", "setTimerPool", "(Ljava/util/HashSet;)V", "timerPool", "Lkotlin/Pair;", "", "Lorg/json/JSONObject;", "u", "autoTrigger", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "v", "Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "H", "()Lcom/tencent/sqshow/zootopia/nativeui/data/l;", "storeItemPool", "Lcom/tencent/sqshow/zootopia/nativeui/ue/e;", "w", "Lcom/tencent/sqshow/zootopia/nativeui/ue/e;", "()Lcom/tencent/sqshow/zootopia/nativeui/ue/e;", "cameraController", "Lcom/tencent/sqshow/zootopia/nativeui/ue/ab;", "Lcom/tencent/sqshow/zootopia/nativeui/ue/ab;", "J", "()Lcom/tencent/sqshow/zootopia/nativeui/ue/ab;", "ueStatusController", "y", "Ljava/lang/String;", UserInfo.SEX_FEMALE, "()Ljava/lang/String;", "f0", "(Ljava/lang/String;)V", "schemeParams", "Ly94/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Ly94/a;", BdhLogUtil.LogTag.Tag_Conn, "()Ly94/a;", "reporter", "M", "g0", "zplanFaceId", "Lb94/a;", "Lb94/a;", "()Lb94/a;", "V", "(Lb94/a;)V", "engineApi", "", "()Z", "Y", "(Z)V", "inMakeFace", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;", "D", "Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;", "a0", "(Lcom/tencent/sqshow/zootopia/nativeui/data/AvatarNativeViewMode;)V", "nativeViewMode", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "E", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "()Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "b0", "(Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;)V", "orientationMode", "Lqu4/j;", "Lqu4/j;", "()Lqu4/j;", "W", "(Lqu4/j;)V", "faceInfoWhenEnterMakeFace", "G", "aiMakeFaceItemPool", "La84/a;", "La84/a;", "()La84/a;", "d0", "(La84/a;)V", "sceneComponentAvatar", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "()Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;", "e0", "(Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/a;)V", "sceneComponentAvatarV2", "showThirdTitleView", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "K", "Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "()Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;", "X", "(Lcom/tencent/sqshow/zootopia/nativeui/view/common/AvatarGlobalLoadingView;)V", "fullScreenLoadingView", "L", "()I", ExifInterface.LATITUDE_SOUTH, "(I)V", "currentSelectedTypePos", "N", "h0", "zplanPageOpenSource", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/concurrent/ConcurrentHashMap;", "()Ljava/util/concurrent/ConcurrentHashMap;", "watchAdStoreItem", "setWatchAdStoreItemLiveData", "watchAdStoreItemLiveData", "<init>", "(Lcom/tencent/qqnt/avatar/meta/refresh/c;Lga4/f;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class j {

    /* renamed from: A, reason: from kotlin metadata */
    private String zplanFaceId;

    /* renamed from: B, reason: from kotlin metadata */
    private b94.a engineApi;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean inMakeFace;

    /* renamed from: D, reason: from kotlin metadata */
    private AvatarNativeViewMode nativeViewMode;

    /* renamed from: E, reason: from kotlin metadata */
    private OrientationMode orientationMode;

    /* renamed from: F, reason: from kotlin metadata */
    private qu4.j faceInfoWhenEnterMakeFace;

    /* renamed from: G, reason: from kotlin metadata */
    private final HashSet<String> aiMakeFaceItemPool;

    /* renamed from: H, reason: from kotlin metadata */
    private a84.a sceneComponentAvatar;

    /* renamed from: I, reason: from kotlin metadata */
    private com.tencent.sqshow.zootopia.recommend.characterV2.component.a sceneComponentAvatarV2;

    /* renamed from: J, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> showThirdTitleView;

    /* renamed from: K, reason: from kotlin metadata */
    private AvatarGlobalLoadingView fullScreenLoadingView;

    /* renamed from: L, reason: from kotlin metadata */
    private int currentSelectedTypePos;

    /* renamed from: M, reason: from kotlin metadata */
    private String zplanPageOpenSource;

    /* renamed from: N, reason: from kotlin metadata */
    private final ConcurrentHashMap<Long, az> watchAdStoreItem;

    /* renamed from: O, reason: from kotlin metadata */
    private MutableLiveData<ConcurrentHashMap<Long, az>> watchAdStoreItemLiveData;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.qqnt.avatar.meta.refresh.c<b94.e> weakPanelView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ga4.f dialogController;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.repo.i dataController;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.nativeui.data.repo.p dataControllerV1;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<String>> currentDressIdList;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<m94.g> dressHistoryData;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<DressHistoryChangeInfo> dressHistoryChangeInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private b94.d avatarDressController;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<s94.c> faceHistoryData;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private t avatarFaceController;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private s avatarColorController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Activity attachedActivity;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private PanelSortData panelSortData;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<az> currentActiveItem;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<PortalStorePanelSectionData> currentActiveSectionData;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<PortalStorePanelCategoryData> currentActiveCategoryData;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<bk> currentClickedItem;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private MutableLiveData<List<bk>> recommendItemList;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private HashSet<CountDownTimer> timerPool;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Pair<Integer, JSONObject>> autoTrigger;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final l storeItemPool;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.nativeui.ue.e cameraController;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private final ab ueStatusController;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private String schemeParams;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private final y94.a reporter;

    public j(com.tencent.qqnt.avatar.meta.refresh.c<b94.e> cVar, ga4.f dialogController) {
        Intrinsics.checkNotNullParameter(dialogController, "dialogController");
        this.weakPanelView = cVar;
        this.dialogController = dialogController;
        this.currentDressIdList = new MutableLiveData<>();
        this.dressHistoryData = new MutableLiveData<>();
        this.dressHistoryChangeInfo = new MutableLiveData<>();
        this.faceHistoryData = new MutableLiveData<>();
        this.avatarColorController = new com.tencent.sqshow.zootopia.nativeui.ue.g();
        this.panelSortData = new PanelSortData(null, null, null, 7, null);
        this.currentActiveItem = new MutableLiveData<>();
        this.currentActiveSectionData = new MutableLiveData<>();
        this.currentActiveCategoryData = new MutableLiveData<>();
        this.currentClickedItem = new MutableLiveData<>();
        this.recommendItemList = new MutableLiveData<>();
        this.timerPool = new HashSet<>();
        this.autoTrigger = new MutableLiveData<>();
        this.storeItemPool = c.f370920a.y();
        this.cameraController = new com.tencent.sqshow.zootopia.nativeui.ue.e(null, 1, 0 == true ? 1 : 0);
        this.ueStatusController = new ab();
        this.schemeParams = "";
        this.reporter = new y94.a();
        this.zplanFaceId = "";
        this.engineApi = aa.f371327d;
        this.nativeViewMode = AvatarNativeViewMode.NORMAL;
        this.orientationMode = OrientationMode.UNSPECIFIED;
        this.aiMakeFaceItemPool = new HashSet<>();
        this.showThirdTitleView = new MutableLiveData<>();
        this.zplanPageOpenSource = "";
        this.watchAdStoreItem = new ConcurrentHashMap<>();
        this.watchAdStoreItemLiveData = new MutableLiveData<>(new ConcurrentHashMap());
    }

    /* renamed from: A, reason: from getter */
    public final PanelSortData getPanelSortData() {
        return this.panelSortData;
    }

    public final MutableLiveData<List<bk>> B() {
        return this.recommendItemList;
    }

    /* renamed from: C, reason: from getter */
    public final y94.a getReporter() {
        return this.reporter;
    }

    /* renamed from: D, reason: from getter */
    public final a84.a getSceneComponentAvatar() {
        return this.sceneComponentAvatar;
    }

    /* renamed from: E, reason: from getter */
    public final com.tencent.sqshow.zootopia.recommend.characterV2.component.a getSceneComponentAvatarV2() {
        return this.sceneComponentAvatarV2;
    }

    /* renamed from: F, reason: from getter */
    public final String getSchemeParams() {
        return this.schemeParams;
    }

    public final MutableLiveData<Boolean> G() {
        return this.showThirdTitleView;
    }

    /* renamed from: H, reason: from getter */
    public final l getStoreItemPool() {
        return this.storeItemPool;
    }

    public final HashSet<CountDownTimer> I() {
        return this.timerPool;
    }

    /* renamed from: J, reason: from getter */
    public final ab getUeStatusController() {
        return this.ueStatusController;
    }

    public final ConcurrentHashMap<Long, az> K() {
        return this.watchAdStoreItem;
    }

    public final MutableLiveData<ConcurrentHashMap<Long, az>> L() {
        return this.watchAdStoreItemLiveData;
    }

    /* renamed from: M, reason: from getter */
    public final String getZplanFaceId() {
        return this.zplanFaceId;
    }

    /* renamed from: N, reason: from getter */
    public final String getZplanPageOpenSource() {
        return this.zplanPageOpenSource;
    }

    public final b94.e O() {
        com.tencent.qqnt.avatar.meta.refresh.c<b94.e> cVar = this.weakPanelView;
        if (cVar != null) {
            return cVar.get();
        }
        return null;
    }

    public final void P(Activity activity) {
        this.attachedActivity = activity;
    }

    public final void Q(b94.d dVar) {
        this.avatarDressController = dVar;
    }

    public final void R(t tVar) {
        this.avatarFaceController = tVar;
    }

    public final void S(int i3) {
        this.currentSelectedTypePos = i3;
    }

    public final void T(com.tencent.sqshow.zootopia.nativeui.data.repo.i iVar) {
        this.dataController = iVar;
    }

    public final void U(com.tencent.sqshow.zootopia.nativeui.data.repo.p pVar) {
        this.dataControllerV1 = pVar;
    }

    public final void V(b94.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.engineApi = aVar;
    }

    public final void W(qu4.j jVar) {
        this.faceInfoWhenEnterMakeFace = jVar;
    }

    public final void X(AvatarGlobalLoadingView avatarGlobalLoadingView) {
        this.fullScreenLoadingView = avatarGlobalLoadingView;
    }

    public final void Y(boolean z16) {
        this.inMakeFace = z16;
    }

    public final void Z(LifecycleOwner lifecycleOwner) {
        this.lifecycleOwner = lifecycleOwner;
    }

    public final HashSet<String> a() {
        return this.aiMakeFaceItemPool;
    }

    public final void a0(AvatarNativeViewMode avatarNativeViewMode) {
        Intrinsics.checkNotNullParameter(avatarNativeViewMode, "<set-?>");
        this.nativeViewMode = avatarNativeViewMode;
    }

    /* renamed from: b, reason: from getter */
    public final Activity getAttachedActivity() {
        return this.attachedActivity;
    }

    public final void b0(OrientationMode orientationMode) {
        Intrinsics.checkNotNullParameter(orientationMode, "<set-?>");
        this.orientationMode = orientationMode;
    }

    public final MutableLiveData<Pair<Integer, JSONObject>> c() {
        return this.autoTrigger;
    }

    public final void c0(PanelSortData panelSortData) {
        Intrinsics.checkNotNullParameter(panelSortData, "<set-?>");
        this.panelSortData = panelSortData;
    }

    /* renamed from: d, reason: from getter */
    public final s getAvatarColorController() {
        return this.avatarColorController;
    }

    public final void d0(a84.a aVar) {
        this.sceneComponentAvatar = aVar;
    }

    /* renamed from: e, reason: from getter */
    public final b94.d getAvatarDressController() {
        return this.avatarDressController;
    }

    public final void e0(com.tencent.sqshow.zootopia.recommend.characterV2.component.a aVar) {
        this.sceneComponentAvatarV2 = aVar;
    }

    /* renamed from: f, reason: from getter */
    public final t getAvatarFaceController() {
        return this.avatarFaceController;
    }

    public final void f0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.schemeParams = str;
    }

    /* renamed from: g, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.ue.e getCameraController() {
        return this.cameraController;
    }

    public final void g0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zplanFaceId = str;
    }

    public final MutableLiveData<PortalStorePanelCategoryData> h() {
        return this.currentActiveCategoryData;
    }

    public final void h0(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.zplanPageOpenSource = str;
    }

    public final MutableLiveData<az> i() {
        return this.currentActiveItem;
    }

    public final MutableLiveData<PortalStorePanelSectionData> j() {
        return this.currentActiveSectionData;
    }

    public final MutableLiveData<bk> k() {
        return this.currentClickedItem;
    }

    public final MutableLiveData<List<String>> l() {
        return this.currentDressIdList;
    }

    /* renamed from: m, reason: from getter */
    public final int getCurrentSelectedTypePos() {
        return this.currentSelectedTypePos;
    }

    /* renamed from: n, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.repo.i getDataController() {
        return this.dataController;
    }

    /* renamed from: o, reason: from getter */
    public final com.tencent.sqshow.zootopia.nativeui.data.repo.p getDataControllerV1() {
        return this.dataControllerV1;
    }

    /* renamed from: p, reason: from getter */
    public final ga4.f getDialogController() {
        return this.dialogController;
    }

    public final MutableLiveData<DressHistoryChangeInfo> q() {
        return this.dressHistoryChangeInfo;
    }

    public final MutableLiveData<m94.g> r() {
        return this.dressHistoryData;
    }

    /* renamed from: s, reason: from getter */
    public final b94.a getEngineApi() {
        return this.engineApi;
    }

    public final MutableLiveData<s94.c> t() {
        return this.faceHistoryData;
    }

    /* renamed from: u, reason: from getter */
    public final qu4.j getFaceInfoWhenEnterMakeFace() {
        return this.faceInfoWhenEnterMakeFace;
    }

    /* renamed from: v, reason: from getter */
    public final AvatarGlobalLoadingView getFullScreenLoadingView() {
        return this.fullScreenLoadingView;
    }

    /* renamed from: w, reason: from getter */
    public final boolean getInMakeFace() {
        return this.inMakeFace;
    }

    /* renamed from: x, reason: from getter */
    public final LifecycleOwner getLifecycleOwner() {
        return this.lifecycleOwner;
    }

    /* renamed from: y, reason: from getter */
    public final AvatarNativeViewMode getNativeViewMode() {
        return this.nativeViewMode;
    }

    /* renamed from: z, reason: from getter */
    public final OrientationMode getOrientationMode() {
        return this.orientationMode;
    }
}
