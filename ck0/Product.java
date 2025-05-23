package ck0;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.repo.live.ActivityType;
import com.tencent.ecommerce.repo.live.ECShopExt;
import com.tencent.ecommerce.repo.live.LiveActivity;
import com.tencent.ecommerce.repo.live.LiveShowItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.pts.core.PTSComposer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b)\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 <2\u00020\u0001:\u0001\tB\u00e7\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010#\u001a\u00020\u001c\u0012\b\b\u0002\u0010'\u001a\u00020\u001c\u0012\b\b\u0002\u0010*\u001a\u00020\u001c\u0012\b\b\u0002\u0010-\u001a\u00020\u001c\u0012\b\b\u0002\u00105\u001a\u00020.\u0012\b\b\u0002\u00109\u001a\u00020\u001c\u0012\b\b\u0002\u0010=\u001a\u00020\u001c\u0012\b\b\u0002\u0010@\u001a\u00020\u001c\u0012\b\b\u0002\u0010B\u001a\u00020\u001c\u0012\b\b\u0002\u0010E\u001a\u00020\u001c\u0012\b\b\u0002\u0010H\u001a\u00020\u001c\u0012\b\b\u0002\u0010L\u001a\u00020\u0007\u0012\b\b\u0002\u0010O\u001a\u00020\u0007\u0012\b\b\u0002\u0010Q\u001a\u00020\u0007\u0012\b\b\u0002\u0010W\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010X\u0012\u0010\b\u0002\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010X\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010j\u001a\u00020\u0003\u0012\b\b\u0002\u0010n\u001a\u00020\u0003\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010o\u0012\b\b\u0002\u0010x\u001a\u00020\u0003\u0012\b\b\u0002\u0010{\u001a\u00020\u0003\u0012\b\b\u0002\u0010}\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u0082\u0001\u001a\u00020\u0005\u0012\f\b\u0002\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0083\u0001\u0012\t\b\u0002\u0010\u008b\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u008e\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u0092\u0001\u001a\u00020\u0005\u0012\t\b\u0002\u0010\u0094\u0001\u001a\u00020\u0007\u0012\t\b\u0002\u0010\u0096\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u0098\u0001\u001a\u00020o\u0012\f\b\u0002\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0099\u0001\u0012\t\b\u0002\u0010\u00a0\u0001\u001a\u00020\u0005\u0012\t\b\u0002\u0010\u00a1\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u00a3\u0001\u001a\u00020\u0003\u0012\t\b\u0002\u0010\u00a7\u0001\u001a\u00020o\u0012\u0010\b\u0002\u0010\u00aa\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a8\u00010X\u00a2\u0006\u0006\b\u00ab\u0001\u0010\u00ac\u0001J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010#\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010'\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010\u001e\u001a\u0004\b%\u0010 \"\u0004\b&\u0010\"R\"\u0010*\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\u001e\u001a\u0004\b\u001d\u0010 \"\u0004\b)\u0010\"R\"\u0010-\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001e\u001a\u0004\b\u0010\u0010 \"\u0004\b,\u0010\"R\"\u00105\u001a\u00020.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u00109\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\u001e\u001a\u0004\b7\u0010 \"\u0004\b8\u0010\"R\"\u0010=\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\u001e\u001a\u0004\b;\u0010 \"\u0004\b<\u0010\"R\"\u0010@\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u001e\u001a\u0004\b\u0014\u0010 \"\u0004\b?\u0010\"R\"\u0010B\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010\u001e\u001a\u0004\b\u0018\u0010 \"\u0004\b\u001e\u0010\"R\"\u0010E\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010\u001e\u001a\u0004\bA\u0010 \"\u0004\bD\u0010\"R\"\u0010H\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u001e\u001a\u0004\bF\u0010 \"\u0004\bG\u0010\"R\"\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010\n\u001a\u0004\bJ\u0010\f\"\u0004\bK\u0010\u000eR\"\u0010O\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\n\u001a\u0004\bM\u0010\f\"\u0004\bN\u0010\u000eR\"\u0010Q\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010\n\u001a\u0004\b(\u0010\f\"\u0004\bP\u0010\u000eR\"\u0010W\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR*\u0010_\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010X8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R*\u0010b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010X8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010Z\u001a\u0004\b`\u0010\\\"\u0004\ba\u0010^R$\u0010h\u001a\u0004\u0018\u00010c8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010d\u001a\u0004\bY\u0010e\"\u0004\bf\u0010gR\"\u0010j\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010R\u001a\u0004\b+\u0010T\"\u0004\bi\u0010VR\"\u0010n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010R\u001a\u0004\bl\u0010T\"\u0004\bm\u0010VR$\u0010t\u001a\u0004\u0018\u00010o8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010p\u001a\u0004\b$\u0010q\"\u0004\br\u0010sR\"\u0010x\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010R\u001a\u0004\bv\u0010T\"\u0004\bw\u0010VR\"\u0010{\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010R\u001a\u0004\bu\u0010T\"\u0004\bz\u0010VR\"\u0010}\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010R\u001a\u0004\b0\u0010T\"\u0004\b|\u0010VR%\u0010\u0082\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b~\u0010?\u001a\u0004\by\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R*\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0005\b0\u0010\u0084\u0001\u001a\u0005\b\t\u0010\u0085\u0001\"\u0006\b\u0086\u0001\u0010\u0087\u0001R%\u0010\u008b\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0004\bv\u0010R\u001a\u0005\b\u0089\u0001\u0010T\"\u0005\b\u008a\u0001\u0010VR&\u0010\u008e\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0015\n\u0005\b\u0086\u0001\u0010R\u001a\u0005\b\u008c\u0001\u0010T\"\u0005\b\u008d\u0001\u0010VR$\u0010\u0090\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0013\n\u0004\ba\u0010R\u001a\u0004\b:\u0010T\"\u0005\b\u008f\u0001\u0010VR%\u0010\u0092\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b,\u0010?\u001a\u0004\b6\u0010\u007f\"\u0006\b\u0091\u0001\u0010\u0081\u0001R$\u0010\u0094\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b?\u0010\n\u001a\u0004\bI\u0010\f\"\u0005\b\u0093\u0001\u0010\u000eR$\u0010\u0096\u0001\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0013\n\u0004\b\u001e\u0010R\u001a\u0004\bk\u0010T\"\u0005\b\u0095\u0001\u0010VR$\u0010\u0098\u0001\u001a\u00020o8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0013\n\u0004\bi\u0010p\u001a\u0004\b/\u0010q\"\u0005\b\u0097\u0001\u0010sR*\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0099\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0016\n\u0005\b|\u0010\u009a\u0001\u001a\u0005\bC\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R&\u0010\u00a0\u0001\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0015\n\u0005\b\u0091\u0001\u0010?\u001a\u0004\b~\u0010\u007f\"\u0006\b\u009f\u0001\u0010\u0081\u0001R&\u0010\u00a1\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008f\u0001\u0010R\u001a\u0005\b\u00a1\u0001\u0010T\"\u0005\b\u00a2\u0001\u0010VR&\u0010\u00a3\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u009c\u0001\u0010R\u001a\u0005\b\u00a3\u0001\u0010T\"\u0005\b\u00a4\u0001\u0010VR%\u0010\u00a7\u0001\u001a\u00020o8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0014\n\u0004\b!\u0010p\u001a\u0005\b\u00a5\u0001\u0010q\"\u0005\b\u00a6\u0001\u0010sR+\u0010\u00aa\u0001\u001a\t\u0012\u0005\u0012\u00030\u00a8\u00010X8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0013\n\u0004\b8\u0010Z\u001a\u0004\b>\u0010\\\"\u0005\b\u00a9\u0001\u0010^\u00a8\u0006\u00ad\u0001"}, d2 = {"Lck0/c;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "setMediaProductId", "(Ljava/lang/String;)V", "mediaProductId", "b", "u", "T", "saasProductId", "c", "B", "Y", "title", "d", "getDesc", "setDesc", "desc", "", "e", "J", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()J", "P", "(J)V", "price", "f", "getOriginPrice", "setOriginPrice", "originPrice", "g", "setCouponPrice", "couponPrice", h.F, "H", "commission", "", "i", "D", "getCommissionRate", "()D", "setCommissionRate", "(D)V", "commissionRate", "j", "r", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "priceLower", "k", ReportConstant.COSTREPORT_PREFIX, BdhLogUtil.LogTag.Tag_Req, "priceUpper", "l", "I", "commissionLower", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "commissonUpper", DomainData.DOMAIN_NAME, "setInventory", "inventory", "w", "U", "sales", "p", "v", "setSaasTypeStr", "saasTypeStr", "getSaasTypeName", "setSaasTypeName", "saasTypeName", "setDetailUrl", "detailUrl", "Z", "getInWindow", "()Z", "setInWindow", "(Z)V", "inWindow", "", "t", "Ljava/util/List;", "getLabelInfo", "()Ljava/util/List;", "setLabelInfo", "(Ljava/util/List;)V", "labelInfo", "getCdnMainPics", "G", "cdnMainPics", "Lcom/tencent/pts/core/PTSComposer;", "Lcom/tencent/pts/core/PTSComposer;", "()Lcom/tencent/pts/core/PTSComposer;", ExifInterface.LATITUDE_SOUTH, "(Lcom/tencent/pts/core/PTSComposer;)V", "ptsComposer", "K", "editable", HippyTKDListViewAdapter.X, "y", "W", "selected", "Lorg/json/JSONObject;", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "setDataJson", "(Lorg/json/JSONObject;)V", "dataJson", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "E", "setMaster", "isMaster", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "X", "showAddBtn", "L", "isEdited", BdhLogUtil.LogTag.Tag_Conn, "()I", "setState", "(I)V", "state", "Lck0/b;", "Lck0/b;", "()Lck0/b;", UserInfo.SEX_FEMALE, "(Lck0/b;)V", "category", "getHasExposed", "setHasExposed", "hasExposed", "getHasPreload", "setHasPreload", "hasPreload", "N", "hasExposedAndPreload", "M", "goodsType", "setPageName", "pageName", "V", "selectStatusFromBackend", "setExt", "ext", "Lcom/tencent/ecommerce/repo/live/i;", "Lcom/tencent/ecommerce/repo/live/i;", "()Lcom/tencent/ecommerce/repo/live/i;", "O", "(Lcom/tencent/ecommerce/repo/live/i;)V", "liveShopExt", "setViewType", "viewType", "isPriceExceed", "setPriceExceed", "isUnSupportAdd", "setUnSupportAdd", "getShopInfo", "setShopInfo", "shopInfo", "Lck0/a;", "setHeaderBannerInfo", "headerBannerInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJDJJJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;Ljava/util/List;Lcom/tencent/pts/core/PTSComposer;ZZLorg/json/JSONObject;ZZZILck0/b;ZZZILjava/lang/String;ZLorg/json/JSONObject;Lcom/tencent/ecommerce/repo/live/i;IZZLorg/json/JSONObject;Ljava/util/List;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: ck0.c, reason: from toString */
/* loaded from: classes39.dex */
public final /* data */ class Product {

    /* renamed from: R, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private boolean showAddBtn;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    private boolean isEdited;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private int state;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private Category category;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private boolean hasExposed;

    /* renamed from: F, reason: from kotlin metadata and from toString */
    private boolean hasPreload;

    /* renamed from: G, reason: from kotlin metadata and from toString */
    private boolean hasExposedAndPreload;

    /* renamed from: H, reason: from kotlin metadata and from toString */
    private int goodsType;

    /* renamed from: I, reason: from kotlin metadata and from toString */
    private String pageName;

    /* renamed from: J, reason: from kotlin metadata and from toString */
    private boolean selectStatusFromBackend;

    /* renamed from: K, reason: from kotlin metadata and from toString */
    private JSONObject ext;

    /* renamed from: L, reason: from kotlin metadata and from toString */
    private ECShopExt liveShopExt;

    /* renamed from: M, reason: from kotlin metadata and from toString */
    private int viewType;

    /* renamed from: N, reason: from kotlin metadata and from toString */
    private boolean isPriceExceed;

    /* renamed from: O, reason: from kotlin metadata and from toString */
    private boolean isUnSupportAdd;

    /* renamed from: P, reason: from kotlin metadata and from toString */
    private JSONObject shopInfo;

    /* renamed from: Q, reason: from kotlin metadata and from toString */
    private List<a> headerBannerInfo;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String mediaProductId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasProductId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String title;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String desc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private long price;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private long originPrice;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private long couponPrice;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private long commission;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private double commissionRate;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private long priceLower;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private long priceUpper;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private long commissionLower;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private long commissonUpper;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private long inventory;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private long sales;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasTypeStr;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasTypeName;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private String detailUrl;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean inWindow;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private List<Object> labelInfo;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private List<String> cdnMainPics;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private PTSComposer ptsComposer;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean editable;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean selected;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    private JSONObject dataJson;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isMaster;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0005*\u00020\u0002J\f\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0002R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000bR\u0014\u0010\u0011\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000bR\u0014\u0010\u0013\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0014\u0010\u0014\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000bR\u0014\u0010\u0015\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0014\u0010\u0016\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000bR\u0014\u0010\u0017\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u000bR\u0014\u0010\u0019\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lck0/c$a;", "", "Lck0/c;", "Lorg/json/JSONObject;", "a", "", "c", "Lcom/tencent/ecommerce/repo/live/r;", "b", "", "ACTIVITY_TYPE_FLASH_SALE", "I", "ACTIVITY_TYPE_UNKNOWN", "GOODS_TYPE_Q_SHOP", "GOODS_TYPE_SAAS", "GOODS_TYPE_SGAME", "GOODS_TYPE_TX_VIDEO", "GOODS_TYPE_UNKNOWN", "GOOD_TYPE_SAAS_JD", "GOOD_TYPE_SAAS_PDD", "GOOD_TYPE_TAOBAOLINK", "GOOD_TYPE_TXCOURSE", "PRODUCT_ARCHIVED", "PRODUCT_STATE_OFF", "PRODUCT_STATE_ON", "PRODUCT_STATE_UNSPECIFIC", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: ck0.c$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        Companion() {
        }

        public final JSONObject a(Product product) {
            LiveActivity liveActivity;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("goods_type", product.getGoodsType());
            jSONObject.put("media_product_id", product.getMediaProductId());
            ECShopExt liveShopExt = product.getLiveShopExt();
            String str = null;
            jSONObject.put("shop_id", liveShopExt != null ? liveShopExt.shopId : null);
            ECShopExt liveShopExt2 = product.getLiveShopExt();
            jSONObject.put("sku_id", liveShopExt2 != null ? liveShopExt2.skuId : null);
            ECShopExt liveShopExt3 = product.getLiveShopExt();
            if (liveShopExt3 != null && (liveActivity = liveShopExt3.activity) != null) {
                str = liveActivity.getActivityId();
            }
            jSONObject.put("activity_id", str);
            return jSONObject;
        }

        public final LiveShowItem b(Product product) {
            LiveShowItem liveShowItem;
            ECShopExt liveShopExt = product.getLiveShopExt();
            if (liveShopExt == null || (liveShowItem = liveShopExt.liveShowItem) == null) {
                ECShopExt liveShopExt2 = product.getLiveShopExt();
                liveShowItem = liveShopExt2 != null ? liveShopExt2.couponShowItem : null;
            }
            if (liveShowItem != null) {
                return liveShowItem;
            }
            ECShopExt liveShopExt3 = product.getLiveShopExt();
            if (liveShopExt3 != null) {
                return liveShopExt3.getNormalShowItem();
            }
            return null;
        }

        public final boolean c(Product product) {
            LiveActivity liveActivity;
            String activityId;
            LiveActivity liveActivity2;
            ECShopExt liveShopExt = product.getLiveShopExt();
            if (liveShopExt == null || (liveActivity = liveShopExt.activity) == null || (activityId = liveActivity.getActivityId()) == null) {
                return false;
            }
            if (!(activityId.length() > 0)) {
                return false;
            }
            ECShopExt liveShopExt2 = product.getLiveShopExt();
            return ((liveShopExt2 == null || (liveActivity2 = liveShopExt2.activity) == null) ? null : liveActivity2.getActivityType()) == ActivityType.ACTIVITY_TYPE_LIVE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Product() {
        this(null, null, null, null, 0L, 0L, 0L, 0L, 0.0d, 0L, 0L, 0L, 0L, 0L, 0L, null, null, null, false, null, null, null, false, false, null, false, false, false, 0, null, false, false, false, 0, null, false, null, null, 0, false, false, null, null, -1, 2047, null);
    }

    /* renamed from: A, reason: from getter */
    public final int getState() {
        return this.state;
    }

    /* renamed from: B, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: C, reason: from getter */
    public final int getViewType() {
        return this.viewType;
    }

    /* renamed from: D, reason: from getter */
    public final boolean getIsEdited() {
        return this.isEdited;
    }

    /* renamed from: E, reason: from getter */
    public final boolean getIsMaster() {
        return this.isMaster;
    }

    public final void F(Category category) {
        this.category = category;
    }

    public final void G(List<String> list) {
        this.cdnMainPics = list;
    }

    public final void H(long j3) {
        this.commission = j3;
    }

    public final void I(long j3) {
        this.commissionLower = j3;
    }

    public final void J(long j3) {
        this.commissonUpper = j3;
    }

    public final void K(boolean z16) {
        this.editable = z16;
    }

    public final void L(boolean z16) {
        this.isEdited = z16;
    }

    public final void M(int i3) {
        this.goodsType = i3;
    }

    public final void N(boolean z16) {
        this.hasExposedAndPreload = z16;
    }

    public final void O(ECShopExt eCShopExt) {
        this.liveShopExt = eCShopExt;
    }

    public final void P(long j3) {
        this.price = j3;
    }

    public final void Q(long j3) {
        this.priceLower = j3;
    }

    public final void R(long j3) {
        this.priceUpper = j3;
    }

    public final void S(PTSComposer pTSComposer) {
        this.ptsComposer = pTSComposer;
    }

    public final void T(String str) {
        this.saasProductId = str;
    }

    public final void U(long j3) {
        this.sales = j3;
    }

    public final void V(boolean z16) {
        this.selectStatusFromBackend = z16;
    }

    public final void W(boolean z16) {
        this.selected = z16;
    }

    public final void X(boolean z16) {
        this.showAddBtn = z16;
    }

    public final void Y(String str) {
        this.title = str;
    }

    /* renamed from: a, reason: from getter */
    public final Category getCategory() {
        return this.category;
    }

    /* renamed from: b, reason: from getter */
    public final long getCommission() {
        return this.commission;
    }

    /* renamed from: c, reason: from getter */
    public final long getCommissionLower() {
        return this.commissionLower;
    }

    /* renamed from: d, reason: from getter */
    public final long getCommissonUpper() {
        return this.commissonUpper;
    }

    /* renamed from: e, reason: from getter */
    public final long getCouponPrice() {
        return this.couponPrice;
    }

    /* renamed from: f, reason: from getter */
    public final JSONObject getDataJson() {
        return this.dataJson;
    }

    /* renamed from: g, reason: from getter */
    public final String getDetailUrl() {
        return this.detailUrl;
    }

    /* renamed from: h, reason: from getter */
    public final boolean getEditable() {
        return this.editable;
    }

    public int hashCode() {
        int hashCode = ((this.mediaProductId.hashCode() * 31) + this.goodsType) * 31;
        ECShopExt eCShopExt = this.liveShopExt;
        return hashCode + (eCShopExt != null ? eCShopExt.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final JSONObject getExt() {
        return this.ext;
    }

    /* renamed from: j, reason: from getter */
    public final int getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: k, reason: from getter */
    public final boolean getHasExposedAndPreload() {
        return this.hasExposedAndPreload;
    }

    public final List<a> l() {
        return this.headerBannerInfo;
    }

    /* renamed from: m, reason: from getter */
    public final long getInventory() {
        return this.inventory;
    }

    /* renamed from: n, reason: from getter */
    public final ECShopExt getLiveShopExt() {
        return this.liveShopExt;
    }

    /* renamed from: o, reason: from getter */
    public final String getMediaProductId() {
        return this.mediaProductId;
    }

    /* renamed from: p, reason: from getter */
    public final String getPageName() {
        return this.pageName;
    }

    /* renamed from: q, reason: from getter */
    public final long getPrice() {
        return this.price;
    }

    /* renamed from: r, reason: from getter */
    public final long getPriceLower() {
        return this.priceLower;
    }

    /* renamed from: s, reason: from getter */
    public final long getPriceUpper() {
        return this.priceUpper;
    }

    /* renamed from: t, reason: from getter */
    public final PTSComposer getPtsComposer() {
        return this.ptsComposer;
    }

    public String toString() {
        return "Product(mediaProductId=" + this.mediaProductId + ", saasProductId=" + this.saasProductId + ", title=" + this.title + ", desc=" + this.desc + ", price=" + this.price + ", originPrice=" + this.originPrice + ", couponPrice=" + this.couponPrice + ", commission=" + this.commission + ", commissionRate=" + this.commissionRate + ", priceLower=" + this.priceLower + ", priceUpper=" + this.priceUpper + ", commissionLower=" + this.commissionLower + ", commissonUpper=" + this.commissonUpper + ", inventory=" + this.inventory + ", sales=" + this.sales + ", saasTypeStr=" + this.saasTypeStr + ", saasTypeName=" + this.saasTypeName + ", detailUrl=" + this.detailUrl + ", inWindow=" + this.inWindow + ", labelInfo=" + this.labelInfo + ", cdnMainPics=" + this.cdnMainPics + ", ptsComposer=" + this.ptsComposer + ", editable=" + this.editable + ", selected=" + this.selected + ", dataJson=" + this.dataJson + ", isMaster=" + this.isMaster + ", showAddBtn=" + this.showAddBtn + ", isEdited=" + this.isEdited + ", state=" + this.state + ", category=" + this.category + ", hasExposed=" + this.hasExposed + ", hasPreload=" + this.hasPreload + ", hasExposedAndPreload=" + this.hasExposedAndPreload + ", goodsType=" + this.goodsType + ", pageName=" + this.pageName + ", selectStatusFromBackend=" + this.selectStatusFromBackend + ", ext=" + this.ext + ", liveShopExt=" + this.liveShopExt + ", viewType=" + this.viewType + ", isPriceExceed=" + this.isPriceExceed + ", isUnSupportAdd=" + this.isUnSupportAdd + ", shopInfo=" + this.shopInfo + ", headerBannerInfo=" + this.headerBannerInfo + ")";
    }

    /* renamed from: u, reason: from getter */
    public final String getSaasProductId() {
        return this.saasProductId;
    }

    /* renamed from: v, reason: from getter */
    public final String getSaasTypeStr() {
        return this.saasTypeStr;
    }

    /* renamed from: w, reason: from getter */
    public final long getSales() {
        return this.sales;
    }

    /* renamed from: x, reason: from getter */
    public final boolean getSelectStatusFromBackend() {
        return this.selectStatusFromBackend;
    }

    /* renamed from: y, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* renamed from: z, reason: from getter */
    public final boolean getShowAddBtn() {
        return this.showAddBtn;
    }

    public Product(String str, String str2, String str3, String str4, long j3, long j16, long j17, long j18, double d16, long j19, long j26, long j27, long j28, long j29, long j36, String str5, String str6, String str7, boolean z16, List<Object> list, List<String> list2, PTSComposer pTSComposer, boolean z17, boolean z18, JSONObject jSONObject, boolean z19, boolean z26, boolean z27, int i3, Category category, boolean z28, boolean z29, boolean z36, int i16, String str8, boolean z37, JSONObject jSONObject2, ECShopExt eCShopExt, int i17, boolean z38, boolean z39, JSONObject jSONObject3, List<a> list3) {
        this.mediaProductId = str;
        this.saasProductId = str2;
        this.title = str3;
        this.desc = str4;
        this.price = j3;
        this.originPrice = j16;
        this.couponPrice = j17;
        this.commission = j18;
        this.commissionRate = d16;
        this.priceLower = j19;
        this.priceUpper = j26;
        this.commissionLower = j27;
        this.commissonUpper = j28;
        this.inventory = j29;
        this.sales = j36;
        this.saasTypeStr = str5;
        this.saasTypeName = str6;
        this.detailUrl = str7;
        this.inWindow = z16;
        this.labelInfo = list;
        this.cdnMainPics = list2;
        this.ptsComposer = pTSComposer;
        this.editable = z17;
        this.selected = z18;
        this.dataJson = jSONObject;
        this.isMaster = z19;
        this.showAddBtn = z26;
        this.isEdited = z27;
        this.state = i3;
        this.category = category;
        this.hasExposed = z28;
        this.hasPreload = z29;
        this.hasExposedAndPreload = z36;
        this.goodsType = i16;
        this.pageName = str8;
        this.selectStatusFromBackend = z37;
        this.ext = jSONObject2;
        this.liveShopExt = eCShopExt;
        this.viewType = i17;
        this.isPriceExceed = z38;
        this.isUnSupportAdd = z39;
        this.shopInfo = jSONObject3;
        this.headerBannerInfo = list3;
    }

    public /* synthetic */ Product(String str, String str2, String str3, String str4, long j3, long j16, long j17, long j18, double d16, long j19, long j26, long j27, long j28, long j29, long j36, String str5, String str6, String str7, boolean z16, List list, List list2, PTSComposer pTSComposer, boolean z17, boolean z18, JSONObject jSONObject, boolean z19, boolean z26, boolean z27, int i3, Category category, boolean z28, boolean z29, boolean z36, int i16, String str8, boolean z37, JSONObject jSONObject2, ECShopExt eCShopExt, int i17, boolean z38, boolean z39, JSONObject jSONObject3, List list3, int i18, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? "" : str, (i18 & 2) != 0 ? "" : str2, (i18 & 4) != 0 ? "" : str3, (i18 & 8) != 0 ? "" : str4, (i18 & 16) != 0 ? 0L : j3, (i18 & 32) != 0 ? 0L : j16, (i18 & 64) != 0 ? 0L : j17, (i18 & 128) != 0 ? 0L : j18, (i18 & 256) != 0 ? 0.0d : d16, (i18 & 512) != 0 ? 0L : j19, (i18 & 1024) != 0 ? 0L : j26, (i18 & 2048) != 0 ? 0L : j27, (i18 & 4096) != 0 ? 0L : j28, (i18 & 8192) != 0 ? 0L : j29, (i18 & 16384) == 0 ? j36 : 0L, (32768 & i18) != 0 ? "" : str5, (i18 & 65536) != 0 ? "" : str6, (i18 & 131072) != 0 ? "" : str7, (i18 & 262144) != 0 ? false : z16, (i18 & 524288) != 0 ? null : list, (i18 & 1048576) != 0 ? null : list2, (i18 & 2097152) != 0 ? null : pTSComposer, (i18 & 4194304) != 0 ? false : z17, (i18 & 8388608) != 0 ? false : z18, (i18 & 16777216) != 0 ? null : jSONObject, (i18 & 33554432) != 0 ? true : z19, (i18 & 67108864) != 0 ? false : z26, (i18 & 134217728) != 0 ? false : z27, (i18 & 268435456) != 0 ? 0 : i3, (i18 & 536870912) != 0 ? null : category, (i18 & 1073741824) != 0 ? false : z28, (i18 & Integer.MIN_VALUE) != 0 ? false : z29, (i19 & 1) != 0 ? false : z36, (i19 & 2) == 0 ? i16 : 1, (i19 & 4) == 0 ? str8 : "", (i19 & 8) != 0 ? false : z37, (i19 & 16) != 0 ? new JSONObject() : jSONObject2, (i19 & 32) == 0 ? eCShopExt : null, (i19 & 64) != 0 ? 0 : i17, (i19 & 128) != 0 ? false : z38, (i19 & 256) == 0 ? z39 : false, (i19 & 512) != 0 ? new JSONObject() : jSONObject3, (i19 & 1024) != 0 ? new ArrayList() : list3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Product.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            Product product = (Product) other;
            return ((Intrinsics.areEqual(this.mediaProductId, product.mediaProductId) ^ true) || this.goodsType != product.goodsType || (Intrinsics.areEqual(this.liveShopExt, product.liveShopExt) ^ true)) ? false : true;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.repo.showwindow.Product");
    }
}
