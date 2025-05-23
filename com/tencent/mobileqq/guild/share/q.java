package com.tencent.mobileqq.guild.share;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.widget.ActionSheet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ:\u0010\u0014\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0010J.\u0010\u0017\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0010R*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/share/q;", "", "Landroid/view/View;", "itemView", "Landroid/widget/ImageView;", "iconView", "Landroid/widget/TextView;", "nickView", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "sheetItem", "", "a", "Lcom/tencent/widget/ActionSheet;", "actionSheet", "Lcom/tencent/mobileqq/guild/data/GuildSharePageSource;", "source", "", "guildId", "channelId", "feedId", "c", "sessionId", "messageId", "b", "", "Ljava/util/List;", "getOperationItems", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "operationItems", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class q {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends ShareActionSheetBuilder.ActionSheetItem> operationItems;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/share/q$a;", "", "", "action", "", "b", "uinType", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.share.q$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a(int uinType, int action) {
            if (uinType != 0) {
                if (uinType != 1) {
                    if (uinType != 10027) {
                        return "other";
                    }
                    return WadlProxyConsts.CHANNEL;
                }
                return "grp";
            }
            if (action == 73) {
                return "more";
            }
            return "c2c";
        }

        @NotNull
        public final String b(int action) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 9) {
                            if (action != 10) {
                                if (action != 39) {
                                    if (action != 123) {
                                        if (action != 153) {
                                            if (action != 171) {
                                                if (action != 213) {
                                                    if (action != 218) {
                                                        if (action != 196) {
                                                            if (action != 197) {
                                                                return "other";
                                                            }
                                                        }
                                                    } else {
                                                        return "redbook";
                                                    }
                                                } else {
                                                    return "copy_channel_code";
                                                }
                                            } else {
                                                return WadlProxyConsts.CHANNEL;
                                            }
                                        } else {
                                            return "generate_pic";
                                        }
                                    }
                                    return "qr";
                                }
                                return "save";
                            }
                            return "wechat_moments";
                        }
                        return "wechat_contacts";
                    }
                    return "qzone";
                }
                return "qq";
            }
            return "copylink";
        }

        Companion() {
        }
    }

    public static /* synthetic */ void d(q qVar, ActionSheet actionSheet, GuildSharePageSource guildSharePageSource, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            str3 = null;
        }
        qVar.c(actionSheet, guildSharePageSource, str, str2, str3);
    }

    public final void a(@Nullable View itemView, @Nullable ImageView iconView, @NotNull TextView nickView, @NotNull ShareActionSheetBuilder.ActionSheetItem sheetItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(nickView, "nickView");
        Intrinsics.checkNotNullParameter(sheetItem, "sheetItem");
        int i3 = sheetItem.action;
        if (i3 != 73 && i3 != 72) {
            List<? extends ShareActionSheetBuilder.ActionSheetItem> list = this.operationItems;
            Object obj = null;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((ShareActionSheetBuilder.ActionSheetItem) next).action == sheetItem.action) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        obj = next;
                        break;
                    }
                }
                obj = (ShareActionSheetBuilder.ActionSheetItem) obj;
            }
            if (obj != null) {
                VideoReport.setElementId(itemView, "em_sgrp_forum_operate_btn");
                VideoReport.setElementParam(itemView, "sgrp_btn_name", nickView.getText().toString());
                VideoReport.setElementParam(itemView, "sgrp_share_source", INSTANCE.b(sheetItem.action));
                return;
            } else {
                VideoReport.setElementId(itemView, "em_sgrp_share_item");
                VideoReport.setElementParam(itemView, "sgrp_btn_name", nickView.getText().toString());
                VideoReport.setElementParam(itemView, "sgrp_share_source", INSTANCE.b(sheetItem.action));
                return;
            }
        }
        VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementId(itemView, "em_sgrp_share_panel_more_contacts");
        VideoReport.setElementParam(itemView, ShortVideoConstants.TO_UIN_TYPE, INSTANCE.a(sheetItem.uinType, sheetItem.action));
        VideoReport.setElementParam(itemView, "sgrp_channel_id", sheetItem.guildId);
    }

    public final void b(@Nullable ActionSheet actionSheet, @Nullable GuildSharePageSource source, @Nullable String sessionId, @Nullable String messageId) {
        int ordinal;
        Map mutableMapOf;
        VideoReport.setPageId(actionSheet, "pg_qdesign_shareview");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("biz_source", "biz_src_jc_qqstation");
        if (source != null) {
            ordinal = source.ordinal();
        } else {
            ordinal = GuildSharePageSource.UNKNOWN.ordinal();
        }
        pairArr[1] = TuplesKt.to(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(ordinal));
        pairArr[2] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (sessionId != null) {
            mutableMapOf.put("sgrp_ai_session_id", sessionId);
        }
        if (messageId != null) {
            mutableMapOf.put("sgrp_dialog_id", messageId);
        }
        mutableMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(actionSheet, new PageParams((Map<String, ?>) mutableMapOf));
    }

    public final void c(@Nullable ActionSheet actionSheet, @Nullable GuildSharePageSource source, @Nullable String guildId, @Nullable String channelId, @Nullable String feedId) {
        int ordinal;
        Map mutableMapOf;
        VideoReport.setPageId(actionSheet, "pg_qdesign_shareview");
        Pair[] pairArr = new Pair[3];
        pairArr[0] = TuplesKt.to("biz_source", "biz_src_jc_qqstation");
        if (source != null) {
            ordinal = source.ordinal();
        } else {
            ordinal = GuildSharePageSource.UNKNOWN.ordinal();
        }
        pairArr[1] = TuplesKt.to(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(ordinal));
        pairArr[2] = TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        if (guildId != null) {
            mutableMapOf.put("sgrp_channel_id", guildId);
            mutableMapOf.put("sgrp_user_type", Integer.valueOf(com.tencent.mobileqq.guild.data.v.c(guildId)));
        }
        if (channelId != null) {
            mutableMapOf.put("sgrp_sub_channel_id", channelId);
        }
        if (feedId != null) {
            mutableMapOf.put("sgrp_content_id", feedId);
            mutableMapOf.put("sgrp_feed_id", feedId);
        }
        mutableMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(actionSheet, new PageParams((Map<String, ?>) mutableMapOf));
    }

    public final void e(@Nullable List<? extends ShareActionSheetBuilder.ActionSheetItem> list) {
        this.operationItems = list;
    }
}
