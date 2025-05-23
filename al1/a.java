package al1;

import android.view.ViewGroup;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import qj1.b;
import wk1.i;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0014\u0010\u000e\u001a\u00020\b2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH&J\b\u0010\u000f\u001a\u00020\bH&J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0004H&\u00a8\u0006\u0012"}, d2 = {"Lal1/a;", "Lwk1/i;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/bottom/permission/SpeakPermissionType;", "speakPermission", "", "N4", "Landroid/view/ViewGroup;", "parentView", "", "D5", "zc", "Lqj1/b;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IBottomInteractDisplayable;", "data", "E7", "V4", "enable", "u1", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a extends i {
    void D5(@NotNull ViewGroup parentView, @NotNull SpeakPermissionType speakPermission);

    void E7(@NotNull b data);

    boolean N4(@NotNull SpeakPermissionType speakPermission);

    void V4();

    void u1(boolean enable);

    void zc(@NotNull ViewGroup parentView, @NotNull SpeakPermissionType speakPermission);
}
