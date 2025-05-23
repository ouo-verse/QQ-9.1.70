package com.tencent.mobileqq.wink.editor.draft;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.qphone.base.BaseConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.WatermarkConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u0000\n\u0002\bq\b\u0086\b\u0018\u0000 \u00de\u00012\u00020\u0001:\u0002\u00df\u0001B\u00ab\u0004\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004\u0012\u0018\b\u0002\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u001c\b\u0002\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t\u0012\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010F\u001a\u00020\u0010\u0012\u0006\u0010G\u001a\u00020\u0012\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010I\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010J\u001a\u00020\u0012\u0012\b\b\u0002\u0010K\u001a\u00020\u0004\u0012\b\b\u0002\u0010L\u001a\u00020\u0018\u0012\b\b\u0002\u0010M\u001a\u00020\u0018\u0012\b\b\u0002\u0010N\u001a\u00020\u001b\u0012\b\b\u0002\u0010O\u001a\u00020\u0012\u0012\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e\u0012\b\b\u0002\u0010Q\u001a\u00020\u0002\u0012\b\b\u0002\u0010R\u001a\u00020\u0012\u0012\b\b\u0002\u0010S\u001a\u00020\u0010\u0012\b\u0010T\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010U\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010V\u001a\u00020\u0012\u0012\b\b\u0002\u0010W\u001a\u00020\u0010\u0012\b\b\u0002\u0010X\u001a\u00020\u0012\u0012\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*\u0012\b\b\u0002\u0010Z\u001a\u00020\u0012\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\\\u001a\u00020\u0012\u0012\u0018\b\u0002\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\t\u0012\b\b\u0002\u0010^\u001a\u00020\u0004\u0012\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010`\u001a\u00020\u0012\u0012\b\b\u0002\u0010a\u001a\u00020\u0012\u0012\u0016\b\u0002\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e\u0012\b\b\u0002\u0010c\u001a\u00020\u0012\u0012\b\b\u0002\u0010d\u001a\u00020\u0012\u0012\b\b\u0002\u0010e\u001a\u00020\u0012\u0012\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010i\u001a\u0004\u0018\u00010<\u0012\b\b\u0002\u0010j\u001a\u00020\u0012\u00a2\u0006\u0006\b\u00dc\u0001\u0010\u00dd\u0001J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tH\u00c6\u0003J\u001d\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\tH\u00c6\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u000e\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u00c6\u0003J\t\u0010\u0011\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b\u0015\u0010\u0006J\t\u0010\u0016\u001a\u00020\u0012H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0018H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0018H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u001bH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0012H\u00c6\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u00c6\u0003J\t\u0010!\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0012H\u00c6\u0003J\t\u0010#\u001a\u00020\u0010H\u00c6\u0003J\u0012\u0010$\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003\u00a2\u0006\u0004\b$\u0010%J\u000b\u0010&\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010'\u001a\u00020\u0012H\u00c6\u0003J\t\u0010(\u001a\u00020\u0010H\u00c6\u0003J\t\u0010)\u001a\u00020\u0012H\u00c6\u0003J\u0011\u0010,\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u00c6\u0003J\t\u0010-\u001a\u00020\u0012H\u00c6\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u0010/\u001a\u00020\u0012H\u00c6\u0003J\u0019\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\tH\u00c6\u0003J\t\u00101\u001a\u00020\u0004H\u00c6\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\t\u00103\u001a\u00020\u0012H\u00c6\u0003J\t\u00104\u001a\u00020\u0012H\u00c6\u0003J\u0017\u00105\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001eH\u00c6\u0003J\t\u00106\u001a\u00020\u0012H\u00c6\u0003J\t\u00107\u001a\u00020\u0012H\u00c6\u0003J\t\u00108\u001a\u00020\u0012H\u00c6\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0002H\u00c6\u0003J\u0012\u0010;\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003\u00a2\u0006\u0004\b;\u0010\u0006J\u000b\u0010=\u001a\u0004\u0018\u00010<H\u00c6\u0003J\t\u0010>\u001a\u00020\u0012H\u00c6\u0003J\u00be\u0004\u0010k\u001a\u00020\u00002\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u00042\u0018\b\u0002\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t2\u001c\b\u0002\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010F\u001a\u00020\u00102\b\b\u0002\u0010G\u001a\u00020\u00122\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010J\u001a\u00020\u00122\b\b\u0002\u0010K\u001a\u00020\u00042\b\b\u0002\u0010L\u001a\u00020\u00182\b\b\u0002\u0010M\u001a\u00020\u00182\b\b\u0002\u0010N\u001a\u00020\u001b2\b\b\u0002\u0010O\u001a\u00020\u00122\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\b\b\u0002\u0010Q\u001a\u00020\u00022\b\b\u0002\u0010R\u001a\u00020\u00122\b\b\u0002\u0010S\u001a\u00020\u00102\n\b\u0002\u0010T\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010U\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010V\u001a\u00020\u00122\b\b\u0002\u0010W\u001a\u00020\u00102\b\b\u0002\u0010X\u001a\u00020\u00122\u0010\b\u0002\u0010Y\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*2\b\b\u0002\u0010Z\u001a\u00020\u00122\n\b\u0002\u0010[\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\\\u001a\u00020\u00122\u0018\b\u0002\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\t2\b\b\u0002\u0010^\u001a\u00020\u00042\n\b\u0002\u0010_\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010`\u001a\u00020\u00122\b\b\u0002\u0010a\u001a\u00020\u00122\u0016\b\u0002\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e2\b\b\u0002\u0010c\u001a\u00020\u00122\b\b\u0002\u0010d\u001a\u00020\u00122\b\b\u0002\u0010e\u001a\u00020\u00122\n\b\u0002\u0010f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010g\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010h\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010i\u001a\u0004\u0018\u00010<2\b\b\u0002\u0010j\u001a\u00020\u0012H\u00c6\u0001\u00a2\u0006\u0004\bk\u0010lJ\t\u0010m\u001a\u00020\u0002H\u00d6\u0001J\t\u0010n\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010q\u001a\u00020\u00122\b\u0010p\u001a\u0004\u0018\u00010oH\u00d6\u0003R\u0019\u0010?\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b?\u0010r\u001a\u0004\bs\u0010tR$\u0010@\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010u\u001a\u0004\bv\u0010\u0006\"\u0004\bw\u0010xR'\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t8\u0006\u00a2\u0006\f\n\u0004\bA\u0010y\u001a\u0004\bz\u0010{R+\u0010B\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\t8\u0006\u00a2\u0006\f\n\u0004\bB\u0010y\u001a\u0004\b|\u0010{R$\u0010C\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010r\u001a\u0004\b}\u0010t\"\u0004\b~\u0010\u007fR&\u0010D\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bD\u0010u\u001a\u0005\b\u0080\u0001\u0010\u0006\"\u0005\b\u0081\u0001\u0010xR)\u0010E\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bE\u0010\u0082\u0001\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001\"\u0006\b\u0085\u0001\u0010\u0086\u0001R'\u0010F\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bF\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R&\u0010G\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bG\u0010\u008c\u0001\u001a\u0005\bG\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R&\u0010H\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bH\u0010r\u001a\u0005\b\u0090\u0001\u0010t\"\u0005\b\u0091\u0001\u0010\u007fR&\u0010I\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bI\u0010u\u001a\u0005\b\u0092\u0001\u0010\u0006\"\u0005\b\u0093\u0001\u0010xR&\u0010J\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bJ\u0010\u008c\u0001\u001a\u0005\bJ\u0010\u008d\u0001\"\u0006\b\u0094\u0001\u0010\u008f\u0001R'\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bK\u0010\u0095\u0001\u001a\u0006\b\u0096\u0001\u0010\u0097\u0001\"\u0006\b\u0098\u0001\u0010\u0099\u0001R'\u0010L\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bL\u0010\u009a\u0001\u001a\u0006\b\u009b\u0001\u0010\u009c\u0001\"\u0006\b\u009d\u0001\u0010\u009e\u0001R'\u0010M\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bM\u0010\u009a\u0001\u001a\u0006\b\u009f\u0001\u0010\u009c\u0001\"\u0006\b\u00a0\u0001\u0010\u009e\u0001R'\u0010N\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bN\u0010\u00a1\u0001\u001a\u0006\b\u00a2\u0001\u0010\u00a3\u0001\"\u0006\b\u00a4\u0001\u0010\u00a5\u0001R&\u0010O\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bO\u0010\u008c\u0001\u001a\u0005\bO\u0010\u008d\u0001\"\u0006\b\u00a6\u0001\u0010\u008f\u0001R(\u0010P\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e8\u0006\u00a2\u0006\u000f\n\u0005\bP\u0010\u00a7\u0001\u001a\u0006\b\u00a8\u0001\u0010\u00a9\u0001R$\u0010Q\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bQ\u0010r\u001a\u0005\b\u00aa\u0001\u0010t\"\u0005\b\u00ab\u0001\u0010\u007fR&\u0010R\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bR\u0010\u008c\u0001\u001a\u0005\bR\u0010\u008d\u0001\"\u0006\b\u00ac\u0001\u0010\u008f\u0001R'\u0010S\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bS\u0010\u0087\u0001\u001a\u0006\b\u00ad\u0001\u0010\u0089\u0001\"\u0006\b\u00ae\u0001\u0010\u008b\u0001R(\u0010T\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bT\u0010\u00af\u0001\u001a\u0005\b\u00b0\u0001\u0010%\"\u0006\b\u00b1\u0001\u0010\u00b2\u0001R&\u0010U\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bU\u0010r\u001a\u0005\b\u00b3\u0001\u0010t\"\u0005\b\u00b4\u0001\u0010\u007fR&\u0010V\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bV\u0010\u008c\u0001\u001a\u0005\bV\u0010\u008d\u0001\"\u0006\b\u00b5\u0001\u0010\u008f\u0001R'\u0010W\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bW\u0010\u0087\u0001\u001a\u0006\b\u00b6\u0001\u0010\u0089\u0001\"\u0006\b\u00b7\u0001\u0010\u008b\u0001R&\u0010X\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bX\u0010\u008c\u0001\u001a\u0005\bX\u0010\u008d\u0001\"\u0006\b\u00b8\u0001\u0010\u008f\u0001R/\u0010Y\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bY\u0010\u00b9\u0001\u001a\u0006\b\u00ba\u0001\u0010\u00bb\u0001\"\u0006\b\u00bc\u0001\u0010\u00bd\u0001R&\u0010Z\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bZ\u0010\u008c\u0001\u001a\u0005\bZ\u0010\u008d\u0001\"\u0006\b\u00be\u0001\u0010\u008f\u0001R&\u0010[\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b[\u0010r\u001a\u0005\b\u00bf\u0001\u0010t\"\u0005\b\u00c0\u0001\u0010\u007fR&\u0010\\\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\\\u0010\u008c\u0001\u001a\u0005\b\\\u0010\u008d\u0001\"\u0006\b\u00c1\u0001\u0010\u008f\u0001R5\u0010]\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0007j\b\u0012\u0004\u0012\u00020\u0002`\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b]\u0010y\u001a\u0005\b\u00c2\u0001\u0010{\"\u0006\b\u00c3\u0001\u0010\u00c4\u0001R'\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b^\u0010\u0095\u0001\u001a\u0006\b\u00c5\u0001\u0010\u0097\u0001\"\u0006\b\u00c6\u0001\u0010\u0099\u0001R&\u0010_\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b_\u0010r\u001a\u0005\b\u00c7\u0001\u0010t\"\u0005\b\u00c8\u0001\u0010\u007fR'\u0010`\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b`\u0010\u008c\u0001\u001a\u0006\b\u00c9\u0001\u0010\u008d\u0001\"\u0006\b\u00ca\u0001\u0010\u008f\u0001R&\u0010a\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\ba\u0010\u008c\u0001\u001a\u0005\ba\u0010\u008d\u0001\"\u0006\b\u00cb\u0001\u0010\u008f\u0001R5\u0010b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bb\u0010\u00a7\u0001\u001a\u0006\b\u00cc\u0001\u0010\u00a9\u0001\"\u0006\b\u00cd\u0001\u0010\u00ce\u0001R&\u0010c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bc\u0010\u008c\u0001\u001a\u0005\bc\u0010\u008d\u0001\"\u0006\b\u00cf\u0001\u0010\u008f\u0001R\u0019\u0010d\u001a\u00020\u00128\u0006\u00a2\u0006\u000e\n\u0005\bd\u0010\u008c\u0001\u001a\u0005\bd\u0010\u008d\u0001R\u0019\u0010e\u001a\u00020\u00128\u0006\u00a2\u0006\u000e\n\u0005\be\u0010\u008c\u0001\u001a\u0005\be\u0010\u008d\u0001R&\u0010f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bf\u0010r\u001a\u0005\b\u00d0\u0001\u0010t\"\u0005\b\u00d1\u0001\u0010\u007fR&\u0010g\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bg\u0010r\u001a\u0005\b\u00d2\u0001\u0010t\"\u0005\b\u00d3\u0001\u0010\u007fR&\u0010h\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bh\u0010u\u001a\u0005\b\u00d4\u0001\u0010\u0006\"\u0005\b\u00d5\u0001\u0010xR)\u0010i\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bi\u0010\u00d6\u0001\u001a\u0006\b\u00d7\u0001\u0010\u00d8\u0001\"\u0006\b\u00d9\u0001\u0010\u00da\u0001R&\u0010j\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bj\u0010\u008c\u0001\u001a\u0005\bj\u0010\u008d\u0001\"\u0006\b\u00db\u0001\u0010\u008f\u0001\u00a8\u0006\u00e0\u0001"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "Ljava/io/Serializable;", "", "component1", "", "component2", "()Ljava/lang/Integer;", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Lkotlin/collections/ArrayList;", "component3", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "component4", "component5", "component6", "component7", "", "component8", "", "component9", "component10", "component11", "component12", "component13", "", "component14", "component15", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "component16", "component17", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "component18", "component19", "component20", "component21", "component22", "()Ljava/lang/Long;", "component23", "component24", "component25", "component26", "", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "component27", "component28", "component29", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component40", "component41", "component42", "Lorg/light/WatermarkConfig;", "component43", "component44", "missionId", "editMode", "editDatas", "originMediaInfos", "templateFilePath", "from", "outMediaInfo", "duration", "isFromCapture", "selectMusicMid", "selectMusicStart", "isBackGroundChanged", "useHD", "originVolume", "bgmVolume", "bgmVolumeType", "isSmartClipActive", "uiDataMap", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "isEnableSwitchEditMode", "preferredCoverTime", "musicId", "musicName", "isEnableMusic", "specifyCoverTs", "isFirstTemplate", "holderInfo", "isFromQzoneText", "textQzoneText", "isFromTemplateColl", "backgroundMaterialList", "backgroundMaterialIndex", "captureMaterialId", "enableImageTransition", "isHDRExporting", BaseConstants.ATTR_KET_EXTRA_MAP, "isAutoTemplate", "isFromMemoryAlbum", "isFromQzoneDailySign", "captureMaterialName", "musicPath", "musicDuration", "watermarkConfig", "isFromTemplateLib", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;JZLjava/lang/String;Ljava/lang/Integer;ZIFFLcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;ZLjava/util/Map;Ljava/lang/String;ZJLjava/lang/Long;Ljava/lang/String;ZJZLjava/util/List;ZLjava/lang/String;ZLjava/util/ArrayList;ILjava/lang/String;ZZLjava/util/Map;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/light/WatermarkConfig;Z)Lcom/tencent/mobileqq/wink/editor/draft/WinkEditDataWrapper;", "toString", "hashCode", "", "other", "equals", "Ljava/lang/String;", "getMissionId", "()Ljava/lang/String;", "Ljava/lang/Integer;", "getEditMode", "setEditMode", "(Ljava/lang/Integer;)V", "Ljava/util/ArrayList;", "getEditDatas", "()Ljava/util/ArrayList;", "getOriginMediaInfos", "getTemplateFilePath", "setTemplateFilePath", "(Ljava/lang/String;)V", "getFrom", "setFrom", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "getOutMediaInfo", "()Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "setOutMediaInfo", "(Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;)V", "J", "getDuration", "()J", "setDuration", "(J)V", "Z", "()Z", "setFromCapture", "(Z)V", "getSelectMusicMid", "setSelectMusicMid", "getSelectMusicStart", "setSelectMusicStart", "setBackGroundChanged", "I", "getUseHD", "()I", "setUseHD", "(I)V", UserInfo.SEX_FEMALE, "getOriginVolume", "()F", "setOriginVolume", "(F)V", "getBgmVolume", "setBgmVolume", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "getBgmVolumeType", "()Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;", "setBgmVolumeType", "(Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;)V", "setSmartClipActive", "Ljava/util/Map;", "getUiDataMap", "()Ljava/util/Map;", "getBusinessName", "setBusinessName", "setEnableSwitchEditMode", "getPreferredCoverTime", "setPreferredCoverTime", "Ljava/lang/Long;", "getMusicId", "setMusicId", "(Ljava/lang/Long;)V", "getMusicName", "setMusicName", "setEnableMusic", "getSpecifyCoverTs", "setSpecifyCoverTs", "setFirstTemplate", "Ljava/util/List;", "getHolderInfo", "()Ljava/util/List;", "setHolderInfo", "(Ljava/util/List;)V", "setFromQzoneText", "getTextQzoneText", "setTextQzoneText", "setFromTemplateColl", "getBackgroundMaterialList", "setBackgroundMaterialList", "(Ljava/util/ArrayList;)V", "getBackgroundMaterialIndex", "setBackgroundMaterialIndex", "getCaptureMaterialId", "setCaptureMaterialId", "getEnableImageTransition", "setEnableImageTransition", "setHDRExporting", "getExtraMap", "setExtraMap", "(Ljava/util/Map;)V", "setAutoTemplate", "getCaptureMaterialName", "setCaptureMaterialName", "getMusicPath", "setMusicPath", "getMusicDuration", "setMusicDuration", "Lorg/light/WatermarkConfig;", "getWatermarkConfig", "()Lorg/light/WatermarkConfig;", "setWatermarkConfig", "(Lorg/light/WatermarkConfig;)V", "setFromTemplateLib", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/Integer;Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;JZLjava/lang/String;Ljava/lang/Integer;ZIFFLcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel$VolumeType;ZLjava/util/Map;Ljava/lang/String;ZJLjava/lang/Long;Ljava/lang/String;ZJZLjava/util/List;ZLjava/lang/String;ZLjava/util/ArrayList;ILjava/lang/String;ZZLjava/util/Map;ZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lorg/light/WatermarkConfig;Z)V", "Companion", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final /* data */ class WinkEditDataWrapper implements Serializable {
    private static final long serialVersionUID = 599093938747237759L;
    private int backgroundMaterialIndex;

    @NotNull
    private ArrayList<String> backgroundMaterialList;
    private float bgmVolume;

    @NotNull
    private MusicVolumeControlViewModel.VolumeType bgmVolumeType;

    @NotNull
    private String businessName;

    @Nullable
    private String captureMaterialId;

    @Nullable
    private String captureMaterialName;
    private long duration;

    @NotNull
    private final ArrayList<WinkEditData> editDatas;

    @Nullable
    private Integer editMode;
    private boolean enableImageTransition;

    @Nullable
    private Map<String, String> extraMap;

    @Nullable
    private Integer from;

    @Nullable
    private List<TemplateLibraryHolderInfo> holderInfo;
    private boolean isAutoTemplate;
    private boolean isBackGroundChanged;
    private boolean isEnableMusic;
    private boolean isEnableSwitchEditMode;
    private boolean isFirstTemplate;
    private boolean isFromCapture;
    private final boolean isFromMemoryAlbum;
    private final boolean isFromQzoneDailySign;
    private boolean isFromQzoneText;
    private boolean isFromTemplateColl;
    private boolean isFromTemplateLib;
    private boolean isHDRExporting;
    private boolean isSmartClipActive;

    @Nullable
    private final String missionId;

    @Nullable
    private Integer musicDuration;

    @Nullable
    private Long musicId;

    @Nullable
    private String musicName;

    @Nullable
    private String musicPath;

    @Nullable
    private final ArrayList<LocalMediaInfo> originMediaInfos;
    private float originVolume;

    @Nullable
    private LocalMediaInfo outMediaInfo;
    private long preferredCoverTime;

    @Nullable
    private String selectMusicMid;

    @Nullable
    private Integer selectMusicStart;
    private long specifyCoverTs;

    @Nullable
    private String templateFilePath;

    @Nullable
    private String textQzoneText;

    @Nullable
    private final Map<String, WinkEditUIData> uiDataMap;
    private int useHD;

    @Nullable
    private WatermarkConfig watermarkConfig;

    public WinkEditDataWrapper(@Nullable String str, @Nullable Integer num, @NotNull ArrayList<WinkEditData> editDatas, @Nullable ArrayList<LocalMediaInfo> arrayList, @Nullable String str2, @Nullable Integer num2, @Nullable LocalMediaInfo localMediaInfo, long j3, boolean z16, @Nullable String str3, @Nullable Integer num3, boolean z17, int i3, float f16, float f17, @NotNull MusicVolumeControlViewModel.VolumeType bgmVolumeType, boolean z18, @Nullable Map<String, WinkEditUIData> map, @NotNull String businessName, boolean z19, long j16, @Nullable Long l3, @Nullable String str4, boolean z26, long j17, boolean z27, @Nullable List<TemplateLibraryHolderInfo> list, boolean z28, @Nullable String str5, boolean z29, @NotNull ArrayList<String> backgroundMaterialList, int i16, @Nullable String str6, boolean z36, boolean z37, @Nullable Map<String, String> map2, boolean z38, boolean z39, boolean z46, @Nullable String str7, @Nullable String str8, @Nullable Integer num4, @Nullable WatermarkConfig watermarkConfig, boolean z47) {
        Intrinsics.checkNotNullParameter(editDatas, "editDatas");
        Intrinsics.checkNotNullParameter(bgmVolumeType, "bgmVolumeType");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(backgroundMaterialList, "backgroundMaterialList");
        this.missionId = str;
        this.editMode = num;
        this.editDatas = editDatas;
        this.originMediaInfos = arrayList;
        this.templateFilePath = str2;
        this.from = num2;
        this.outMediaInfo = localMediaInfo;
        this.duration = j3;
        this.isFromCapture = z16;
        this.selectMusicMid = str3;
        this.selectMusicStart = num3;
        this.isBackGroundChanged = z17;
        this.useHD = i3;
        this.originVolume = f16;
        this.bgmVolume = f17;
        this.bgmVolumeType = bgmVolumeType;
        this.isSmartClipActive = z18;
        this.uiDataMap = map;
        this.businessName = businessName;
        this.isEnableSwitchEditMode = z19;
        this.preferredCoverTime = j16;
        this.musicId = l3;
        this.musicName = str4;
        this.isEnableMusic = z26;
        this.specifyCoverTs = j17;
        this.isFirstTemplate = z27;
        this.holderInfo = list;
        this.isFromQzoneText = z28;
        this.textQzoneText = str5;
        this.isFromTemplateColl = z29;
        this.backgroundMaterialList = backgroundMaterialList;
        this.backgroundMaterialIndex = i16;
        this.captureMaterialId = str6;
        this.enableImageTransition = z36;
        this.isHDRExporting = z37;
        this.extraMap = map2;
        this.isAutoTemplate = z38;
        this.isFromMemoryAlbum = z39;
        this.isFromQzoneDailySign = z46;
        this.captureMaterialName = str7;
        this.musicPath = str8;
        this.musicDuration = num4;
        this.watermarkConfig = watermarkConfig;
        this.isFromTemplateLib = z47;
    }

    public static /* synthetic */ WinkEditDataWrapper copy$default(WinkEditDataWrapper winkEditDataWrapper, String str, Integer num, ArrayList arrayList, ArrayList arrayList2, String str2, Integer num2, LocalMediaInfo localMediaInfo, long j3, boolean z16, String str3, Integer num3, boolean z17, int i3, float f16, float f17, MusicVolumeControlViewModel.VolumeType volumeType, boolean z18, Map map, String str4, boolean z19, long j16, Long l3, String str5, boolean z26, long j17, boolean z27, List list, boolean z28, String str6, boolean z29, ArrayList arrayList3, int i16, String str7, boolean z36, boolean z37, Map map2, boolean z38, boolean z39, boolean z46, String str8, String str9, Integer num4, WatermarkConfig watermarkConfig, boolean z47, int i17, int i18, Object obj) {
        String str10 = (i17 & 1) != 0 ? winkEditDataWrapper.missionId : str;
        Integer num5 = (i17 & 2) != 0 ? winkEditDataWrapper.editMode : num;
        ArrayList arrayList4 = (i17 & 4) != 0 ? winkEditDataWrapper.editDatas : arrayList;
        ArrayList arrayList5 = (i17 & 8) != 0 ? winkEditDataWrapper.originMediaInfos : arrayList2;
        String str11 = (i17 & 16) != 0 ? winkEditDataWrapper.templateFilePath : str2;
        Integer num6 = (i17 & 32) != 0 ? winkEditDataWrapper.from : num2;
        LocalMediaInfo localMediaInfo2 = (i17 & 64) != 0 ? winkEditDataWrapper.outMediaInfo : localMediaInfo;
        long j18 = (i17 & 128) != 0 ? winkEditDataWrapper.duration : j3;
        boolean z48 = (i17 & 256) != 0 ? winkEditDataWrapper.isFromCapture : z16;
        String str12 = (i17 & 512) != 0 ? winkEditDataWrapper.selectMusicMid : str3;
        Integer num7 = (i17 & 1024) != 0 ? winkEditDataWrapper.selectMusicStart : num3;
        return winkEditDataWrapper.copy(str10, num5, arrayList4, arrayList5, str11, num6, localMediaInfo2, j18, z48, str12, num7, (i17 & 2048) != 0 ? winkEditDataWrapper.isBackGroundChanged : z17, (i17 & 4096) != 0 ? winkEditDataWrapper.useHD : i3, (i17 & 8192) != 0 ? winkEditDataWrapper.originVolume : f16, (i17 & 16384) != 0 ? winkEditDataWrapper.bgmVolume : f17, (i17 & 32768) != 0 ? winkEditDataWrapper.bgmVolumeType : volumeType, (i17 & 65536) != 0 ? winkEditDataWrapper.isSmartClipActive : z18, (i17 & 131072) != 0 ? winkEditDataWrapper.uiDataMap : map, (i17 & 262144) != 0 ? winkEditDataWrapper.businessName : str4, (i17 & 524288) != 0 ? winkEditDataWrapper.isEnableSwitchEditMode : z19, (i17 & 1048576) != 0 ? winkEditDataWrapper.preferredCoverTime : j16, (i17 & 2097152) != 0 ? winkEditDataWrapper.musicId : l3, (4194304 & i17) != 0 ? winkEditDataWrapper.musicName : str5, (i17 & 8388608) != 0 ? winkEditDataWrapper.isEnableMusic : z26, (i17 & 16777216) != 0 ? winkEditDataWrapper.specifyCoverTs : j17, (i17 & 33554432) != 0 ? winkEditDataWrapper.isFirstTemplate : z27, (67108864 & i17) != 0 ? winkEditDataWrapper.holderInfo : list, (i17 & 134217728) != 0 ? winkEditDataWrapper.isFromQzoneText : z28, (i17 & 268435456) != 0 ? winkEditDataWrapper.textQzoneText : str6, (i17 & 536870912) != 0 ? winkEditDataWrapper.isFromTemplateColl : z29, (i17 & 1073741824) != 0 ? winkEditDataWrapper.backgroundMaterialList : arrayList3, (i17 & Integer.MIN_VALUE) != 0 ? winkEditDataWrapper.backgroundMaterialIndex : i16, (i18 & 1) != 0 ? winkEditDataWrapper.captureMaterialId : str7, (i18 & 2) != 0 ? winkEditDataWrapper.enableImageTransition : z36, (i18 & 4) != 0 ? winkEditDataWrapper.isHDRExporting : z37, (i18 & 8) != 0 ? winkEditDataWrapper.extraMap : map2, (i18 & 16) != 0 ? winkEditDataWrapper.isAutoTemplate : z38, (i18 & 32) != 0 ? winkEditDataWrapper.isFromMemoryAlbum : z39, (i18 & 64) != 0 ? winkEditDataWrapper.isFromQzoneDailySign : z46, (i18 & 128) != 0 ? winkEditDataWrapper.captureMaterialName : str8, (i18 & 256) != 0 ? winkEditDataWrapper.musicPath : str9, (i18 & 512) != 0 ? winkEditDataWrapper.musicDuration : num4, (i18 & 1024) != 0 ? winkEditDataWrapper.watermarkConfig : watermarkConfig, (i18 & 2048) != 0 ? winkEditDataWrapper.isFromTemplateLib : z47);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    /* renamed from: component10, reason: from getter */
    public final String getSelectMusicMid() {
        return this.selectMusicMid;
    }

    @Nullable
    /* renamed from: component11, reason: from getter */
    public final Integer getSelectMusicStart() {
        return this.selectMusicStart;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsBackGroundChanged() {
        return this.isBackGroundChanged;
    }

    /* renamed from: component13, reason: from getter */
    public final int getUseHD() {
        return this.useHD;
    }

    /* renamed from: component14, reason: from getter */
    public final float getOriginVolume() {
        return this.originVolume;
    }

    /* renamed from: component15, reason: from getter */
    public final float getBgmVolume() {
        return this.bgmVolume;
    }

    @NotNull
    /* renamed from: component16, reason: from getter */
    public final MusicVolumeControlViewModel.VolumeType getBgmVolumeType() {
        return this.bgmVolumeType;
    }

    /* renamed from: component17, reason: from getter */
    public final boolean getIsSmartClipActive() {
        return this.isSmartClipActive;
    }

    @Nullable
    public final Map<String, WinkEditUIData> component18() {
        return this.uiDataMap;
    }

    @NotNull
    /* renamed from: component19, reason: from getter */
    public final String getBusinessName() {
        return this.businessName;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Integer getEditMode() {
        return this.editMode;
    }

    /* renamed from: component20, reason: from getter */
    public final boolean getIsEnableSwitchEditMode() {
        return this.isEnableSwitchEditMode;
    }

    /* renamed from: component21, reason: from getter */
    public final long getPreferredCoverTime() {
        return this.preferredCoverTime;
    }

    @Nullable
    /* renamed from: component22, reason: from getter */
    public final Long getMusicId() {
        return this.musicId;
    }

    @Nullable
    /* renamed from: component23, reason: from getter */
    public final String getMusicName() {
        return this.musicName;
    }

    /* renamed from: component24, reason: from getter */
    public final boolean getIsEnableMusic() {
        return this.isEnableMusic;
    }

    /* renamed from: component25, reason: from getter */
    public final long getSpecifyCoverTs() {
        return this.specifyCoverTs;
    }

    /* renamed from: component26, reason: from getter */
    public final boolean getIsFirstTemplate() {
        return this.isFirstTemplate;
    }

    @Nullable
    public final List<TemplateLibraryHolderInfo> component27() {
        return this.holderInfo;
    }

    /* renamed from: component28, reason: from getter */
    public final boolean getIsFromQzoneText() {
        return this.isFromQzoneText;
    }

    @Nullable
    /* renamed from: component29, reason: from getter */
    public final String getTextQzoneText() {
        return this.textQzoneText;
    }

    @NotNull
    public final ArrayList<WinkEditData> component3() {
        return this.editDatas;
    }

    /* renamed from: component30, reason: from getter */
    public final boolean getIsFromTemplateColl() {
        return this.isFromTemplateColl;
    }

    @NotNull
    public final ArrayList<String> component31() {
        return this.backgroundMaterialList;
    }

    /* renamed from: component32, reason: from getter */
    public final int getBackgroundMaterialIndex() {
        return this.backgroundMaterialIndex;
    }

    @Nullable
    /* renamed from: component33, reason: from getter */
    public final String getCaptureMaterialId() {
        return this.captureMaterialId;
    }

    /* renamed from: component34, reason: from getter */
    public final boolean getEnableImageTransition() {
        return this.enableImageTransition;
    }

    /* renamed from: component35, reason: from getter */
    public final boolean getIsHDRExporting() {
        return this.isHDRExporting;
    }

    @Nullable
    public final Map<String, String> component36() {
        return this.extraMap;
    }

    /* renamed from: component37, reason: from getter */
    public final boolean getIsAutoTemplate() {
        return this.isAutoTemplate;
    }

    /* renamed from: component38, reason: from getter */
    public final boolean getIsFromMemoryAlbum() {
        return this.isFromMemoryAlbum;
    }

    /* renamed from: component39, reason: from getter */
    public final boolean getIsFromQzoneDailySign() {
        return this.isFromQzoneDailySign;
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> component4() {
        return this.originMediaInfos;
    }

    @Nullable
    /* renamed from: component40, reason: from getter */
    public final String getCaptureMaterialName() {
        return this.captureMaterialName;
    }

    @Nullable
    /* renamed from: component41, reason: from getter */
    public final String getMusicPath() {
        return this.musicPath;
    }

    @Nullable
    /* renamed from: component42, reason: from getter */
    public final Integer getMusicDuration() {
        return this.musicDuration;
    }

    @Nullable
    /* renamed from: component43, reason: from getter */
    public final WatermarkConfig getWatermarkConfig() {
        return this.watermarkConfig;
    }

    /* renamed from: component44, reason: from getter */
    public final boolean getIsFromTemplateLib() {
        return this.isFromTemplateLib;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final String getTemplateFilePath() {
        return this.templateFilePath;
    }

    @Nullable
    /* renamed from: component6, reason: from getter */
    public final Integer getFrom() {
        return this.from;
    }

    @Nullable
    /* renamed from: component7, reason: from getter */
    public final LocalMediaInfo getOutMediaInfo() {
        return this.outMediaInfo;
    }

    /* renamed from: component8, reason: from getter */
    public final long getDuration() {
        return this.duration;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getIsFromCapture() {
        return this.isFromCapture;
    }

    @NotNull
    public final WinkEditDataWrapper copy(@Nullable String missionId, @Nullable Integer editMode, @NotNull ArrayList<WinkEditData> editDatas, @Nullable ArrayList<LocalMediaInfo> originMediaInfos, @Nullable String templateFilePath, @Nullable Integer from, @Nullable LocalMediaInfo outMediaInfo, long duration, boolean isFromCapture, @Nullable String selectMusicMid, @Nullable Integer selectMusicStart, boolean isBackGroundChanged, int useHD, float originVolume, float bgmVolume, @NotNull MusicVolumeControlViewModel.VolumeType bgmVolumeType, boolean isSmartClipActive, @Nullable Map<String, WinkEditUIData> uiDataMap, @NotNull String businessName, boolean isEnableSwitchEditMode, long preferredCoverTime, @Nullable Long musicId, @Nullable String musicName, boolean isEnableMusic, long specifyCoverTs, boolean isFirstTemplate, @Nullable List<TemplateLibraryHolderInfo> holderInfo, boolean isFromQzoneText, @Nullable String textQzoneText, boolean isFromTemplateColl, @NotNull ArrayList<String> backgroundMaterialList, int backgroundMaterialIndex, @Nullable String captureMaterialId, boolean enableImageTransition, boolean isHDRExporting, @Nullable Map<String, String> extraMap, boolean isAutoTemplate, boolean isFromMemoryAlbum, boolean isFromQzoneDailySign, @Nullable String captureMaterialName, @Nullable String musicPath, @Nullable Integer musicDuration, @Nullable WatermarkConfig watermarkConfig, boolean isFromTemplateLib) {
        Intrinsics.checkNotNullParameter(editDatas, "editDatas");
        Intrinsics.checkNotNullParameter(bgmVolumeType, "bgmVolumeType");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(backgroundMaterialList, "backgroundMaterialList");
        return new WinkEditDataWrapper(missionId, editMode, editDatas, originMediaInfos, templateFilePath, from, outMediaInfo, duration, isFromCapture, selectMusicMid, selectMusicStart, isBackGroundChanged, useHD, originVolume, bgmVolume, bgmVolumeType, isSmartClipActive, uiDataMap, businessName, isEnableSwitchEditMode, preferredCoverTime, musicId, musicName, isEnableMusic, specifyCoverTs, isFirstTemplate, holderInfo, isFromQzoneText, textQzoneText, isFromTemplateColl, backgroundMaterialList, backgroundMaterialIndex, captureMaterialId, enableImageTransition, isHDRExporting, extraMap, isAutoTemplate, isFromMemoryAlbum, isFromQzoneDailySign, captureMaterialName, musicPath, musicDuration, watermarkConfig, isFromTemplateLib);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WinkEditDataWrapper)) {
            return false;
        }
        WinkEditDataWrapper winkEditDataWrapper = (WinkEditDataWrapper) other;
        if (Intrinsics.areEqual(this.missionId, winkEditDataWrapper.missionId) && Intrinsics.areEqual(this.editMode, winkEditDataWrapper.editMode) && Intrinsics.areEqual(this.editDatas, winkEditDataWrapper.editDatas) && Intrinsics.areEqual(this.originMediaInfos, winkEditDataWrapper.originMediaInfos) && Intrinsics.areEqual(this.templateFilePath, winkEditDataWrapper.templateFilePath) && Intrinsics.areEqual(this.from, winkEditDataWrapper.from) && Intrinsics.areEqual(this.outMediaInfo, winkEditDataWrapper.outMediaInfo) && this.duration == winkEditDataWrapper.duration && this.isFromCapture == winkEditDataWrapper.isFromCapture && Intrinsics.areEqual(this.selectMusicMid, winkEditDataWrapper.selectMusicMid) && Intrinsics.areEqual(this.selectMusicStart, winkEditDataWrapper.selectMusicStart) && this.isBackGroundChanged == winkEditDataWrapper.isBackGroundChanged && this.useHD == winkEditDataWrapper.useHD && Float.compare(this.originVolume, winkEditDataWrapper.originVolume) == 0 && Float.compare(this.bgmVolume, winkEditDataWrapper.bgmVolume) == 0 && this.bgmVolumeType == winkEditDataWrapper.bgmVolumeType && this.isSmartClipActive == winkEditDataWrapper.isSmartClipActive && Intrinsics.areEqual(this.uiDataMap, winkEditDataWrapper.uiDataMap) && Intrinsics.areEqual(this.businessName, winkEditDataWrapper.businessName) && this.isEnableSwitchEditMode == winkEditDataWrapper.isEnableSwitchEditMode && this.preferredCoverTime == winkEditDataWrapper.preferredCoverTime && Intrinsics.areEqual(this.musicId, winkEditDataWrapper.musicId) && Intrinsics.areEqual(this.musicName, winkEditDataWrapper.musicName) && this.isEnableMusic == winkEditDataWrapper.isEnableMusic && this.specifyCoverTs == winkEditDataWrapper.specifyCoverTs && this.isFirstTemplate == winkEditDataWrapper.isFirstTemplate && Intrinsics.areEqual(this.holderInfo, winkEditDataWrapper.holderInfo) && this.isFromQzoneText == winkEditDataWrapper.isFromQzoneText && Intrinsics.areEqual(this.textQzoneText, winkEditDataWrapper.textQzoneText) && this.isFromTemplateColl == winkEditDataWrapper.isFromTemplateColl && Intrinsics.areEqual(this.backgroundMaterialList, winkEditDataWrapper.backgroundMaterialList) && this.backgroundMaterialIndex == winkEditDataWrapper.backgroundMaterialIndex && Intrinsics.areEqual(this.captureMaterialId, winkEditDataWrapper.captureMaterialId) && this.enableImageTransition == winkEditDataWrapper.enableImageTransition && this.isHDRExporting == winkEditDataWrapper.isHDRExporting && Intrinsics.areEqual(this.extraMap, winkEditDataWrapper.extraMap) && this.isAutoTemplate == winkEditDataWrapper.isAutoTemplate && this.isFromMemoryAlbum == winkEditDataWrapper.isFromMemoryAlbum && this.isFromQzoneDailySign == winkEditDataWrapper.isFromQzoneDailySign && Intrinsics.areEqual(this.captureMaterialName, winkEditDataWrapper.captureMaterialName) && Intrinsics.areEqual(this.musicPath, winkEditDataWrapper.musicPath) && Intrinsics.areEqual(this.musicDuration, winkEditDataWrapper.musicDuration) && Intrinsics.areEqual(this.watermarkConfig, winkEditDataWrapper.watermarkConfig) && this.isFromTemplateLib == winkEditDataWrapper.isFromTemplateLib) {
            return true;
        }
        return false;
    }

    public final int getBackgroundMaterialIndex() {
        return this.backgroundMaterialIndex;
    }

    @NotNull
    public final ArrayList<String> getBackgroundMaterialList() {
        return this.backgroundMaterialList;
    }

    public final float getBgmVolume() {
        return this.bgmVolume;
    }

    @NotNull
    public final MusicVolumeControlViewModel.VolumeType getBgmVolumeType() {
        return this.bgmVolumeType;
    }

    @NotNull
    public final String getBusinessName() {
        return this.businessName;
    }

    @Nullable
    public final String getCaptureMaterialId() {
        return this.captureMaterialId;
    }

    @Nullable
    public final String getCaptureMaterialName() {
        return this.captureMaterialName;
    }

    public final long getDuration() {
        return this.duration;
    }

    @NotNull
    public final ArrayList<WinkEditData> getEditDatas() {
        return this.editDatas;
    }

    @Nullable
    public final Integer getEditMode() {
        return this.editMode;
    }

    public final boolean getEnableImageTransition() {
        return this.enableImageTransition;
    }

    @Nullable
    public final Map<String, String> getExtraMap() {
        return this.extraMap;
    }

    @Nullable
    public final Integer getFrom() {
        return this.from;
    }

    @Nullable
    public final List<TemplateLibraryHolderInfo> getHolderInfo() {
        return this.holderInfo;
    }

    @Nullable
    public final String getMissionId() {
        return this.missionId;
    }

    @Nullable
    public final Integer getMusicDuration() {
        return this.musicDuration;
    }

    @Nullable
    public final Long getMusicId() {
        return this.musicId;
    }

    @Nullable
    public final String getMusicName() {
        return this.musicName;
    }

    @Nullable
    public final String getMusicPath() {
        return this.musicPath;
    }

    @Nullable
    public final ArrayList<LocalMediaInfo> getOriginMediaInfos() {
        return this.originMediaInfos;
    }

    public final float getOriginVolume() {
        return this.originVolume;
    }

    @Nullable
    public final LocalMediaInfo getOutMediaInfo() {
        return this.outMediaInfo;
    }

    public final long getPreferredCoverTime() {
        return this.preferredCoverTime;
    }

    @Nullable
    public final String getSelectMusicMid() {
        return this.selectMusicMid;
    }

    @Nullable
    public final Integer getSelectMusicStart() {
        return this.selectMusicStart;
    }

    public final long getSpecifyCoverTs() {
        return this.specifyCoverTs;
    }

    @Nullable
    public final String getTemplateFilePath() {
        return this.templateFilePath;
    }

    @Nullable
    public final String getTextQzoneText() {
        return this.textQzoneText;
    }

    @Nullable
    public final Map<String, WinkEditUIData> getUiDataMap() {
        return this.uiDataMap;
    }

    public final int getUseHD() {
        return this.useHD;
    }

    @Nullable
    public final WatermarkConfig getWatermarkConfig() {
        return this.watermarkConfig;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int hashCode17;
        int hashCode18;
        String str = this.missionId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        Integer num = this.editMode;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int hashCode19 = (((i16 + hashCode2) * 31) + this.editDatas.hashCode()) * 31;
        ArrayList<LocalMediaInfo> arrayList = this.originMediaInfos;
        if (arrayList == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = arrayList.hashCode();
        }
        int i17 = (hashCode19 + hashCode3) * 31;
        String str2 = this.templateFilePath;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i18 = (i17 + hashCode4) * 31;
        Integer num2 = this.from;
        if (num2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = num2.hashCode();
        }
        int i19 = (i18 + hashCode5) * 31;
        LocalMediaInfo localMediaInfo = this.outMediaInfo;
        if (localMediaInfo == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = localMediaInfo.hashCode();
        }
        int a16 = (((i19 + hashCode6) * 31) + androidx.fragment.app.a.a(this.duration)) * 31;
        boolean z16 = this.isFromCapture;
        int i26 = 1;
        int i27 = z16;
        if (z16 != 0) {
            i27 = 1;
        }
        int i28 = (a16 + i27) * 31;
        String str3 = this.selectMusicMid;
        if (str3 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str3.hashCode();
        }
        int i29 = (i28 + hashCode7) * 31;
        Integer num3 = this.selectMusicStart;
        if (num3 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = num3.hashCode();
        }
        int i36 = (i29 + hashCode8) * 31;
        boolean z17 = this.isBackGroundChanged;
        int i37 = z17;
        if (z17 != 0) {
            i37 = 1;
        }
        int floatToIntBits = (((((((((i36 + i37) * 31) + this.useHD) * 31) + Float.floatToIntBits(this.originVolume)) * 31) + Float.floatToIntBits(this.bgmVolume)) * 31) + this.bgmVolumeType.hashCode()) * 31;
        boolean z18 = this.isSmartClipActive;
        int i38 = z18;
        if (z18 != 0) {
            i38 = 1;
        }
        int i39 = (floatToIntBits + i38) * 31;
        Map<String, WinkEditUIData> map = this.uiDataMap;
        if (map == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = map.hashCode();
        }
        int hashCode20 = (((i39 + hashCode9) * 31) + this.businessName.hashCode()) * 31;
        boolean z19 = this.isEnableSwitchEditMode;
        int i46 = z19;
        if (z19 != 0) {
            i46 = 1;
        }
        int a17 = (((hashCode20 + i46) * 31) + androidx.fragment.app.a.a(this.preferredCoverTime)) * 31;
        Long l3 = this.musicId;
        if (l3 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = l3.hashCode();
        }
        int i47 = (a17 + hashCode10) * 31;
        String str4 = this.musicName;
        if (str4 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str4.hashCode();
        }
        int i48 = (i47 + hashCode11) * 31;
        boolean z26 = this.isEnableMusic;
        int i49 = z26;
        if (z26 != 0) {
            i49 = 1;
        }
        int a18 = (((i48 + i49) * 31) + androidx.fragment.app.a.a(this.specifyCoverTs)) * 31;
        boolean z27 = this.isFirstTemplate;
        int i56 = z27;
        if (z27 != 0) {
            i56 = 1;
        }
        int i57 = (a18 + i56) * 31;
        List<TemplateLibraryHolderInfo> list = this.holderInfo;
        if (list == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = list.hashCode();
        }
        int i58 = (i57 + hashCode12) * 31;
        boolean z28 = this.isFromQzoneText;
        int i59 = z28;
        if (z28 != 0) {
            i59 = 1;
        }
        int i65 = (i58 + i59) * 31;
        String str5 = this.textQzoneText;
        if (str5 == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = str5.hashCode();
        }
        int i66 = (i65 + hashCode13) * 31;
        boolean z29 = this.isFromTemplateColl;
        int i67 = z29;
        if (z29 != 0) {
            i67 = 1;
        }
        int hashCode21 = (((((i66 + i67) * 31) + this.backgroundMaterialList.hashCode()) * 31) + this.backgroundMaterialIndex) * 31;
        String str6 = this.captureMaterialId;
        if (str6 == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = str6.hashCode();
        }
        int i68 = (hashCode21 + hashCode14) * 31;
        boolean z36 = this.enableImageTransition;
        int i69 = z36;
        if (z36 != 0) {
            i69 = 1;
        }
        int i75 = (i68 + i69) * 31;
        boolean z37 = this.isHDRExporting;
        int i76 = z37;
        if (z37 != 0) {
            i76 = 1;
        }
        int i77 = (i75 + i76) * 31;
        Map<String, String> map2 = this.extraMap;
        if (map2 == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = map2.hashCode();
        }
        int i78 = (i77 + hashCode15) * 31;
        boolean z38 = this.isAutoTemplate;
        int i79 = z38;
        if (z38 != 0) {
            i79 = 1;
        }
        int i85 = (i78 + i79) * 31;
        boolean z39 = this.isFromMemoryAlbum;
        int i86 = z39;
        if (z39 != 0) {
            i86 = 1;
        }
        int i87 = (i85 + i86) * 31;
        boolean z46 = this.isFromQzoneDailySign;
        int i88 = z46;
        if (z46 != 0) {
            i88 = 1;
        }
        int i89 = (i87 + i88) * 31;
        String str7 = this.captureMaterialName;
        if (str7 == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = str7.hashCode();
        }
        int i95 = (i89 + hashCode16) * 31;
        String str8 = this.musicPath;
        if (str8 == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = str8.hashCode();
        }
        int i96 = (i95 + hashCode17) * 31;
        Integer num4 = this.musicDuration;
        if (num4 == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = num4.hashCode();
        }
        int i97 = (i96 + hashCode18) * 31;
        WatermarkConfig watermarkConfig = this.watermarkConfig;
        if (watermarkConfig != null) {
            i3 = watermarkConfig.hashCode();
        }
        int i98 = (i97 + i3) * 31;
        boolean z47 = this.isFromTemplateLib;
        if (!z47) {
            i26 = z47 ? 1 : 0;
        }
        return i98 + i26;
    }

    public final boolean isAutoTemplate() {
        return this.isAutoTemplate;
    }

    public final boolean isBackGroundChanged() {
        return this.isBackGroundChanged;
    }

    public final boolean isEnableMusic() {
        return this.isEnableMusic;
    }

    public final boolean isEnableSwitchEditMode() {
        return this.isEnableSwitchEditMode;
    }

    public final boolean isFirstTemplate() {
        return this.isFirstTemplate;
    }

    public final boolean isFromCapture() {
        return this.isFromCapture;
    }

    public final boolean isFromMemoryAlbum() {
        return this.isFromMemoryAlbum;
    }

    public final boolean isFromQzoneDailySign() {
        return this.isFromQzoneDailySign;
    }

    public final boolean isFromQzoneText() {
        return this.isFromQzoneText;
    }

    public final boolean isFromTemplateColl() {
        return this.isFromTemplateColl;
    }

    public final boolean isFromTemplateLib() {
        return this.isFromTemplateLib;
    }

    public final boolean isHDRExporting() {
        return this.isHDRExporting;
    }

    public final boolean isSmartClipActive() {
        return this.isSmartClipActive;
    }

    public final void setAutoTemplate(boolean z16) {
        this.isAutoTemplate = z16;
    }

    public final void setBackGroundChanged(boolean z16) {
        this.isBackGroundChanged = z16;
    }

    public final void setBackgroundMaterialIndex(int i3) {
        this.backgroundMaterialIndex = i3;
    }

    public final void setBackgroundMaterialList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.backgroundMaterialList = arrayList;
    }

    public final void setBgmVolume(float f16) {
        this.bgmVolume = f16;
    }

    public final void setBgmVolumeType(@NotNull MusicVolumeControlViewModel.VolumeType volumeType) {
        Intrinsics.checkNotNullParameter(volumeType, "<set-?>");
        this.bgmVolumeType = volumeType;
    }

    public final void setBusinessName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.businessName = str;
    }

    public final void setCaptureMaterialId(@Nullable String str) {
        this.captureMaterialId = str;
    }

    public final void setCaptureMaterialName(@Nullable String str) {
        this.captureMaterialName = str;
    }

    public final void setDuration(long j3) {
        this.duration = j3;
    }

    public final void setEditMode(@Nullable Integer num) {
        this.editMode = num;
    }

    public final void setEnableImageTransition(boolean z16) {
        this.enableImageTransition = z16;
    }

    public final void setEnableMusic(boolean z16) {
        this.isEnableMusic = z16;
    }

    public final void setEnableSwitchEditMode(boolean z16) {
        this.isEnableSwitchEditMode = z16;
    }

    public final void setExtraMap(@Nullable Map<String, String> map) {
        this.extraMap = map;
    }

    public final void setFirstTemplate(boolean z16) {
        this.isFirstTemplate = z16;
    }

    public final void setFrom(@Nullable Integer num) {
        this.from = num;
    }

    public final void setFromCapture(boolean z16) {
        this.isFromCapture = z16;
    }

    public final void setFromQzoneText(boolean z16) {
        this.isFromQzoneText = z16;
    }

    public final void setFromTemplateColl(boolean z16) {
        this.isFromTemplateColl = z16;
    }

    public final void setFromTemplateLib(boolean z16) {
        this.isFromTemplateLib = z16;
    }

    public final void setHDRExporting(boolean z16) {
        this.isHDRExporting = z16;
    }

    public final void setHolderInfo(@Nullable List<TemplateLibraryHolderInfo> list) {
        this.holderInfo = list;
    }

    public final void setMusicDuration(@Nullable Integer num) {
        this.musicDuration = num;
    }

    public final void setMusicId(@Nullable Long l3) {
        this.musicId = l3;
    }

    public final void setMusicName(@Nullable String str) {
        this.musicName = str;
    }

    public final void setMusicPath(@Nullable String str) {
        this.musicPath = str;
    }

    public final void setOriginVolume(float f16) {
        this.originVolume = f16;
    }

    public final void setOutMediaInfo(@Nullable LocalMediaInfo localMediaInfo) {
        this.outMediaInfo = localMediaInfo;
    }

    public final void setPreferredCoverTime(long j3) {
        this.preferredCoverTime = j3;
    }

    public final void setSelectMusicMid(@Nullable String str) {
        this.selectMusicMid = str;
    }

    public final void setSelectMusicStart(@Nullable Integer num) {
        this.selectMusicStart = num;
    }

    public final void setSmartClipActive(boolean z16) {
        this.isSmartClipActive = z16;
    }

    public final void setSpecifyCoverTs(long j3) {
        this.specifyCoverTs = j3;
    }

    public final void setTemplateFilePath(@Nullable String str) {
        this.templateFilePath = str;
    }

    public final void setTextQzoneText(@Nullable String str) {
        this.textQzoneText = str;
    }

    public final void setUseHD(int i3) {
        this.useHD = i3;
    }

    public final void setWatermarkConfig(@Nullable WatermarkConfig watermarkConfig) {
        this.watermarkConfig = watermarkConfig;
    }

    @NotNull
    public String toString() {
        return "WinkEditDataWrapper(missionId=" + this.missionId + ", editMode=" + this.editMode + ", editDatas=" + this.editDatas + ", originMediaInfos=" + this.originMediaInfos + ", templateFilePath=" + this.templateFilePath + ", from=" + this.from + ", outMediaInfo=" + this.outMediaInfo + ", duration=" + this.duration + ", isFromCapture=" + this.isFromCapture + ", selectMusicMid=" + this.selectMusicMid + ", selectMusicStart=" + this.selectMusicStart + ", isBackGroundChanged=" + this.isBackGroundChanged + ", useHD=" + this.useHD + ", originVolume=" + this.originVolume + ", bgmVolume=" + this.bgmVolume + ", bgmVolumeType=" + this.bgmVolumeType + ", isSmartClipActive=" + this.isSmartClipActive + ", uiDataMap=" + this.uiDataMap + ", businessName=" + this.businessName + ", isEnableSwitchEditMode=" + this.isEnableSwitchEditMode + ", preferredCoverTime=" + this.preferredCoverTime + ", musicId=" + this.musicId + ", musicName=" + this.musicName + ", isEnableMusic=" + this.isEnableMusic + ", specifyCoverTs=" + this.specifyCoverTs + ", isFirstTemplate=" + this.isFirstTemplate + ", holderInfo=" + this.holderInfo + ", isFromQzoneText=" + this.isFromQzoneText + ", textQzoneText=" + this.textQzoneText + ", isFromTemplateColl=" + this.isFromTemplateColl + ", backgroundMaterialList=" + this.backgroundMaterialList + ", backgroundMaterialIndex=" + this.backgroundMaterialIndex + ", captureMaterialId=" + this.captureMaterialId + ", enableImageTransition=" + this.enableImageTransition + ", isHDRExporting=" + this.isHDRExporting + ", extraMap=" + this.extraMap + ", isAutoTemplate=" + this.isAutoTemplate + ", isFromMemoryAlbum=" + this.isFromMemoryAlbum + ", isFromQzoneDailySign=" + this.isFromQzoneDailySign + ", captureMaterialName=" + this.captureMaterialName + ", musicPath=" + this.musicPath + ", musicDuration=" + this.musicDuration + ", watermarkConfig=" + this.watermarkConfig + ", isFromTemplateLib=" + this.isFromTemplateLib + ")";
    }

    public /* synthetic */ WinkEditDataWrapper(String str, Integer num, ArrayList arrayList, ArrayList arrayList2, String str2, Integer num2, LocalMediaInfo localMediaInfo, long j3, boolean z16, String str3, Integer num3, boolean z17, int i3, float f16, float f17, MusicVolumeControlViewModel.VolumeType volumeType, boolean z18, Map map, String str4, boolean z19, long j16, Long l3, String str5, boolean z26, long j17, boolean z27, List list, boolean z28, String str6, boolean z29, ArrayList arrayList3, int i16, String str7, boolean z36, boolean z37, Map map2, boolean z38, boolean z39, boolean z46, String str8, String str9, Integer num4, WatermarkConfig watermarkConfig, boolean z47, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? null : str, (i17 & 2) != 0 ? 0 : num, (i17 & 4) != 0 ? new ArrayList() : arrayList, (i17 & 8) != 0 ? null : arrayList2, (i17 & 16) != 0 ? null : str2, (i17 & 32) != 0 ? 0 : num2, (i17 & 64) != 0 ? null : localMediaInfo, j3, z16, str3, num3, (i17 & 2048) != 0 ? false : z17, (i17 & 4096) != 0 ? 0 : i3, (i17 & 8192) != 0 ? 0.0f : f16, (i17 & 16384) != 0 ? 0.0f : f17, (32768 & i17) != 0 ? MusicVolumeControlViewModel.VolumeType.NONE : volumeType, (65536 & i17) != 0 ? false : z18, (131072 & i17) != 0 ? null : map, (262144 & i17) != 0 ? "QCIRCLE" : str4, (524288 & i17) != 0 ? true : z19, (1048576 & i17) != 0 ? 0L : j16, l3, str5, (8388608 & i17) != 0 ? true : z26, (16777216 & i17) != 0 ? 0L : j17, (33554432 & i17) != 0 ? false : z27, (67108864 & i17) != 0 ? null : list, (134217728 & i17) != 0 ? false : z28, (268435456 & i17) != 0 ? null : str6, (536870912 & i17) != 0 ? false : z29, (1073741824 & i17) != 0 ? new ArrayList() : arrayList3, (i17 & Integer.MIN_VALUE) != 0 ? 0 : i16, (i18 & 1) != 0 ? null : str7, (i18 & 2) != 0 ? false : z36, (i18 & 4) != 0 ? false : z37, (i18 & 8) != 0 ? null : map2, (i18 & 16) != 0 ? false : z38, (i18 & 32) != 0 ? false : z39, (i18 & 64) != 0 ? false : z46, (i18 & 128) != 0 ? null : str8, (i18 & 256) != 0 ? null : str9, (i18 & 512) != 0 ? 0 : num4, (i18 & 1024) != 0 ? null : watermarkConfig, (i18 & 2048) != 0 ? false : z47);
    }
}
