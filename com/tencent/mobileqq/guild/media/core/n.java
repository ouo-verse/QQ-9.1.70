package com.tencent.mobileqq.guild.media.core;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import at1.GuildGameCreateBean;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.media.core.data.GuildMediaUserBarNodePermission;
import com.tencent.mobileqq.guild.media.core.data.MediaRoomStatus;
import com.tencent.mobileqq.guild.media.core.data.MediaShareLoadInfo;
import com.tencent.mobileqq.guild.util.cm;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSendGiftEventData;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProBusinessNode;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelToolBar;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildThemeInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSongInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010#\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u00f3\u0001\u0010\u00f4\u0001J\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013R\u0017\u0010\u001d\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010#\u001a\u00020\u001e8\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\"\u0010+\u001a\u00020$8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b\u0015\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010.\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010>\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R(\u0010F\u001a\b\u0012\u0004\u0012\u00020@0?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\b-\u0010C\"\u0004\bD\u0010ER2\u0010P\u001a\u0012\u0012\u0004\u0012\u00020H0Gj\b\u0012\u0004\u0012\u00020H`I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR%\u0010W\u001a\u0010\u0012\f\u0012\n S*\u0004\u0018\u00010R0R0Q8\u0006\u00a2\u0006\f\n\u0004\b'\u0010T\u001a\u0004\bU\u0010VR%\u0010Z\u001a\u0010\u0012\f\u0012\n S*\u0004\u0018\u00010R0R0Q8\u0006\u00a2\u0006\f\n\u0004\bX\u0010T\u001a\u0004\bY\u0010VR%\u0010]\u001a\u0010\u0012\f\u0012\n S*\u0004\u0018\u00010[0[0Q8\u0006\u00a2\u0006\f\n\u0004\b9\u0010T\u001a\u0004\b\\\u0010VR\u001d\u0010`\u001a\b\u0012\u0004\u0012\u00020^0Q8\u0006\u00a2\u0006\f\n\u0004\b_\u0010T\u001a\u0004\b9\u0010VR(\u0010c\u001a\b\u0012\u0004\u0012\u0002070?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010B\u001a\u0004\ba\u0010C\"\u0004\bb\u0010ER.\u0010f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020d0G0?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010B\u001a\u0004\bX\u0010C\"\u0004\be\u0010ER$\u0010m\u001a\u0004\u0018\u00010g8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bh\u0010j\"\u0004\bk\u0010lR\"\u0010u\u001a\u00020n8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\bo\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u001d\u0010z\u001a\b\u0012\u0004\u0012\u0002070v8\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010w\u001a\u0004\bx\u0010yR#\u0010\u0080\u0001\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b{\u0010X\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR$\u0010\u0082\u0001\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\bL\u0010X\u001a\u0004\bo\u0010}\"\u0005\b\u0081\u0001\u0010\u007fR&\u0010\u0086\u0001\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0083\u0001\u0010X\u001a\u0005\b\u0084\u0001\u0010}\"\u0005\b\u0085\u0001\u0010\u007fR&\u0010\u0088\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0084\u0001\u00109\u001a\u0005\b\u0083\u0001\u0010;\"\u0005\b\u0087\u0001\u0010=R&\u0010\u008c\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0089\u0001\u00109\u001a\u0005\b\u008a\u0001\u0010;\"\u0005\b\u008b\u0001\u0010=R(\u0010\u0092\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0005\b8\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R,\u0010\u009a\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R+\u0010\u00a1\u0001\u001a\u0005\u0018\u00010\u009b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u009c\u0001\u0010\u009d\u0001\u001a\u0005\bJ\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010\u00a0\u0001R&\u0010\u00a4\u0001\u001a\u00020[8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u008e\u0001\u0010X\u001a\u0005\b\u00a2\u0001\u0010}\"\u0005\b\u00a3\u0001\u0010\u007fR&\u0010\u00a8\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00a5\u0001\u00109\u001a\u0005\b\u00a6\u0001\u0010;\"\u0005\b\u00a7\u0001\u0010=R%\u0010\u00ab\u0001\u001a\u0002078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00a9\u0001\u00109\u001a\u0004\b_\u0010;\"\u0005\b\u00aa\u0001\u0010=R)\u0010\u00b2\u0001\u001a\u00030\u00ac\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u00ad\u0001\u0010\u00ae\u0001\u001a\u0005\b\u0019\u0010\u00af\u0001\"\u0006\b\u00b0\u0001\u0010\u00b1\u0001R(\u0010\u00b4\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u008b\u0001\u0010\u008e\u0001\u001a\u0005\b\u0010\u0010\u008f\u0001\"\u0006\b\u00b3\u0001\u0010\u0091\u0001R+\u0010\u00b9\u0001\u001a\u0011\u0012\f\u0012\n S*\u0004\u0018\u00010\u00020\u00020\u00b5\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00b3\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00b7\u0001\u0010\u00b8\u0001R*\u0010\u00ba\u0001\u001a\u0011\u0012\f\u0012\n S*\u0004\u0018\u00010\u00020\u00020\u00b5\u00018\u0006\u00a2\u0006\u000f\n\u0005\b0\u0010\u00b6\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00b8\u0001RR\u0010\u00c3\u0001\u001a,\u0012\u000e\u0012\f S*\u0005\u0018\u00010\u00bc\u00010\u00bc\u0001 S*\u0015\u0012\u000e\u0012\f S*\u0005\u0018\u00010\u00bc\u00010\u00bc\u0001\u0018\u00010\u00bd\u00010\u00bb\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u00be\u0001\u0010\u00bf\u0001\u001a\u0005\b{\u0010\u00c0\u0001\"\u0006\b\u00c1\u0001\u0010\u00c2\u0001R/\u0010\u00ca\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00c4\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0007\u0010\u00c5\u0001\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001\"\u0006\b\u00c8\u0001\u0010\u00c9\u0001R8\u0010\u00ce\u0001\u001a\u0011\u0012\f\u0012\n S*\u0004\u0018\u00010\u00020\u00020\u00b5\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00b0\u0001\u0010\u00b6\u0001\u001a\u0006\b\u00cb\u0001\u0010\u00b8\u0001\"\u0006\b\u00cc\u0001\u0010\u00cd\u0001R(\u0010\u00d4\u0001\u001a\u00030\u00cf\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bs\u0010\u00d0\u0001\u001a\u0005\b%\u0010\u00d1\u0001\"\u0006\b\u00d2\u0001\u0010\u00d3\u0001R7\u0010\u00dd\u0001\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0005\u0012\u00030\u00d6\u00010\u00d5\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00d7\u0001\u0010\u00d8\u0001\u001a\u0006\b\u00d9\u0001\u0010\u00da\u0001\"\u0006\b\u00db\u0001\u0010\u00dc\u0001R$\u0010\u00df\u0001\u001a\n\u0012\u0005\u0012\u00030\u00de\u00010\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0098\u0001\u0010\u00c5\u0001\u001a\u0006\b\u009c\u0001\u0010\u00c7\u0001R$\u0010\u00e1\u0001\u001a\n\u0012\u0005\u0012\u00030\u00de\u00010\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e0\u0001\u0010\u00c5\u0001\u001a\u0006\b\u0094\u0001\u0010\u00c7\u0001R$\u0010\u00e3\u0001\u001a\n\u0012\u0005\u0012\u00030\u00de\u00010\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e2\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00c7\u0001R#\u0010\u00e5\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e4\u0001\u0010\u00c5\u0001\u001a\u0006\b\u00a9\u0001\u0010\u00c7\u0001R#\u0010\u00e7\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u00c4\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00e6\u0001\u0010\u00c5\u0001\u001a\u0006\b\u008d\u0001\u0010\u00c7\u0001R$\u0010\u00ee\u0001\u001a\n\u0012\u0005\u0012\u00030\u00e9\u00010\u00e8\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00ea\u0001\u0010\u00eb\u0001\u001a\u0006\b\u00ec\u0001\u0010\u00ed\u0001R$\u0010\u00f2\u0001\u001a\n\u0012\u0005\u0012\u00030\u00ef\u00010\u00e8\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u00f0\u0001\u0010\u00eb\u0001\u001a\u0006\b\u00f1\u0001\u0010\u00ed\u0001\u00a8\u0006\u00f5\u0001"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/n;", "Lcom/tencent/mobileqq/guild/media/core/g;", "", "a", "", "E0", "p", "h0", "u", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "d", "Lcom/tencent/mobileqq/guild/media/core/data/f;", "getSelfUserInfo", "()Lcom/tencent/mobileqq/guild/media/core/data/f;", "selfUserInfo", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "e", "Lcom/tencent/mobileqq/guild/media/core/data/r;", "D0", "()Lcom/tencent/mobileqq/guild/media/core/data/r;", "userInfoList", "f", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "totalUserInfoList", "Lcom/tencent/mobileqq/guild/media/core/data/l;", tl.h.F, "Lcom/tencent/mobileqq/guild/media/core/data/l;", "A0", "()Lcom/tencent/mobileqq/guild/media/core/data/l;", "tRTCUserInfoList", "Lcom/tencent/mobileqq/guild/media/core/data/a;", "i", "Lcom/tencent/mobileqq/guild/media/core/data/a;", "B", "()Lcom/tencent/mobileqq/guild/media/core/data/a;", "screenShareAnchorInfo", "Lcom/tencent/mobileqq/guild/media/core/q;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/media/core/q;", "H", "()Lcom/tencent/mobileqq/guild/media/core/q;", "M0", "(Lcom/tencent/mobileqq/guild/media/core/q;)V", "startParams", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "()Ljava/lang/String;", "f0", "(Ljava/lang/String;)V", "authMeta", "D", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "H0", "roomSessionId", "", "E", "J", "getChannelDataVersion", "()J", "setChannelDataVersion", "(J)V", "channelDataVersion", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProVoiceInfo;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/MutableLiveData;", "()Landroidx/lifecycle/MutableLiveData;", "setScreenShareInfo", "(Landroidx/lifecycle/MutableLiveData;)V", "screenShareInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/media/core/data/d;", "Lkotlin/collections/ArrayList;", "G", "Ljava/util/ArrayList;", ExifInterface.LATITUDE_SOUTH, "()Ljava/util/ArrayList;", "setUserBarNodePermission", "(Ljava/util/ArrayList;)V", "userBarNodePermission", "Le12/e;", "Lcom/tencent/mobileqq/guild/media/core/EnterChannelState;", "kotlin.jvm.PlatformType", "Le12/e;", "k", "()Le12/e;", "enterChannelState", "I", "l", "enterTRTCRoomState", "", "M", "themeType", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildThemeInfo;", "K", "themeInfo", "L", "setThemeSponsor", "themeSponsor", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProBusinessNode;", "setThemeBizNodeList", "themeBizNodeList", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelToolBar;", "N", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelToolBar;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelToolBar;", "P0", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannelToolBar;)V", "toolBarConfig", "Lat1/a;", "P", "Lat1/a;", DomainData.DOMAIN_NAME, "()Lat1/a;", "j0", "(Lat1/a;)V", "gameCreateRoomInfo", "", "Ljava/util/Set;", "r", "()Ljava/util/Set;", "muteToMeList", BdhLogUtil.LogTag.Tag_Req, "O", "()I", "Q0", "(I)V", "totalNum", "R0", "totalShowNumThreshold", "T", "U", "T0", "viewerNum", "S0", "userNumDataVersion", "V", "b", "d0", "aioShowMsgSeq", "W", "Z", "()Z", "I0", "(Z)V", "selfHasOpenMic", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayInfo;", "X", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayInfo;", "v", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayInfo;", "l0", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProPlayInfo;)V", "playInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSongInfo;", "Y", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSongInfo;", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSongInfo;", "J0", "(Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProSongInfo;)V", "songInfo", HippyTKDListViewAdapter.X, "F0", "playNum", "a0", "getPlayInfoDataVersion", "setPlayInfoDataVersion", "playInfoDataVersion", "b0", "O0", "themePanelLaunchTime", "Lcom/tencent/mobileqq/guild/media/core/logic/j;", "c0", "Lcom/tencent/mobileqq/guild/media/core/logic/j;", "()Lcom/tencent/mobileqq/guild/media/core/logic/j;", "i0", "(Lcom/tencent/mobileqq/guild/media/core/logic/j;)V", "enterChannelParamsForTRTCRoom", "e0", "aioShowState", "Le12/a;", "Le12/a;", "g", "()Le12/a;", "disableVoiceAnimation", "isMicCaptureInactive", "", "Lcom/tencent/mobileqq/guild/media/core/data/g;", "", "g0", "Ljava/util/List;", "()Ljava/util/List;", "setTrtcRoomList", "(Ljava/util/List;)V", "trtcRoomList", "Lcom/tencent/mobileqq/guild/util/cn;", "Lcom/tencent/mobileqq/guild/util/cn;", "t", "()Lcom/tencent/mobileqq/guild/util/cn;", "setNeedShowNavTips", "(Lcom/tencent/mobileqq/guild/util/cn;)V", "needShowNavTips", ReportConstant.COSTREPORT_PREFIX, "setNeedShowInviteOpenMicMsg", "(Le12/a;)V", "needShowInviteOpenMicMsg", "Lct1/a;", "Lct1/a;", "()Lct1/a;", "setFreeGiftInfo", "(Lct1/a;)V", "freeGiftInfo", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "k0", "Ljava/util/concurrent/ConcurrentHashMap;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()Ljava/util/concurrent/ConcurrentHashMap;", "setPresentGiftMap", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "presentGiftMap", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSendGiftEventData;", "isFirstReceiveFreeGift", "m0", "isFirstReceiveChargeGift", "n0", "isTodayFirstReceiveFreeGift", "o0", "isTodayFirstGetFreeGift", "p0", "isFirstGetUpperLimitFreeGift", "Lcom/tencent/mobileqq/guild/util/cm;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "q0", "Lcom/tencent/mobileqq/guild/util/cm;", "o", "()Lcom/tencent/mobileqq/guild/util/cm;", "giftAnimData", "Lcom/tencent/mobileqq/guild/media/core/data/MediaShareLoadInfo;", "r0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mediaShareLoadInfo", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class n implements g {

    /* renamed from: E, reason: from kotlin metadata */
    private long channelDataVersion;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final e12.e<EnterChannelState> enterChannelState;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final e12.e<EnterChannelState> enterTRTCRoomState;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final e12.e<Integer> themeType;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final e12.e<IGProGuildThemeInfo> themeInfo;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Long> themeSponsor;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<ArrayList<IGProBusinessNode>> themeBizNodeList;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private IGProChannelToolBar toolBarConfig;

    /* renamed from: P, reason: from kotlin metadata */
    public GuildGameCreateBean gameCreateRoomInfo;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final Set<Long> muteToMeList;

    /* renamed from: R, reason: from kotlin metadata */
    private int totalNum;

    /* renamed from: S, reason: from kotlin metadata */
    private int totalShowNumThreshold;

    /* renamed from: T, reason: from kotlin metadata */
    private int viewerNum;

    /* renamed from: U, reason: from kotlin metadata */
    private long userNumDataVersion;

    /* renamed from: V, reason: from kotlin metadata */
    private long aioShowMsgSeq;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean selfHasOpenMic;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private IGProPlayInfo playInfo;

    /* renamed from: Y, reason: from kotlin metadata */
    @Nullable
    private IGProSongInfo songInfo;

    /* renamed from: Z, reason: from kotlin metadata */
    private int playNum;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private long playInfoDataVersion;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private long themePanelLaunchTime;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.media.core.logic.j enterChannelParamsForTRTCRoom;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean aioShowState;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> disableVoiceAnimation;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e12.a<Boolean> isMicCaptureInactive;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private volatile List<MediaRoomStatus> trtcRoomList;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private cn<Boolean> needShowNavTips;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private e12.a<Boolean> needShowInviteOpenMicMsg;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private volatile ct1.a freeGiftInfo;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<String, com.tencent.mobileqq.guild.media.core.data.p> presentGiftMap;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<IGProSendGiftEventData> isFirstReceiveFreeGift;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<IGProSendGiftEventData> isFirstReceiveChargeGift;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<IGProSendGiftEventData> isTodayFirstReceiveFreeGift;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<Boolean> isTodayFirstGetFreeGift;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cn<Boolean> isFirstGetUpperLimitFreeGift;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cm<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> giftAnimData;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final cm<MediaShareLoadInfo> mediaShareLoadInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.f selfUserInfo = new com.tencent.mobileqq.guild.media.core.data.f();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.r userInfoList = new com.tencent.mobileqq.guild.media.core.data.r();

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.r totalUserInfoList = new com.tencent.mobileqq.guild.media.core.data.r();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.l tRTCUserInfoList = new com.tencent.mobileqq.guild.media.core.data.l();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.media.core.data.a screenShareAnchorInfo = new com.tencent.mobileqq.guild.media.core.data.a();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private q startParams = q.INSTANCE.a();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private String authMeta = "";

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String roomSessionId = "";

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<IGProVoiceInfo> screenShareInfo = new e12.a(null);

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private ArrayList<GuildMediaUserBarNodePermission> userBarNodePermission = new ArrayList<>();

    public n() {
        EnterChannelState enterChannelState = EnterChannelState.IDLE;
        this.enterChannelState = new e12.e<>(enterChannelState);
        this.enterTRTCRoomState = new e12.e<>(enterChannelState);
        this.themeType = new e12.e<>(0);
        this.themeInfo = new e12.e<>();
        this.themeSponsor = new MutableLiveData<>(0L);
        this.themeBizNodeList = new MutableLiveData<>(new ArrayList(0));
        this.muteToMeList = new LinkedHashSet();
        this.totalShowNumThreshold = 100;
        this.aioShowMsgSeq = -1L;
        this.playNum = -1;
        this.playInfoDataVersion = -1L;
        this.themePanelLaunchTime = -1L;
        this.enterChannelParamsForTRTCRoom = new com.tencent.mobileqq.guild.media.core.logic.j(0, null, null, null, 0L, 0L, 0L, 127, null);
        this.aioShowState = true;
        Boolean bool = Boolean.FALSE;
        this.disableVoiceAnimation = new e12.a<>(bool);
        this.isMicCaptureInactive = new e12.a<>(bool);
        this.trtcRoomList = Collections.synchronizedList(new CopyOnWriteArrayList());
        this.needShowNavTips = new cn<>();
        this.needShowInviteOpenMicMsg = new e12.a<>(bool);
        this.freeGiftInfo = new ct1.a();
        this.presentGiftMap = new ConcurrentHashMap<>();
        this.isFirstReceiveFreeGift = new cn<>();
        this.isFirstReceiveChargeGift = new cn<>();
        this.isTodayFirstReceiveFreeGift = new cn<>();
        this.isTodayFirstGetFreeGift = new cn<>();
        this.isFirstGetUpperLimitFreeGift = new cn<>();
        this.giftAnimData = new cm<>();
        this.mediaShareLoadInfo = new cm<>();
    }

    @NotNull
    /* renamed from: A, reason: from getter */
    public final String getRoomSessionId() {
        return this.roomSessionId;
    }

    @NotNull
    /* renamed from: A0, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.l getTRTCUserInfoList() {
        return this.tRTCUserInfoList;
    }

    @NotNull
    /* renamed from: B, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.a getScreenShareAnchorInfo() {
        return this.screenShareAnchorInfo;
    }

    @NotNull
    public final MutableLiveData<IGProVoiceInfo> C() {
        return this.screenShareInfo;
    }

    @NotNull
    /* renamed from: D0, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.r getUserInfoList() {
        return this.userInfoList;
    }

    /* renamed from: E, reason: from getter */
    public final boolean getSelfHasOpenMic() {
        return this.selfHasOpenMic;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void E0() {
        Integer num;
        e12.e<Integer> eVar = this.themeType;
        IGProGuildThemeInfo value = this.themeInfo.getValue();
        if (value != null) {
            num = Integer.valueOf(value.getThemeType());
        } else {
            num = null;
        }
        eVar.setValue(num);
    }

    public final void F0(int i3) {
        this.playNum = i3;
    }

    @Nullable
    /* renamed from: G, reason: from getter */
    public final IGProSongInfo getSongInfo() {
        return this.songInfo;
    }

    @NotNull
    /* renamed from: H, reason: from getter */
    public final q getStartParams() {
        return this.startParams;
    }

    public final void H0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.roomSessionId = str;
    }

    @NotNull
    public final MutableLiveData<ArrayList<IGProBusinessNode>> I() {
        return this.themeBizNodeList;
    }

    public final void I0(boolean z16) {
        this.selfHasOpenMic = z16;
    }

    @NotNull
    public final e12.e<IGProGuildThemeInfo> J() {
        return this.themeInfo;
    }

    public final void J0(@Nullable IGProSongInfo iGProSongInfo) {
        this.songInfo = iGProSongInfo;
    }

    /* renamed from: K, reason: from getter */
    public final long getThemePanelLaunchTime() {
        return this.themePanelLaunchTime;
    }

    @NotNull
    public final MutableLiveData<Long> L() {
        return this.themeSponsor;
    }

    @NotNull
    public final e12.e<Integer> M() {
        return this.themeType;
    }

    public final void M0(@NotNull q qVar) {
        Intrinsics.checkNotNullParameter(qVar, "<set-?>");
        this.startParams = qVar;
    }

    @Nullable
    /* renamed from: N, reason: from getter */
    public final IGProChannelToolBar getToolBarConfig() {
        return this.toolBarConfig;
    }

    /* renamed from: O, reason: from getter */
    public final int getTotalNum() {
        return this.totalNum;
    }

    public final void O0(long j3) {
        this.themePanelLaunchTime = j3;
    }

    /* renamed from: P, reason: from getter */
    public final int getTotalShowNumThreshold() {
        return this.totalShowNumThreshold;
    }

    public final void P0(@Nullable IGProChannelToolBar iGProChannelToolBar) {
        this.toolBarConfig = iGProChannelToolBar;
    }

    @NotNull
    /* renamed from: Q, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.data.r getTotalUserInfoList() {
        return this.totalUserInfoList;
    }

    public final void Q0(int i3) {
        this.totalNum = i3;
    }

    public final List<MediaRoomStatus> R() {
        return this.trtcRoomList;
    }

    public final void R0(int i3) {
        this.totalShowNumThreshold = i3;
    }

    @NotNull
    public final ArrayList<GuildMediaUserBarNodePermission> S() {
        return this.userBarNodePermission;
    }

    public final void S0(long j3) {
        this.userNumDataVersion = j3;
    }

    /* renamed from: T, reason: from getter */
    public final long getUserNumDataVersion() {
        return this.userNumDataVersion;
    }

    public final void T0(int i3) {
        this.viewerNum = i3;
    }

    /* renamed from: U, reason: from getter */
    public final int getViewerNum() {
        return this.viewerNum;
    }

    @NotNull
    public final cn<Boolean> W() {
        return this.isFirstGetUpperLimitFreeGift;
    }

    @NotNull
    public final cn<IGProSendGiftEventData> X() {
        return this.isFirstReceiveChargeGift;
    }

    @NotNull
    public final cn<IGProSendGiftEventData> Y() {
        return this.isFirstReceiveFreeGift;
    }

    public final boolean a() {
        if (this.gameCreateRoomInfo != null && n().getRoomInfo() != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public final e12.a<Boolean> a0() {
        return this.isMicCaptureInactive;
    }

    /* renamed from: b, reason: from getter */
    public final long getAioShowMsgSeq() {
        return this.aioShowMsgSeq;
    }

    @NotNull
    public final cn<Boolean> b0() {
        return this.isTodayFirstGetFreeGift;
    }

    @NotNull
    public final cn<IGProSendGiftEventData> c0() {
        return this.isTodayFirstReceiveFreeGift;
    }

    public final void d0(long j3) {
        this.aioShowMsgSeq = j3;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getAioShowState() {
        return this.aioShowState;
    }

    public final void e0(boolean z16) {
        this.aioShowState = z16;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getAuthMeta() {
        return this.authMeta;
    }

    public final void f0(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authMeta = str;
    }

    @NotNull
    public final e12.a<Boolean> g() {
        return this.disableVoiceAnimation;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.media.core.data.f getSelfUserInfo() {
        return this.selfUserInfo;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final com.tencent.mobileqq.guild.media.core.logic.j getEnterChannelParamsForTRTCRoom() {
        return this.enterChannelParamsForTRTCRoom;
    }

    public final void i0(@NotNull com.tencent.mobileqq.guild.media.core.logic.j jVar) {
        Intrinsics.checkNotNullParameter(jVar, "<set-?>");
        this.enterChannelParamsForTRTCRoom = jVar;
    }

    public final void j0(@NotNull GuildGameCreateBean guildGameCreateBean) {
        Intrinsics.checkNotNullParameter(guildGameCreateBean, "<set-?>");
        this.gameCreateRoomInfo = guildGameCreateBean;
    }

    @NotNull
    public final e12.e<EnterChannelState> k() {
        return this.enterChannelState;
    }

    @NotNull
    public final e12.e<EnterChannelState> l() {
        return this.enterTRTCRoomState;
    }

    public final void l0(@Nullable IGProPlayInfo iGProPlayInfo) {
        this.playInfo = iGProPlayInfo;
    }

    @NotNull
    /* renamed from: m, reason: from getter */
    public final ct1.a getFreeGiftInfo() {
        return this.freeGiftInfo;
    }

    @NotNull
    public final GuildGameCreateBean n() {
        GuildGameCreateBean guildGameCreateBean = this.gameCreateRoomInfo;
        if (guildGameCreateBean != null) {
            return guildGameCreateBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("gameCreateRoomInfo");
        return null;
    }

    @NotNull
    public final cm<com.tencent.mobileqq.qqgift.mvvm.business.anim.a> o() {
        return this.giftAnimData;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void p() {
        Integer num;
        e12.e<Integer> eVar = this.themeType;
        IGProGuildThemeInfo value = this.themeInfo.getValue();
        if (value != null) {
            num = Integer.valueOf(value.getThemeType());
        } else {
            num = null;
        }
        eVar.setValue(num);
    }

    @NotNull
    public final cm<MediaShareLoadInfo> q() {
        return this.mediaShareLoadInfo;
    }

    @NotNull
    public final Set<Long> r() {
        return this.muteToMeList;
    }

    @NotNull
    public final e12.a<Boolean> s() {
        return this.needShowInviteOpenMicMsg;
    }

    @NotNull
    public final cn<Boolean> t() {
        return this.needShowNavTips;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void u() {
        this.channelDataVersion = 0L;
        this.authMeta = "";
        this.roomSessionId = "";
        this.themeType.setValue(0);
        this.themeBizNodeList.setValue(null);
        this.enterChannelState.setValue(EnterChannelState.IDLE);
        this.screenShareInfo.setValue(null);
        this.tRTCUserInfoList.b();
        this.screenShareAnchorInfo.b();
        this.aioShowMsgSeq = -1L;
        this.playInfo = null;
        this.songInfo = null;
        this.playInfoDataVersion = -1L;
        this.playNum = -1;
        this.aioShowState = true;
        this.userNumDataVersion = 0L;
        this.themePanelLaunchTime = -1L;
        this.enterChannelParamsForTRTCRoom = new com.tencent.mobileqq.guild.media.core.logic.j(0, null, null, null, 0L, 0L, 0L, 127, null);
        e12.a<Boolean> aVar = this.isMicCaptureInactive;
        Boolean bool = Boolean.FALSE;
        aVar.setValue(bool);
        this.disableVoiceAnimation.setValue(bool);
        this.trtcRoomList.clear();
        this.totalUserInfoList.f228125a.clear();
        this.needShowNavTips.setValue(bool);
        this.needShowInviteOpenMicMsg.setValue(bool);
        this.selfHasOpenMic = false;
        this.freeGiftInfo.a();
        this.presentGiftMap.clear();
        this.mediaShareLoadInfo.setValue(null);
    }

    @Nullable
    /* renamed from: v, reason: from getter */
    public final IGProPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    /* renamed from: x, reason: from getter */
    public final int getPlayNum() {
        return this.playNum;
    }

    @NotNull
    public final ConcurrentHashMap<String, com.tencent.mobileqq.guild.media.core.data.p> z() {
        return this.presentGiftMap;
    }

    @Override // com.tencent.mobileqq.guild.media.core.g
    public void h0() {
    }
}
