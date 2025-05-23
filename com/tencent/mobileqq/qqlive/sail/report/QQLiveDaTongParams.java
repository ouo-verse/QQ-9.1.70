package com.tencent.mobileqq.qqlive.sail.report;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTPublicParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapWithDefaultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0003\b\u00b4\u0001\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001\u0005B\u000b\b\u0016\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00ba\u0001B \b\u0016\u0012\u0013\u0010\b\u001a\u000f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00bb\u0001\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00bc\u0001J\"\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u0004R \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0007R+\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r*\u0004\b\u000e\u0010\u000fR+\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\r*\u0004\b\u0013\u0010\u000fR+\u0010\u0018\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r*\u0004\b\u0017\u0010\u000fR+\u0010\u001c\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\r*\u0004\b\u001b\u0010\u000fR+\u0010 \u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b\u001d\u0010\u000b\"\u0004\b\u001e\u0010\r*\u0004\b\u001f\u0010\u000fR+\u0010$\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\r*\u0004\b#\u0010\u000fR+\u0010(\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b%\u0010\u000b\"\u0004\b&\u0010\r*\u0004\b'\u0010\u000fR+\u0010,\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b)\u0010\u000b\"\u0004\b*\u0010\r*\u0004\b+\u0010\u000fR+\u00100\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b-\u0010\u000b\"\u0004\b.\u0010\r*\u0004\b/\u0010\u000fR+\u00104\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b1\u0010\u000b\"\u0004\b2\u0010\r*\u0004\b3\u0010\u000fR+\u00108\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u0010\r*\u0004\b7\u0010\u000fR+\u0010<\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\r*\u0004\b;\u0010\u000fR+\u0010@\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b=\u0010\u000b\"\u0004\b>\u0010\r*\u0004\b?\u0010\u000fR+\u0010D\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bA\u0010\u000b\"\u0004\bB\u0010\r*\u0004\bC\u0010\u000fR+\u0010H\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\r*\u0004\bG\u0010\u000fR+\u0010L\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bI\u0010\u000b\"\u0004\bJ\u0010\r*\u0004\bK\u0010\u000fR+\u0010P\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u0010\r*\u0004\bO\u0010\u000fR+\u0010T\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bQ\u0010\u000b\"\u0004\bR\u0010\r*\u0004\bS\u0010\u000fR+\u0010X\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bU\u0010\u000b\"\u0004\bV\u0010\r*\u0004\bW\u0010\u000fR+\u0010\\\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bY\u0010\u000b\"\u0004\bZ\u0010\r*\u0004\b[\u0010\u000fR+\u0010`\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b]\u0010\u000b\"\u0004\b^\u0010\r*\u0004\b_\u0010\u000fR+\u0010d\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\ba\u0010\u000b\"\u0004\bb\u0010\r*\u0004\bc\u0010\u000fR+\u0010h\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\be\u0010\u000b\"\u0004\bf\u0010\r*\u0004\bg\u0010\u000fR+\u0010l\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bi\u0010\u000b\"\u0004\bj\u0010\r*\u0004\bk\u0010\u000fR+\u0010p\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bm\u0010\u000b\"\u0004\bn\u0010\r*\u0004\bo\u0010\u000fR+\u0010t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bq\u0010\u000b\"\u0004\br\u0010\r*\u0004\bs\u0010\u000fR+\u0010x\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\bu\u0010\u000b\"\u0004\bv\u0010\r*\u0004\bw\u0010\u000fR+\u0010|\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\by\u0010\u000b\"\u0004\bz\u0010\r*\u0004\b{\u0010\u000fR,\u0010\u0080\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\u001a\u0004\b}\u0010\u000b\"\u0004\b~\u0010\r*\u0004\b\u007f\u0010\u000fR/\u0010\u0084\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u0081\u0001\u0010\u000b\"\u0005\b\u0082\u0001\u0010\r*\u0005\b\u0083\u0001\u0010\u000fR/\u0010\u0088\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u0085\u0001\u0010\u000b\"\u0005\b\u0086\u0001\u0010\r*\u0005\b\u0087\u0001\u0010\u000fR/\u0010\u008c\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u0089\u0001\u0010\u000b\"\u0005\b\u008a\u0001\u0010\r*\u0005\b\u008b\u0001\u0010\u000fR/\u0010\u0090\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u008d\u0001\u0010\u000b\"\u0005\b\u008e\u0001\u0010\r*\u0005\b\u008f\u0001\u0010\u000fR/\u0010\u0094\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u0091\u0001\u0010\u000b\"\u0005\b\u0092\u0001\u0010\r*\u0005\b\u0093\u0001\u0010\u000fR/\u0010\u0098\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u0095\u0001\u0010\u000b\"\u0005\b\u0096\u0001\u0010\r*\u0005\b\u0097\u0001\u0010\u000fR/\u0010\u009c\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u0099\u0001\u0010\u000b\"\u0005\b\u009a\u0001\u0010\r*\u0005\b\u009b\u0001\u0010\u000fR/\u0010\u00a0\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u009d\u0001\u0010\u000b\"\u0005\b\u009e\u0001\u0010\r*\u0005\b\u009f\u0001\u0010\u000fR/\u0010\u00a4\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u00a1\u0001\u0010\u000b\"\u0005\b\u00a2\u0001\u0010\r*\u0005\b\u00a3\u0001\u0010\u000fR/\u0010\u00a8\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u00a5\u0001\u0010\u000b\"\u0005\b\u00a6\u0001\u0010\r*\u0005\b\u00a7\u0001\u0010\u000fR/\u0010\u00ac\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u00a9\u0001\u0010\u000b\"\u0005\b\u00aa\u0001\u0010\r*\u0005\b\u00ab\u0001\u0010\u000fR/\u0010\u00b0\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u00ad\u0001\u0010\u000b\"\u0005\b\u00ae\u0001\u0010\r*\u0005\b\u00af\u0001\u0010\u000fR/\u0010\u00b4\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u00b1\u0001\u0010\u000b\"\u0005\b\u00b2\u0001\u0010\r*\u0005\b\u00b3\u0001\u0010\u000fR/\u0010\u00b8\u0001\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038F@FX\u0086\u008e\u0002\u00a2\u0006\u0015\u001a\u0005\b\u00b5\u0001\u0010\u000b\"\u0005\b\u00b6\u0001\u0010\r*\u0005\b\u00b7\u0001\u0010\u000f\u00a8\u0006\u00bd\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/report/QQLiveDaTongParams;", "", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "a", "", "Ljava/util/Map;", "map", "<set-?>", "getDt_appkey", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "getDt_appkey$delegate", "(Lcom/tencent/mobileqq/qqlive/sail/report/QQLiveDaTongParams;)Ljava/lang/Object;", DTParamKey.REPORT_KEY_APPKEY, "getDt_pgid", "e", "getDt_pgid$delegate", "dt_pgid", "getDt_qq", "f", "getDt_qq$delegate", DTPublicParamKey.DT_QQ, "getDt_eid", "d", "getDt_eid$delegate", "dt_eid", "getQqlive_entertime", "r", "getQqlive_entertime$delegate", "qqlive_entertime", "getQqlive_user_id", "K", "getQqlive_user_id$delegate", "qqlive_user_id", "getQqlive_anchor_id", "j", "getQqlive_anchor_id$delegate", "qqlive_anchor_id", "getQqlive_room_id", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "getQqlive_room_id$delegate", "qqlive_room_id", "b", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "getQqlive_program_id$delegate", "qqlive_program_id", "getQqlive_zhibo_type", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getQqlive_zhibo_type$delegate", "qqlive_zhibo_type", "getQqlive_zhibo_content", "P", "getQqlive_zhibo_content$delegate", "qqlive_zhibo_content", "getQqlive_coming_way", DomainData.DOMAIN_NAME, "getQqlive_coming_way$delegate", "qqlive_coming_way", "getQqlive_enter_id", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "getQqlive_enter_id$delegate", "qqlive_enter_id", "getQqlive_start_source", "G", "getQqlive_start_source$delegate", "qqlive_start_source", "getQqlive_abtoken", "i", "getQqlive_abtoken$delegate", QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, "getQqlive_start_type", "H", "getQqlive_start_type$delegate", "qqlive_start_type", "getQqlive_start_way", "I", "getQqlive_start_way$delegate", "qqlive_start_way", "getQqlive_start_platform", UserInfo.SEX_FEMALE, "getQqlive_start_platform$delegate", "qqlive_start_platform", "getZengzhi_tracedetail", ExifInterface.LATITUDE_SOUTH, "getZengzhi_tracedetail$delegate", "zengzhi_tracedetail", "getQqlive_match_type", "y", "getQqlive_match_type$delegate", "qqlive_match_type", "getQqlive_start_game", "D", "getQqlive_start_game$delegate", "qqlive_start_game", "getQqlive_livestart_source", HippyTKDListViewAdapter.X, "getQqlive_livestart_source$delegate", "qqlive_livestart_source", "getQqlive_seeway", BdhLogUtil.LogTag.Tag_Conn, "getQqlive_seeway$delegate", "qqlive_seeway", "getQq_live_appstatus", "g", "getQq_live_appstatus$delegate", "qq_live_appstatus", "getQqlive_timelong", "J", "getQqlive_timelong$delegate", "qqlive_timelong", "getQqlive_zhibo_category", "O", "getQqlive_zhibo_category$delegate", "qqlive_zhibo_category", "getQqlive_start_mode", "E", "getQqlive_start_mode$delegate", "qqlive_start_mode", "getQqlive_screen_orientation", "B", "getQqlive_screen_orientation$delegate", "qqlive_screen_orientation", "getQqlive_combo_real", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getQqlive_combo_real$delegate", "qqlive_combo_real", "getQqlive_gift_id", "v", "getQqlive_gift_id$delegate", "qqlive_gift_id", "getQqlive_abtestid", h.F, "getQqlive_abtestid$delegate", "qqlive_abtestid", "getZengzhi_moduleid", BdhLogUtil.LogTag.Tag_Req, "getZengzhi_moduleid$delegate", "zengzhi_moduleid", "getQqlive_focus_page_casue", ReportConstant.COSTREPORT_PREFIX, "getQqlive_focus_page_casue$delegate", "qqlive_focus_page_casue", "getQqlive_gift_texiao_status", "w", "getQqlive_gift_texiao_status$delegate", "qqlive_gift_texiao_status", "getQqlive_danmu_status", "p", "getQqlive_danmu_status$delegate", "qqlive_danmu_status", "getQqlive_follow_status", "t", "getQqlive_follow_status$delegate", "qqlive_follow_status", "getQqlive_function_name", "u", "getQqlive_function_name$delegate", "qqlive_function_name", "getQqlive_windows_type", "M", "getQqlive_windows_type$delegate", "qqlive_windows_type", "getQqlive_windows_condition", "L", "getQqlive_windows_condition$delegate", "qqlive_windows_condition", "getQqlive_windows_value", "N", "getQqlive_windows_value$delegate", "qqlive_windows_value", "getQqlive_button_id", "k", "getQqlive_button_id$delegate", "qqlive_button_id", "getQqlive_button_position", "l", "getQqlive_button_position$delegate", "qqlive_button_position", "getQqlive_content", "o", "getQqlive_content$delegate", "qqlive_content", "<init>", "()V", "", "(Ljava/util/Map;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveDaTongParams {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f272380c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> map;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/report/QQLiveDaTongParams$a;", "", "", "DT_APPKEY", "Ljava/lang/String;", "DT_PAGE_ID_ANCHOR", "DT_PAGE_ID_ANCHOR_PREPARE", "DT_PAGE_ID_AUDIENCE", "DT_PAGE_ID_AUDIENCE_END", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.report.QQLiveDaTongParams$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18811);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 96)) {
            redirector.redirect((short) 96);
        } else {
            f272380c = new KProperty[]{Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, DTParamKey.REPORT_KEY_APPKEY, "getDt_appkey()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "dt_pgid", "getDt_pgid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, DTPublicParamKey.DT_QQ, "getDt_qq()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "dt_eid", "getDt_eid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "dt_imp", "getDt_imp()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_entertime", "getQqlive_entertime()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_user_id", "getQqlive_user_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_anchor_id", "getQqlive_anchor_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_room_id", "getQqlive_room_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_program_id", "getQqlive_program_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_zhibo_type", "getQqlive_zhibo_type()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_zhibo_content", "getQqlive_zhibo_content()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_coming_way", "getQqlive_coming_way()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_enter_id", "getQqlive_enter_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_start_source", "getQqlive_start_source()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, QCircleDaTongConstant.ElementParamKey.TAG_QQLIVE_TOKEN, "getQqlive_abtoken()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_start_type", "getQqlive_start_type()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_start_way", "getQqlive_start_way()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_start_platform", "getQqlive_start_platform()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "zengzhi_tracedetail", "getZengzhi_tracedetail()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_match_type", "getQqlive_match_type()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_start_game", "getQqlive_start_game()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_livestart_source", "getQqlive_livestart_source()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_seeway", "getQqlive_seeway()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qq_live_appstatus", "getQq_live_appstatus()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_timelong", "getQqlive_timelong()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_zhibo_category", "getQqlive_zhibo_category()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_start_mode", "getQqlive_start_mode()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_screen_orientation", "getQqlive_screen_orientation()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_combo_real", "getQqlive_combo_real()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_gift_id", "getQqlive_gift_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_abtestid", "getQqlive_abtestid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_gamecard_taskid", "getQqlive_gamecard_taskid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "zengzhi_moduleid", "getZengzhi_moduleid()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_focus_page_casue", "getQqlive_focus_page_casue()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_gift_texiao_status", "getQqlive_gift_texiao_status()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_danmu_status", "getQqlive_danmu_status()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_follow_status", "getQqlive_follow_status()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_function_name", "getQqlive_function_name()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_windows_type", "getQqlive_windows_type()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_windows_condition", "getQqlive_windows_condition()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_windows_value", "getQqlive_windows_value()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_to_room_id", "getQqlive_to_room_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_button_id", "getQqlive_button_id()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_button_position", "getQqlive_button_position()Ljava/lang/String;", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(QQLiveDaTongParams.class, "qqlive_content", "getQqlive_content()Ljava/lang/String;", 0))};
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveDaTongParams() {
        Map<String, String> withDefaultMutable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 93)) {
            iPatchRedirector.redirect((short) 93, (Object) this);
            return;
        }
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new ConcurrentHashMap(), QQLiveDaTongParams$map$1.INSTANCE);
        this.map = withDefaultMutable;
        c("0AND06MK9E48EOTF");
    }

    public final void A(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[8].getName(), str);
        }
    }

    public final void B(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            iPatchRedirector.redirect((short) 58, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[28].getName(), str);
        }
    }

    public final void C(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[23].getName(), str);
        }
    }

    public final void D(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[21].getName(), str);
        }
    }

    public final void E(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[27].getName(), str);
        }
    }

    public final void F(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[18].getName(), str);
        }
    }

    public final void G(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[14].getName(), str);
        }
    }

    public final void H(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[16].getName(), str);
        }
    }

    public final void I(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[17].getName(), str);
        }
    }

    public final void J(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[25].getName(), str);
        }
    }

    public final void K(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[6].getName(), str);
        }
    }

    public final void L(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 82)) {
            iPatchRedirector.redirect((short) 82, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[40].getName(), str);
        }
    }

    public final void M(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 80)) {
            iPatchRedirector.redirect((short) 80, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[39].getName(), str);
        }
    }

    public final void N(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 84)) {
            iPatchRedirector.redirect((short) 84, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[41].getName(), str);
        }
    }

    public final void O(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[26].getName(), str);
        }
    }

    public final void P(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[11].getName(), str);
        }
    }

    public final void Q(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[10].getName(), str);
        }
    }

    public final void R(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[33].getName(), str);
        }
    }

    public final void S(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[19].getName(), str);
        }
    }

    @NotNull
    public final HashMap<String, String> a() {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 95)) {
            return (HashMap) iPatchRedirector.redirect((short) 95, (Object) this);
        }
        Map<String, String> map = this.map;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            isBlank = StringsKt__StringsJVMKt.isBlank(entry.getValue());
            if (!isBlank) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new HashMap<>(linkedHashMap);
    }

    @NotNull
    public final String b() {
        Object orImplicitDefaultNullable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            orImplicitDefaultNullable = MapsKt__MapWithDefaultKt.getOrImplicitDefaultNullable(this.map, f272380c[9].getName());
            return (String) orImplicitDefaultNullable;
        }
        return (String) iPatchRedirector.redirect((short) 19, (Object) this);
    }

    public final void c(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[0].getName(), str);
        }
    }

    public final void d(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[3].getName(), str);
        }
    }

    public final void e(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[1].getName(), str);
        }
    }

    public final void f(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[2].getName(), str);
        }
    }

    public final void g(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[24].getName(), str);
        }
    }

    public final void h(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[31].getName(), str);
        }
    }

    public final void i(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[15].getName(), str);
        }
    }

    public final void j(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[7].getName(), str);
        }
    }

    public final void k(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 88)) {
            iPatchRedirector.redirect((short) 88, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[43].getName(), str);
        }
    }

    public final void l(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 90)) {
            iPatchRedirector.redirect((short) 90, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[44].getName(), str);
        }
    }

    public final void m(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[29].getName(), str);
        }
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[12].getName(), str);
        }
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 92)) {
            iPatchRedirector.redirect((short) 92, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[45].getName(), str);
        }
    }

    public final void p(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 74)) {
            iPatchRedirector.redirect((short) 74, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[36].getName(), str);
        }
    }

    public final void q(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[13].getName(), str);
        }
    }

    public final void r(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[5].getName(), str);
        }
    }

    public final void s(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[34].getName(), str);
        }
    }

    public final void t(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 76)) {
            iPatchRedirector.redirect((short) 76, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[37].getName(), str);
        }
    }

    public final void u(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 78)) {
            iPatchRedirector.redirect((short) 78, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[38].getName(), str);
        }
    }

    public final void v(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[30].getName(), str);
        }
    }

    public final void w(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 72)) {
            iPatchRedirector.redirect((short) 72, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[35].getName(), str);
        }
    }

    public final void x(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[22].getName(), str);
        }
    }

    public final void y(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[20].getName(), str);
        }
    }

    public final void z(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.map.put(f272380c[9].getName(), str);
        }
    }

    public QQLiveDaTongParams(@NotNull Map<String, String> map) {
        Map<String, String> withDefaultMutable;
        Intrinsics.checkNotNullParameter(map, "map");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 94)) {
            iPatchRedirector.redirect((short) 94, (Object) this, (Object) map);
            return;
        }
        withDefaultMutable = MapsKt__MapWithDefaultKt.withDefaultMutable(new ConcurrentHashMap(), QQLiveDaTongParams$map$1.INSTANCE);
        this.map = withDefaultMutable;
        c("0AND06MK9E48EOTF");
        withDefaultMutable.putAll(map);
    }
}
