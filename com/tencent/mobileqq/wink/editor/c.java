package com.tencent.mobileqq.wink.editor;

import android.support.annotation.DrawableRes;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContent;
import com.tencent.mobileqq.wink.editor.sticker.MetaMaterialContentWrapper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0018\u0002\n\u0003\b\u008c\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\f\u0010\u0006\u001a\u00020\u0005*\u00020\u0000H\u0007\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u001a\u0010\n\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\u001a\u001c\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001\u001a\u0012\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u001a\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0005\u001a\u001a\u0010\u0010\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u000f\u001a\u001a\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0011\u001a\u001a\u0010\u0014\u001a\u00020\u0013*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0013\u001a\n\u0010\u0015\u001a\u00020\u000f*\u00020\u0000\u001a\u001a\u0010\u0017\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0016\u001a\u001a\u0010\u0018\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000f\u001a\u001c\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0019\u001a\n\u0010\u001b\u001a\u00020\u000f*\u00020\u0000\u001a\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001a,\u0010\u001e\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u001d\u001a\u0012\u0010 \u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0001\u001a\u0012\u0010!\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0001\u001a\u0006\u0010\"\u001a\u00020\u0000\u001a.\u0010(\u001a\u00020\u00052\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010#2\u0006\u0010'\u001a\u00020\u0005\u001a\u000e\u0010*\u001a\u00020$2\u0006\u0010)\u001a\u00020$\u001a.\u0010,\u001a\u00020\u00052\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010#2\u0006\u0010+\u001a\u00020\u0005\u001a \u0010.\u001a\u00020\u00052\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010#2\b\u0010-\u001a\u0004\u0018\u00010\u0000\u001a\u001e\u00100\u001a\u00020\u00052\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010#2\u0006\u0010/\u001a\u00020\u0001\u001a\u001e\u00102\u001a\u00020\u00052\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020$\u0018\u00010#2\u0006\u00101\u001a\u00020\u0001\u001a\n\u00103\u001a\u00020$*\u00020$\"\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\"(\u0010<\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;\"(\u0010?\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b=\u00109\"\u0004\b>\u0010;\"4\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00010#*\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010#8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\"(\u0010G\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u00109\"\u0004\bF\u0010;\"(\u0010J\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bH\u00109\"\u0004\bI\u0010;\"(\u0010M\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bK\u00109\"\u0004\bL\u0010;\"(\u0010P\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bN\u00109\"\u0004\bO\u0010;\"(\u0010S\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bQ\u00109\"\u0004\bR\u0010;\"(\u0010V\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bT\u00109\"\u0004\bU\u0010;\"(\u0010Y\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bW\u00109\"\u0004\bX\u0010;\"(\u0010\\\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bZ\u00109\"\u0004\b[\u0010;\"(\u0010a\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`\"(\u0010d\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bb\u00109\"\u0004\bc\u0010;\"(\u0010g\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\be\u00109\"\u0004\bf\u0010;\"(\u0010j\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bh\u00109\"\u0004\bi\u0010;\"(\u0010m\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bk\u00109\"\u0004\bl\u0010;\"(\u0010s\u001a\u00020n*\u00020\u00002\u0006\u0010\u000b\u001a\u00020n8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bo\u0010p\"\u0004\bq\u0010r\"\u0015\u0010v\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\bt\u0010u\"(\u0010y\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bw\u00109\"\u0004\bx\u0010;\"(\u0010}\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bz\u0010u\"\u0004\b{\u0010|\")\u0010\u0080\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b~\u00109\"\u0004\b\u007f\u0010;\"\u0017\u0010\u0082\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u0081\u0001\u00109\"+\u0010\u0085\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0083\u0001\u00109\"\u0005\b\u0084\u0001\u0010;\"+\u0010\u0088\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0086\u0001\u00109\"\u0005\b\u0087\u0001\u0010;\"+\u0010\u008b\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0089\u0001\u00109\"\u0005\b\u008a\u0001\u0010;\"+\u0010\u008e\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008c\u0001\u00109\"\u0005\b\u008d\u0001\u0010;\"\u0017\u0010\u0090\u0001\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010^\"\u0017\u0010\u0092\u0001\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010^\"\u0017\u0010\u0094\u0001\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010^\"\u0017\u0010\u0096\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u0095\u0001\u00109\"*\u00101\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0097\u0001\u00109\"\u0005\b\u0098\u0001\u0010;\"+\u0010\u009b\u0001\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0099\u0001\u0010u\"\u0005\b\u009a\u0001\u0010|\"+\u0010\u009e\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009c\u0001\u00109\"\u0005\b\u009d\u0001\u0010;\"+\u0010\u00a1\u0001\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010u\"\u0005\b\u00a0\u0001\u0010|\"+\u0010\u00a4\u0001\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a2\u0001\u0010u\"\u0005\b\u00a3\u0001\u0010|\"+\u0010\u00a7\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a5\u0001\u00109\"\u0005\b\u00a6\u0001\u0010;\"+\u0010\u00aa\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00a8\u0001\u0010^\"\u0005\b\u00a9\u0001\u0010`\"+\u0010\u00ad\u0001\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ab\u0001\u0010u\"\u0005\b\u00ac\u0001\u0010|\"+\u0010\u00b0\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ae\u0001\u00109\"\u0005\b\u00af\u0001\u0010;\"+\u0010\u00b3\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b1\u0001\u0010^\"\u0005\b\u00b2\u0001\u0010`\"+\u0010\u00b6\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b4\u0001\u0010^\"\u0005\b\u00b5\u0001\u0010`\"+\u0010\u00b9\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00b7\u0001\u00109\"\u0005\b\u00b8\u0001\u0010;\"\u0017\u0010\u00bb\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00ba\u0001\u00109\"\u0017\u0010\u00bd\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00bc\u0001\u00109\"\u0017\u0010\u00bf\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00be\u0001\u00109\"+\u0010\u00c2\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c0\u0001\u00109\"\u0005\b\u00c1\u0001\u0010;\"+\u0010\u00c5\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c3\u0001\u00109\"\u0005\b\u00c4\u0001\u0010;\"+\u0010\u00c8\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c6\u0001\u00109\"\u0005\b\u00c7\u0001\u0010;\"+\u0010\u00cb\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00c9\u0001\u0010^\"\u0005\b\u00ca\u0001\u0010`\"+\u0010\u00ce\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00cc\u0001\u0010^\"\u0005\b\u00cd\u0001\u0010`\"+\u0010\u00d1\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00cf\u0001\u0010^\"\u0005\b\u00d0\u0001\u0010`\"+\u0010\u00d4\u0001\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00d2\u0001\u0010^\"\u0005\b\u00d3\u0001\u0010`\"\u0017\u0010\u00d6\u0001\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00d5\u0001\u0010u\"\u0017\u0010\u00d8\u0001\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00d7\u0001\u0010^\"\u0017\u0010\u00da\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00d9\u0001\u00109\"+\u0010\u00dd\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00db\u0001\u00109\"\u0005\b\u00dc\u0001\u0010;\"+\u0010\u00e0\u0001\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00de\u0001\u0010u\"\u0005\b\u00df\u0001\u0010|\"\u0017\u0010\u00e2\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00e1\u0001\u00109\"\u0017\u0010\u00e4\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00e3\u0001\u00109\"\u0017\u0010\u00e6\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00e5\u0001\u00109\"\u0017\u0010\u00e8\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00e7\u0001\u00109\"\u0017\u0010\u00ea\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00e9\u0001\u00109\"\u0017\u0010\u00ec\u0001\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00eb\u0001\u0010u\"\u0017\u0010\u00ee\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00ed\u0001\u00109\"+\u0010\u00f1\u0001\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00ef\u0001\u00109\"\u0005\b\u00f0\u0001\u0010;\"+\u0010\u00f4\u0001\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u000f8F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u00f2\u0001\u0010u\"\u0005\b\u00f3\u0001\u0010|\"\u0017\u0010\u00f6\u0001\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00f5\u0001\u0010u\"\u0017\u0010\u00f8\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00f7\u0001\u00109\"\u0017\u0010\u00fa\u0001\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00f9\u0001\u00109\"\u0019\u0010\u00fe\u0001\u001a\u00030\u00fb\u0001*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u00fc\u0001\u0010\u00fd\u0001\"\u001b\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u00ff\u0001*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u0080\u0002\u0010\u0081\u0002\"\u0017\u0010\u0084\u0002\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u0083\u0002\u0010u\"\u0018\u0010\u0087\u0002\u001a\u00020\u0013*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u0085\u0002\u0010\u0086\u0002\"\u0017\u0010\u0089\u0002\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u0088\u0002\u0010^\"+\u0010\u008c\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008a\u0002\u00109\"\u0005\b\u008b\u0002\u0010;\"+\u0010\u008f\u0002\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u008d\u0002\u00109\"\u0005\b\u008e\u0002\u0010;\"+\u0010\u0092\u0002\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00058F@FX\u0086\u000e\u00a2\u0006\u000e\u001a\u0005\b\u0090\u0002\u0010^\"\u0005\b\u0091\u0002\u0010`\"\u001a\u0010\u0095\u0002\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002\"\u001a\u0010\u0097\u0002\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u0096\u0002\u0010\u0094\u0002\"\u001a\u0010\u0099\u0002\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u0098\u0002\u0010\u0094\u0002\"\u001a\u0010\u009b\u0002\u001a\u0004\u0018\u00010\u0005*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u009a\u0002\u0010\u0094\u0002\"\u0017\u0010\u009d\u0002\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u009c\u0002\u00109\"\u0017\u0010\u009f\u0002\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u009e\u0002\u0010u\"\u0017\u0010\u00a1\u0002\u001a\u00020\u000f*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00a0\u0002\u0010u\"\u0017\u0010\u00a3\u0002\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00a2\u0002\u00109\"\u0017\u0010\u00a5\u0002\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00a4\u0002\u00109\"\u0017\u0010\u00a7\u0002\u001a\u00020\u0005*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00a6\u0002\u0010^\"\u001b\u0010\u00ab\u0002\u001a\u0005\u0018\u00010\u00a8\u0002*\u00020\u00008F\u00a2\u0006\b\u001a\u0006\b\u00a9\u0002\u0010\u00aa\u0002\"\u0017\u0010\u00ad\u0002\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0007\u001a\u0005\b\u00ac\u0002\u00109\u00a8\u0006\u00ae\u0002"}, d2 = {"Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "publishText", "", "E1", "", "J0", "key", "w0", "default", "v0", "value", "k1", "N", "M", "", DomainData.DOMAIN_NAME, "", "P", "", "B", "e1", "", "i1", "g1", "Ljava/io/Serializable;", "j1", "Y0", "c0", "", "h1", "fieldName", "W0", "l1", "f1", "", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "categories", "materials", "contentItemPosition", "f", "category", "c", "categoryItemPosition", "e", "targetMaterial", "g", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, tl.h.F, "categoryId", "d", "b", "Lcom/google/gson/Gson;", "a", "Lcom/google/gson/Gson;", "gson", "m0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/String;", "setScheme", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/lang/String;)V", ZPlanPublishSource.FROM_SCHEME, "B0", "setTagList", "tagList", "E0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/util/List;", "setTags", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Ljava/util/List;)V", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "j", "m1", "activity_hidden", "S0", "setVideoUrl", AppConstants.Key.KEY_QZONE_VIDEO_URL, "Z", "setMotionCoverUrl", "motionCoverUrl", "s0", "H1", "staticMotionCoverUrl", "O", "setLongDesc", "longDesc", "q0", "setShortDesc", "shortDesc", ExifInterface.LATITUDE_SOUTH, "setMaterialDescription", "materialDescription", "d0", "setOperationTag", "operationTag", "K", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)I", "y1", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;I)V", "index", "a0", "B1", "name", ReportConstant.COSTREPORT_PREFIX, "setDefaultIcon", "defaultIcon", "r", "setDarkIcon", "darkIcon", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "setMakeButtonTitle", "makeButtonTitle", "Lcom/tencent/mobileqq/wink/editor/MaterialType;", "T", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/MaterialType;", "z1", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Lcom/tencent/mobileqq/wink/editor/MaterialType;)V", "materialType", "b1", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Z", "isImageTemplate", BdhLogUtil.LogTag.Tag_Conn, "setForBusinessType", "forBusinessType", "u", "setDisplayDownloadIcon", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;Z)V", "displayDownloadIcon", "M0", "setTopic", "topic", "L0", "titleContent", "Y", "A1", "modeLoop", "y", "t1", "dynamicThumbUrl", "r0", "setSquareImg", "squareImg", "l0", "setRhythm", "rhythm", "W", "minFillCount", "l", "autoFillIntervalBegin", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "autoFillIntervalLength", "k", "autoFillConfig", "o", "o1", "o0", "F1", "sendToFeed", "p", "p1", "categoryName", "X0", ICustomDataEditor.NUMBER_PARAM_1, "isApplyLocal", "d1", Constants.APK_CERTIFICATE, "isSmallLoading", "g0", Constants.BASE_IN_PLUGIN_ID, "packagePath", HippyTKDListViewAdapter.X, ICustomDataEditor.STRING_PARAM_1, "downloadProgress", "w", "r1", "downloadFailed", "K0", "J1", "thumbText", "I0", "I1", "thumbBackground", "V", "setMediaTypeSelected", "mediaTypeSelected", "G0", "setTemplatePreprocessConfig", "templatePreprocessConfig", "k0", "resourceName", "D0", "tagUin", "C0", "tagTitle", "t0", "setStoryName", "storyName", "u0", "setStorySQL", "storySQL", "F0", "setTemplateID", "templateID", "U", "setMaxPhotoCnt", "maxPhotoCnt", "X", "setMinPhotoCnt", "minPhotoCnt", "i0", "setPriorityIndex", "priorityIndex", ICustomDataEditor.STRING_ARRAY_PARAM_1, "setFixedSegmentsTemplate", "isFixedSegmentsTemplate", "R0", "useTodayAsTriggerTime", "h0", "priority", "x0", "styleExhibitionImgUrl", "t", "q1", "defaultStyleId", "Q0", "K1", "useDefaultStyleId", "A0", "styleModelIdList", "p0", "shareInfo", "N0", "uploadPicSuggestInfo", "O0", "uploadPicSuggestInfoRefId", "j0", "pushImgUrl", "Z0", "isCoupleStyle", "y0", "styleID", "f0", "C1", "outputImageAspectRatio", "E", "u1", "hideInEditor", "D", "forceVerticalResultImage", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "firstCoverUrl", "n0", "secondCoverUrl", "Lcom/tencent/mobileqq/wink/editor/InputMediaType;", "L", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/InputMediaType;", "inputMediaType", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", "H0", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig;", "templatePreprocessConfigObj", "c1", "isPlaceHolder", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)F", "extractCoverFrame", "v", "displayType", "H", "v1", "imagePath", "J", "x1", "imageUrl", "I", "w1", NodeProps.CUSTOM_PROP_IMAGE_TYPE, "i", "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Ljava/lang/Integer;", "activityType", "T0", "yuhengActivityId", "V0", "yuhengTaskId", "U0", "yuhengRuleId", "G", "htmlUrl", "b0", "noTimeLimit", UserInfo.SEX_FEMALE, "hideUsageCount", "P0", "useBtnText", "z0", "styleModelId", "e0", "orderPriority", "Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle;", BdhLogUtil.LogTag.Tag_Req, "(Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;)Lcom/tencent/mobileqq/wink/editor/MateActivityUIStyle;", "mateActivityUIStyle", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, QCircleScheme.AttrQQPublish.CHALLENGE_TAG, "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Gson f319058a = new Gson();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/wink/editor/c$a", "Lcom/google/gson/reflect/TypeToken;", "", "", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a extends TypeToken<Map<String, ? extends Object>> {
        a() {
        }
    }

    @NotNull
    public static final String A(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "first_cover_url");
    }

    @NotNull
    public static final String A0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "style_model_id_list");
    }

    public static final void A1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "modeLoop", value);
    }

    public static final float B(@NotNull MetaMaterial metaMaterial, @NotNull String key, float f16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return f16;
        }
        String str = map.get(key);
        if (str == null) {
            return f16;
        }
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return f16;
        }
    }

    @NotNull
    public static final String B0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "tagList");
    }

    public static final void B1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "name", value);
    }

    @NotNull
    public static final String C(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "forBusinessType");
    }

    @NotNull
    public static final String C0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "tagTitle");
    }

    public static final void C1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "outputImageAspectRatio", value);
    }

    public static final boolean D(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return n(metaMaterial, "force_vertical_result_image", false);
    }

    @NotNull
    public static final String D0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "tagUin");
    }

    public static final void D1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "packagePath", value);
    }

    public static final boolean E(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return n(metaMaterial, "hideInEditor", false);
    }

    @NotNull
    public static final List<String> E0(@NotNull MetaMaterial metaMaterial) {
        List<String> split$default;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        split$default = StringsKt__StringsKt.split$default((CharSequence) w0(metaMaterial, "tag"), new String[]{"|"}, false, 0, 6, (Object) null);
        return split$default;
    }

    public static final void E1(@NotNull MetaMaterial metaMaterial, @NotNull String publishText) {
        boolean isBlank;
        MateActivityUIStyle a16;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(publishText, "publishText");
        String v06 = v0(metaMaterial, "activity_ui_style", "");
        isBlank = StringsKt__StringsJVMKt.isBlank(v06);
        if (isBlank) {
            a16 = null;
        } else {
            a16 = MateActivityUIStyle.Companion.a(v06);
        }
        if (a16 != null) {
            a16.setPublishBtnText(publishText);
            k1(metaMaterial, "activity_ui_style", a16.toJson());
        }
    }

    public static final boolean F(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (M(metaMaterial, "hideUsageCount", 0) != 1) {
            return false;
        }
        return true;
    }

    @NotNull
    public static final String F0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "templateID");
    }

    public static final void F1(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, "sendToFeed", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String G(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "HtmlUrl");
    }

    @NotNull
    public static final String G0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "templatePreprocessConfig");
    }

    public static final void G1(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, "isSmallLoading", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String H(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "imagePath");
    }

    @Nullable
    public static final TemplatePreProcessConfig H0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        try {
            return (TemplatePreProcessConfig) f319058a.fromJson(G0(metaMaterial), TemplatePreProcessConfig.class);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static final void H1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "staticMotionCoverUrl", value);
    }

    public static final int I(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, NodeProps.CUSTOM_PROP_IMAGE_TYPE, 0);
    }

    public static final int I0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "exThumbBackground", -1);
    }

    public static final void I1(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, "exThumbBackground", Integer.valueOf(i3));
    }

    @NotNull
    public static final String J(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "imageUrl");
    }

    @DrawableRes
    public static final int J0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (Intrinsics.areEqual("thumbNon", metaMaterial.thumbUrl)) {
            return R.drawable.os9;
        }
        return 0;
    }

    public static final void J1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "exThumbText", value);
    }

    public static final int K(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "exIndex", 0);
    }

    @NotNull
    public static final String K0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "exThumbText");
    }

    public static final void K1(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        g1(metaMaterial, "use_default_style_Id", z16);
    }

    @NotNull
    public static final InputMediaType L(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        String w06 = w0(metaMaterial, "input_media_type");
        InputMediaType inputMediaType = InputMediaType.ORIGIN;
        if (!Intrinsics.areEqual(w06, inputMediaType.getType())) {
            InputMediaType inputMediaType2 = InputMediaType.FACE_CROP;
            if (!Intrinsics.areEqual(w06, inputMediaType2.getType())) {
                return InputMediaType.COMPRESS;
            }
            return inputMediaType2;
        }
        return inputMediaType;
    }

    @NotNull
    public static final String L0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "titleContent");
    }

    public static final int M(@NotNull MetaMaterial metaMaterial, @NotNull String key, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return i3;
        }
        String str = map.get(key);
        if (str == null) {
            return i3;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return i3;
        }
    }

    @NotNull
    public static final String M0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "topic");
    }

    public static final int N(@NotNull MetaMaterial metaMaterial, @NotNull String key) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return M(metaMaterial, key, 0);
    }

    @NotNull
    public static final String N0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "upload_pic_suggest_info");
    }

    @NotNull
    public static final String O(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "longDesc");
    }

    @NotNull
    public static final String O0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "upload_pic_suggest_ref_id");
    }

    public static final long P(@NotNull MetaMaterial metaMaterial, @NotNull String key, long j3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return j3;
        }
        String str = map.get(key);
        if (str == null) {
            return j3;
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j3;
        }
    }

    @NotNull
    public static final String P0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "useBtnText");
    }

    @NotNull
    public static final String Q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "makeButtonTitle");
    }

    public static final boolean Q0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return n(metaMaterial, "use_default_style_Id", false);
    }

    @Nullable
    public static final MateActivityUIStyle R(@NotNull MetaMaterial metaMaterial) {
        boolean isBlank;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        String v06 = v0(metaMaterial, "activity_ui_style", "");
        isBlank = StringsKt__StringsJVMKt.isBlank(v06);
        if (isBlank) {
            return null;
        }
        return MateActivityUIStyle.Companion.a(v06);
    }

    public static final boolean R0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (N(metaMaterial, "useTodayAsTriggerTime") == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String S(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "materialDescription");
    }

    @NotNull
    public static final String S0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, AppConstants.Key.KEY_QZONE_VIDEO_URL);
    }

    @NotNull
    public static final MaterialType T(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        String w06 = w0(metaMaterial, "material_type");
        if (Intrinsics.areEqual(w06, "template")) {
            return MaterialType.TEMPLATE;
        }
        if (Intrinsics.areEqual(w06, "auto_template")) {
            return MaterialType.AUTO_TEMPLATE;
        }
        if (Intrinsics.areEqual(w06, "h5")) {
            return MaterialType.H5;
        }
        if (Intrinsics.areEqual(w06, "H5")) {
            return MaterialType.H5;
        }
        if (Intrinsics.areEqual(w06, "camera_motion")) {
            return MaterialType.CAMERA;
        }
        if (Intrinsics.areEqual(w06, "material_group")) {
            return MaterialType.MATERIAL_GROUP;
        }
        if (Intrinsics.areEqual(w06, "pag")) {
            return MaterialType.PAG;
        }
        MaterialType materialType = MaterialType.VIDEO;
        if (!Intrinsics.areEqual(w06, materialType.getType())) {
            materialType = MaterialType.IMAGE;
            if (!Intrinsics.areEqual(w06, materialType.getType())) {
                materialType = MaterialType.ONLINE_VIDEO_LIGHTSDK;
                if (!Intrinsics.areEqual(w06, materialType.getType())) {
                    materialType = MaterialType.OPEN_END_AIGC_TEMPLATE;
                    if (!Intrinsics.areEqual(w06, materialType.getType())) {
                        materialType = MaterialType.IMAGE_TEMPLATE;
                        if (!Intrinsics.areEqual(w06, materialType.getType())) {
                            return MaterialType.NULL;
                        }
                    }
                }
            }
        }
        return materialType;
    }

    @Nullable
    public static final Integer T0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        int M = M(metaMaterial, QQWinkConstants.KEY_MATE_YUHENG_ACTIVITY_ID, Integer.MAX_VALUE);
        if (M == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(M);
    }

    public static final int U(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return N(metaMaterial, "maxPhotoCnt");
    }

    @Nullable
    public static final Integer U0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        int M = M(metaMaterial, QQWinkConstants.KEY_MATE_YUHENG_RULE_ID, Integer.MAX_VALUE);
        if (M == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(M);
    }

    public static final int V(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "mediaTypeSelected", -1);
    }

    @Nullable
    public static final Integer V0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        int M = M(metaMaterial, QQWinkConstants.KEY_MATE_YUHENG_TASK_ID, Integer.MAX_VALUE);
        if (M == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(M);
    }

    public static final int W(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "minFillCount", -1);
    }

    public static final boolean W0(@NotNull MetaMaterial metaMaterial, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map != null && map.containsKey(fieldName)) {
            return true;
        }
        return false;
    }

    public static final int X(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return N(metaMaterial, "minPhotoCnt");
    }

    public static final boolean X0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (M(metaMaterial, "isApplyLocal", 1) == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String Y(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return v0(metaMaterial, "modeLoop", "none");
    }

    public static final boolean Y0(@NotNull MetaMaterial metaMaterial) {
        MetaMaterialContentWrapper metaMaterialContentWrapper;
        ArrayList<MetaMaterialContent> metaMaterialContent;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (metaMaterial.additionalObjectFields == null) {
            metaMaterial.additionalObjectFields = new HashMap();
        }
        if (metaMaterial.additionalObjectFields.get("contents") == null) {
            return false;
        }
        try {
            Serializable serializable = metaMaterial.additionalObjectFields.get("contents");
            if (serializable instanceof MetaMaterialContentWrapper) {
                metaMaterialContentWrapper = (MetaMaterialContentWrapper) serializable;
            } else {
                metaMaterialContentWrapper = null;
            }
            if (metaMaterialContentWrapper == null || (metaMaterialContent = metaMaterialContentWrapper.getMetaMaterialContent()) == null) {
                return false;
            }
            if (metaMaterialContent.size() != 2) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            ms.a.c("Metamaterial", "isBiliingual exception:" + e16);
            return false;
        }
    }

    @NotNull
    public static final String Z(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "motionCoverUrl");
    }

    public static final boolean Z0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (N(metaMaterial, "is_couple") == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String a0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "name");
    }

    public static final int a1(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return N(metaMaterial, "isFixedSegmentsTemplate");
    }

    @NotNull
    public static final MetaCategory b(@NotNull MetaCategory metaCategory) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(metaCategory, "<this>");
        String str = metaCategory.f30532id;
        String str2 = metaCategory.name;
        String str3 = metaCategory.thumbUrl;
        List list = metaCategory.subCategories;
        if (list == null) {
            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
            list = emptyList2;
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = metaCategory.materials;
        if (list2 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            list2 = emptyList;
        }
        ArrayList arrayList2 = new ArrayList(list2);
        Map<String, String> map = metaCategory.dynamicFields;
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        return new MetaCategory(str, str2, str3, arrayList, arrayList2, new HashMap(map));
    }

    public static final boolean b0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (N(metaMaterial, "NoTimeLimit") == 1) {
            return true;
        }
        return false;
    }

    public static final boolean b1(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (T(metaMaterial) == MaterialType.IMAGE_TEMPLATE) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final MetaCategory c(@NotNull MetaCategory category) {
        Intrinsics.checkNotNullParameter(category, "category");
        String str = category.f30532id;
        String str2 = category.name;
        String str3 = category.thumbUrl;
        ArrayList<MetaCategory> arrayList = category.subCategories;
        ArrayList<MetaMaterial> arrayList2 = category.materials;
        Map<String, String> map = category.dynamicFields;
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        return new MetaCategory(str, str2, str3, arrayList, arrayList2, new HashMap(map));
    }

    @Nullable
    public static final Serializable c0(@NotNull MetaMaterial metaMaterial, @NotNull String key) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (metaMaterial.additionalObjectFields == null) {
            metaMaterial.additionalObjectFields = new HashMap();
        }
        try {
            return metaMaterial.additionalObjectFields.get(key);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final boolean c1(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (!Intrinsics.areEqual(metaMaterial.f30533id, "ID_PLACEHOLDER") && !Intrinsics.areEqual(a0(metaMaterial), "ID_PLACEHOLDER")) {
            return false;
        }
        return true;
    }

    public static final int d(@Nullable List<MetaCategory> list, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        if (list == null) {
            return -1;
        }
        Iterator<MetaCategory> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().f30532id, categoryId)) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @NotNull
    public static final String d0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "operationTag");
    }

    public static final boolean d1(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (M(metaMaterial, "isSmallLoading", 1) == 1) {
            return true;
        }
        return false;
    }

    public static final int e(@Nullable List<MetaCategory> list, @Nullable List<MetaMaterial> list2, int i3) {
        if (list != null && list2 != null && list.size() >= i3) {
            MetaCategory metaCategory = list.get(i3);
            int size = list2.size();
            for (int i16 = 0; i16 < size; i16++) {
                if (Intrinsics.areEqual(metaCategory.f30532id, o(list2.get(i16)))) {
                    return i16;
                }
            }
        }
        return 0;
    }

    public static final int e0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "orderPriority", Integer.MAX_VALUE);
    }

    public static final boolean e1(@NotNull MetaMaterial metaMaterial) {
        String str;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null || (str = map.get(QQWinkConstants.ZSHOW_MATERIAL_SCENE_KEY)) == null) {
            str = "";
        }
        return Intrinsics.areEqual(str, QQWinkConstants.BUSINESS_ZSHOW_NAME);
    }

    public static final int f(@Nullable List<MetaCategory> list, @Nullable List<MetaMaterial> list2, int i3) {
        if (list != null && list2 != null && list2.size() > i3 && i3 >= 0) {
            String o16 = o(list2.get(i3));
            int size = list.size();
            for (int i16 = 0; i16 < size; i16++) {
                if (Intrinsics.areEqual(o16, list.get(i16).f30532id)) {
                    return i16;
                }
            }
        }
        return 0;
    }

    @NotNull
    public static final String f0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "outputImageAspectRatio");
    }

    @NotNull
    public static final MetaMaterial f1() {
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "ID_PLACEHOLDER";
        B1(metaMaterial, "ID_PLACEHOLDER");
        return metaMaterial;
    }

    public static final int g(@Nullable List<MetaMaterial> list, @Nullable MetaMaterial metaMaterial) {
        if (list != null && metaMaterial != null) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                if (Intrinsics.areEqual(list.get(i3).f30533id, metaMaterial.f30533id) && Intrinsics.areEqual(o(list.get(i3)), o(metaMaterial))) {
                    return i3;
                }
            }
        }
        return -1;
    }

    @NotNull
    public static final String g0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "packagePath");
    }

    public static final void g1(@NotNull MetaMaterial metaMaterial, @NotNull String key, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (metaMaterial.additionalFields == null) {
            metaMaterial.additionalFields = new HashMap();
        }
        try {
            Map<String, String> map = metaMaterial.additionalFields;
            Intrinsics.checkNotNullExpressionValue(map, "this.additionalFields");
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            map.put(key, str);
        } catch (Exception unused) {
        }
    }

    public static final int h(@Nullable List<MetaMaterial> list, @NotNull String materialId) {
        Intrinsics.checkNotNullParameter(materialId, "materialId");
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (Intrinsics.areEqual(list.get(i3).f30533id, materialId)) {
                return i3;
            }
        }
        return -1;
    }

    public static final int h0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return N(metaMaterial, "priority");
    }

    public static final void h1(@NotNull MetaMaterial metaMaterial, @Nullable String str, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (metaMaterial.additionalFields == null) {
            metaMaterial.additionalFields = new HashMap();
        }
        try {
            Map<String, String> map2 = metaMaterial.additionalFields;
            Intrinsics.checkNotNullExpressionValue(map2, "this.additionalFields");
            map2.put(str, f319058a.toJson(map, new a().getType()));
        } catch (JsonSyntaxException unused) {
        }
    }

    @Nullable
    public static final Integer i(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        int M = M(metaMaterial, "activity_type", Integer.MAX_VALUE);
        if (M == Integer.MAX_VALUE) {
            return null;
        }
        return Integer.valueOf(M);
    }

    public static final int i0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return N(metaMaterial, "priorityIndex");
    }

    public static final void i1(@NotNull MetaMaterial metaMaterial, @NotNull String key, @NotNull Number value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (metaMaterial.additionalFields == null) {
            metaMaterial.additionalFields = new HashMap();
        }
        try {
            Map<String, String> map = metaMaterial.additionalFields;
            Intrinsics.checkNotNullExpressionValue(map, "this.additionalFields");
            map.put(key, value.toString());
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String j(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "activity_hidden");
    }

    @NotNull
    public static final String j0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "push_img_url");
    }

    public static final void j1(@NotNull MetaMaterial metaMaterial, @NotNull String key, @Nullable Serializable serializable) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (metaMaterial.additionalObjectFields == null) {
            metaMaterial.additionalObjectFields = new HashMap();
        }
        try {
            Map<String, Serializable> map = metaMaterial.additionalObjectFields;
            Intrinsics.checkNotNullExpressionValue(map, "this.additionalObjectFields");
            map.put(key, serializable);
        } catch (Exception unused) {
        }
    }

    @NotNull
    public static final String k(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return v0(metaMaterial, "autoFillConfig", "video");
    }

    @NotNull
    public static final String k0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "resourceName");
    }

    public static final void k1(@NotNull MetaMaterial metaMaterial, @NotNull String key, @Nullable String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (metaMaterial.additionalFields == null) {
            metaMaterial.additionalFields = new HashMap();
        }
        Map<String, String> map = metaMaterial.additionalFields;
        Intrinsics.checkNotNullExpressionValue(map, "this.additionalFields");
        map.put(key, str);
    }

    public static final int l(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "autoFillIntervalBegin", -1);
    }

    @NotNull
    public static final String l0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "rhythm");
    }

    public static final void l1(@NotNull MetaMaterial metaMaterial, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map != null) {
            map.remove(fieldName);
        }
    }

    public static final int m(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "autoFillIntervalLength", -1);
    }

    @NotNull
    public static final String m0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, ZPlanPublishSource.FROM_SCHEME);
    }

    public static final void m1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "activity_hidden", value);
    }

    public static final boolean n(@NotNull MetaMaterial metaMaterial, @NotNull String key, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null) {
            return z16;
        }
        String str = map.get(key);
        if (str == null) {
            return z16;
        }
        try {
            return Intrinsics.areEqual(str, "1");
        } catch (Exception unused) {
            return z16;
        }
    }

    @NotNull
    public static final String n0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "second_cover_url");
    }

    public static final void n1(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, "isApplyLocal", Integer.valueOf(z16 ? 1 : 0));
    }

    @NotNull
    public static final String o(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "categoryId");
    }

    public static final boolean o0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (M(metaMaterial, "sendToFeed", 1) == 1) {
            return true;
        }
        return false;
    }

    public static final void o1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "categoryId", value);
    }

    @NotNull
    public static final String p(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "categoryName");
    }

    @NotNull
    public static final String p0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "share_info");
    }

    public static final void p1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "categoryName", value);
    }

    @NotNull
    public static final String q(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, QCircleScheme.AttrQQPublish.CHALLENGE_TAG);
    }

    @NotNull
    public static final String q0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "shortDesc");
    }

    public static final void q1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "default_style_id", value);
    }

    @NotNull
    public static final String r(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "darkIcon");
    }

    @NotNull
    public static final String r0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "squareImg");
    }

    public static final void r1(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        g1(metaMaterial, "downloadFailed", z16);
    }

    @NotNull
    public static final String s(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "defaultIcon");
    }

    @NotNull
    public static final String s0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "staticMotionCoverUrl");
    }

    public static final void s1(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, "downloadProgress", Integer.valueOf(Math.min(i3, 100)));
    }

    @NotNull
    public static final String t(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "default_style_id");
    }

    @NotNull
    public static final String t0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "storyName");
    }

    public static final void t1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "motionCoverUrl", value);
    }

    public static final boolean u(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        if (N(metaMaterial, "displayDownloadIcon") == 1) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String u0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "storySQL");
    }

    public static final void u1(@NotNull MetaMaterial metaMaterial, boolean z16) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        g1(metaMaterial, "hideInEditor", z16);
    }

    public static final int v(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "displayType", 0);
    }

    @NotNull
    public static final String v0(@NotNull MetaMaterial metaMaterial, @NotNull String key, @NotNull String str) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(str, "default");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map != null) {
            String str2 = map.get(key);
            if (str2 == null) {
                return str;
            }
            return str2;
        }
        return str;
    }

    public static final void v1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "imagePath", value);
    }

    public static final boolean w(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return n(metaMaterial, "downloadFailed", false);
    }

    @NotNull
    public static final String w0(@NotNull MetaMaterial metaMaterial, @NotNull String key) {
        String str;
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Map<String, String> map = metaMaterial.additionalFields;
        if (map == null || (str = map.get(key)) == null) {
            return "";
        }
        return str;
    }

    public static final void w1(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, NodeProps.CUSTOM_PROP_IMAGE_TYPE, Integer.valueOf(i3));
    }

    public static final int x(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return M(metaMaterial, "downloadProgress", -1);
    }

    @NotNull
    public static final String x0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "style_exhibition_img_url");
    }

    public static final void x1(@NotNull MetaMaterial metaMaterial, @NotNull String value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "imageUrl", value);
    }

    @NotNull
    public static final String y(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "motionCoverUrl");
    }

    @NotNull
    public static final String y0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "style_id");
    }

    public static final void y1(@NotNull MetaMaterial metaMaterial, int i3) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        i1(metaMaterial, "exIndex", Integer.valueOf(i3));
    }

    public static final float z(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return B(metaMaterial, "extractCoverFrame", 1.0f);
    }

    @NotNull
    public static final String z0(@NotNull MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        return w0(metaMaterial, "style_model_id");
    }

    public static final void z1(@NotNull MetaMaterial metaMaterial, @NotNull MaterialType value) {
        Intrinsics.checkNotNullParameter(metaMaterial, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        k1(metaMaterial, "material_type", value.getType());
    }
}
